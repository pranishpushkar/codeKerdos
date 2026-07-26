package com.codekerdos.lld.scheduler.model;

import java.util.UUID;

public class ScheduledJob implements Comparable<ScheduledJob> {

    private final String jobId;

    private final Runnable task;

    // Epoch time (milliseconds) when this job should execute next.
    private long nextExecutionTime;

    // Used only for recurring jobs.
    // For one-time jobs this will be zero.
    private final long repeatInterval;

    private final JobType jobType;

    private JobStatus jobStatus;

    public ScheduledJob(
            Runnable task,
            long nextExecutionTime,
            long repeatInterval,
            JobType jobType) {

        this.jobId = UUID.randomUUID().toString();
        this.task = task;
        this.nextExecutionTime = nextExecutionTime;
        this.repeatInterval = repeatInterval;
        this.jobType = jobType;
        this.jobStatus = JobStatus.SCHEDULED;
    }

    public String getJobId() {
        return jobId;
    }

    public Runnable getTask() {
        return task;
    }

    public long getNextExecutionTime() {
        return nextExecutionTime;
    }

    public void setNextExecutionTime(long nextExecutionTime) {
        this.nextExecutionTime = nextExecutionTime;
    }

    public long getRepeatInterval() {
        return repeatInterval;
    }

    public JobType getJobType() {
        return jobType;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public int compareTo(ScheduledJob otherJob) {
        return Long.compare(this.nextExecutionTime, otherJob.nextExecutionTime);
    }

    @Override
    public String toString() {
        return "ScheduledJob{" +
                "jobId='" + jobId + '\'' +
                ", nextExecutionTime=" + nextExecutionTime +
                ", repeatInterval=" + repeatInterval +
                ", jobType=" + jobType +
                ", jobStatus=" + jobStatus +
                '}';
    }
}