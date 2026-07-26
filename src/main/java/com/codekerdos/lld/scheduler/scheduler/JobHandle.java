package com.codekerdos.lld.scheduler.scheduler;

import com.codekerdos.lld.scheduler.model.ScheduledJob;
import com.codekerdos.lld.scheduler.queue.JobQueue;

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