package com.ubs.learning;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> task = () -> {
            return   "Task executed on : " + LocalDateTime.now().toString();
        };

        Runnable task1 = () -> {
            System.out.println("Task executed on : " + LocalDateTime.now().toString());
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(task, 100, TimeUnit.MILLISECONDS);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(task1, 0, 10, TimeUnit.SECONDS);

        System.out.println("result ::" + schedule.get());

        System.out.println("Fix Rate ::" + scheduledFuture.get());

        scheduledExecutorService.shutdown();

    }
}
