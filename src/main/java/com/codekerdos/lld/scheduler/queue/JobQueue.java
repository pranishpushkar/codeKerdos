package com.codekerdos.lld.scheduler.queue;

import com.codekerdos.lld.scheduler.model.JobStatus;
import com.codekerdos.lld.scheduler.model.ScheduledJob;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JobQueue {

    private final PriorityQueue<ScheduledJob> priorityQueue;

    private final ReentrantLock lock;

    private final Condition newJobArrived;

    public JobQueue() {

        this.priorityQueue = new PriorityQueue<>();

        this.lock = new ReentrantLock();

        this.newJobArrived = lock.newCondition();
    }

    /**
     * Adds a new job into the scheduler.
     */
    public void addJob(ScheduledJob job) {

        lock.lock();

        try {

            priorityQueue.offer(job);

            /*
             * Wake the worker.
             *
             * Why?
             *
             * The worker may currently be:
             *
             * 1. Waiting because the queue is empty.
             *
             * OR
             *
             * 2. Waiting for another job that was scheduled
             *    further in the future.
             *
             * This newly inserted job might execute earlier.
             */
            newJobArrived.signal();

        } finally {

            lock.unlock();

        }
    }

    /**
     * Returns the next job without removing it.
     */
    public ScheduledJob peek() {

        lock.lock();

        try {

            return priorityQueue.peek();

        } finally {

            lock.unlock();

        }
    }

    /**
     * Removes and returns the highest priority job.
     */
    public ScheduledJob poll() {

        lock.lock();

        try {

            return priorityQueue.poll();

        } finally {

            lock.unlock();

        }
    }

    public boolean isEmpty() {

        lock.lock();

        try {

            return priorityQueue.isEmpty();

        } finally {

            lock.unlock();

        }
    }

    /**
     * Worker waits here whenever
     * there is nothing useful to do.
     */
    public void waitForNewJob() throws InterruptedException {

        lock.lock();

        try {

            while (priorityQueue.isEmpty()) {

                newJobArrived.await();

            }

        } finally {

            lock.unlock();

        }
    }

    /**
     * Wait until the given execution time.
     *
     * Returns true if timeout expired.
     *
     * Returns false if another job arrived
     * before the timeout.
     */
    public boolean waitUntil(long executionTime)
            throws InterruptedException {

        lock.lock();

        try {

            while (true) {

                long remainingTime =
                        executionTime - System.currentTimeMillis();

                if (remainingTime <= 0) {
                    return true;
                }

                long remainingNanos =
                        newJobArrived.awaitNanos(
                                remainingTime * 1_000_000
                        );

                /*
                 * If another thread inserted a job,
                 * the worker should immediately
                 * re-evaluate the queue.
                 */
                if (remainingNanos > 0) {
                    return false;
                }
            }

        } finally {

            lock.unlock();

        }
    }

    /**
     * Lazy cancellation.
     *
     * Worker will skip cancelled jobs.
     */
    public void cancel(ScheduledJob job) {

        lock.lock();

        try {

            job.setJobStatus(JobStatus.CANCELLED);

            newJobArrived.signal();

        } finally {

            lock.unlock();

        }
    }
}