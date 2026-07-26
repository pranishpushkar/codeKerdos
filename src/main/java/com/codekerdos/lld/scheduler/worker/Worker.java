package com.codekerdos.lld.scheduler;

import scheduler.model.JobStatus;
import scheduler.model.JobType;
import scheduler.model.ScheduledJob;
import scheduler.queue.JobQueue;

public class Worker implements Runnable {

    private final JobQueue jobQueue;

    private volatile boolean shutdown;

    public Worker(JobQueue jobQueue) {

        this.jobQueue = jobQueue;

    }

    public void shutdown() {

        shutdown = true;

        jobQueue.wakeUp();

    }

    @Override
    public void run() {

        while (!shutdown) {

            try {

                ScheduledJob job = jobQueue.take();

                if (job == null) {
                    continue;
                }

                if (job.getJobStatus() == JobStatus.CANCELLED) {
                    continue;
                }

                job.setJobStatus(JobStatus.RUNNING);

                job.getTask().run();

                if (job.getJobType() == JobType.RECURRING &&
                        job.getJobStatus() != JobStatus.CANCELLED) {

                    job.setJobStatus(JobStatus.SCHEDULED);

                    job.setNextExecutionTime(
                            System.currentTimeMillis()
                                    + job.getRepeatInterval());

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