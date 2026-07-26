package com.codekerdos.lld.scheduler.scheduler;

import java.util.concurrent.TimeUnit;

public interface Scheduler {

    JobHandle schedule(
            Runnable task,
            long delay,
            TimeUnit timeUnit);

    JobHandle scheduleAtFixedRate(
            Runnable task,
            long initialDelay,
            long interval,
            TimeUnit timeUnit);

    void shutdown();
}