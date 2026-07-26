package com.codekerdos.lld.scheduler.scheduler;

public class SchedulerConfig {

    private final String workerName;

    public SchedulerConfig(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerName() {
        return workerName;
    }
}