package com.codekerdos.lld.scheduler.scheduler;

import com.codekerdos.lld.scheduler.model.JobType;
import com.codekerdos.lld.scheduler.model.ScheduledJob;
import com.codekerdos.lld.scheduler.queue.JobQueue;
import com.codekerdos.lld.scheduler.worker.Worker;

import java.util.concurrent.TimeUnit;

public class SchedulerImpl implements Scheduler {

    private final JobQueue jobQueue;

    private final Worker worker;

    private final Thread workerThread;

    public SchedulerImpl(SchedulerConfig config) {

        this.jobQueue = new JobQueue();

        this.worker = new Worker(jobQueue);

        this.workerThread =
                new Thread(worker, config.getWorkerName());

        workerThread.start();
    }

    @Override
    public JobHandle schedule(
            Runnable task,
            long delay,
            TimeUnit unit) {

        long executionTime =
                System.currentTimeMillis()
                        + unit.toMillis(delay);

        ScheduledJob job =
                new ScheduledJob(
                        task,
                        executionTime,
                        0,
                        JobType.ONE_TIME);

        jobQueue.addJob(job);

        return new JobHandle(job, jobQueue);
    }

    @Override
    public JobHandle scheduleAtFixedRate(
            Runnable task,
            long initialDelay,
            long interval,
            TimeUnit unit) {

        long executionTime =
                System.currentTimeMillis()
                        + unit.toMillis(initialDelay);

        ScheduledJob job =
                new ScheduledJob(
                        task,
                        executionTime,
                        unit.toMillis(interval),
                        JobType.RECURRING);

        jobQueue.addJob(job);

        return new JobHandle(job, jobQueue);
    }

    @Override
    public void shutdown() {

        worker.shutdown();

        workerThread.interrupt();

    }
}
