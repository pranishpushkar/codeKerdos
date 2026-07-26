package com.codekerdos.lld.scheduler.scheduler;

import scheduler.model.ScheduledJob;
import scheduler.queue.JobQueue;

public class JobHandle {

    private final ScheduledJob scheduledJob;

    private final JobQueue jobQueue;

    public JobHandle(ScheduledJob scheduledJob,
                     JobQueue jobQueue) {

        this.scheduledJob = scheduledJob;
        this.jobQueue = jobQueue;
    }

    public String getJobId() {
        return scheduledJob.getJobId();
    }

    public boolean cancel() {

        jobQueue.cancel(scheduledJob);

        return true;
    }
}