package com.codekerdos.lld.scheduler.worker;

import com.codekerdos.lld.scheduler.model.JobStatus;
import com.codekerdos.lld.scheduler.model.JobType;
import com.codekerdos.lld.scheduler.model.ScheduledJob;
import com.codekerdos.lld.scheduler.queue.JobQueue;

public class Worker implements Runnable {

    private final JobQueue jobQueue;

    private volatile boolean shutdown;

    public Worker(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    public void shutdown() {
        shutdown = true;
    }

    @Override
    public void run() {

        while (!shutdown) {

            try {

                // Nothing to execute
                if (jobQueue.isEmpty()) {
                    jobQueue.waitForNewJob();
                    continue;
                }

                // Look at the earliest job
                ScheduledJob job = jobQueue.peek();

                // Wait until its execution time.
                // If another earlier job arrives, start over.
                if (!jobQueue.waitUntil(job.getNextExecutionTime())) {
                    continue;
                }

                // Time has arrived. Remove it from the queue.
                job = jobQueue.poll();

                if (job == null) {
                    continue;
                }

                if (job.getJobStatus() == JobStatus.CANCELLED) {
                    continue;
                }

                job.setJobStatus(JobStatus.RUNNING);

                job.getTask().run();

                if (job.getJobType() == JobType.RECURRING
                        && job.getJobStatus() != JobStatus.CANCELLED) {

                    job.setJobStatus(JobStatus.SCHEDULED);

                    job.setNextExecutionTime(
                            System.currentTimeMillis() + job.getRepeatInterval()
                    );

                    jobQueue.addJob(job);

                } else {

                    job.setJobStatus(JobStatus.COMPLETED);

                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;

            }

        }
    }
}