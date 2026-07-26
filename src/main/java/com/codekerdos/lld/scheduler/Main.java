package com.codekerdos.lld.scheduler;

import scheduler.scheduler.JobHandle;
import scheduler.scheduler.Scheduler;
import scheduler.scheduler.SchedulerConfig;
import scheduler.scheduler.SchedulerImpl;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scheduler scheduler =
                new SchedulerImpl(
                        new SchedulerConfig("Scheduler-Worker"));

        /*
         * One time task
         */
        scheduler.schedule(() ->
                System.out.println(
                        LocalTime.now() + " : One time task"),
                5,
                TimeUnit.SECONDS);


        /*
         * Recurring task
         */
        JobHandle recurringTask =
                scheduler.scheduleAtFixedRate(() ->
                                System.out.println(
                                        LocalTime.now()
                                                + " : Heartbeat"),
                        2,
                        3,
                        TimeUnit.SECONDS);


        /*
         * Another one time task
         */
        scheduler.schedule(() ->
                System.out.println(
                        LocalTime.now()
                                + " : Send Email"),
                10,
                TimeUnit.SECONDS);


        /*
         * Cancel recurring task after 15 seconds
         */
        Thread.sleep(15000);

        recurringTask.cancel();

        System.out.println("Recurring task cancelled");


        /*
         * Let scheduler run for a little longer
         */
        Thread.sleep(5000);

        scheduler.shutdown();

        System.out.println("Scheduler Shutdown");
    }
}
