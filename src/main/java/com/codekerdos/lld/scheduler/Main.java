package com.codekerdos.lld.scheduler;

import com.codekerdos.lld.scheduler.scheduler.JobHandle;
import com.codekerdos.lld.scheduler.scheduler.Scheduler;
import com.codekerdos.lld.scheduler.scheduler.SchedulerConfig;
import com.codekerdos.lld.scheduler.scheduler.SchedulerImpl;

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
