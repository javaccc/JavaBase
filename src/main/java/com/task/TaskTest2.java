package com.task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskTest2 {
    private static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("scheduleAtFixedRate:    " + new Date());
            }
        }, 1, 3L, TimeUnit.SECONDS);

    }

    public static void main2(String[] args) {
        scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("scheduleWithFixedDelay: " + new Date());
            }
        }, 1, 3L, TimeUnit.SECONDS);
    }
    
}
