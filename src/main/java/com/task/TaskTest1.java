package com.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskTest1 {
    private static int count = 0;

    public static long getDelayTime() {
        // 模拟值
        return 1234;
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            TaskFlag obj = new TaskFlag();

            public void run() {
                TaskTest1.count++;
                System.out.println("obj:" + obj.toString() + ", count:" + TaskTest1.count);
            }
        };

        long delayTime = getDelayTime();
        System.out.println("还有 " + delayTime + " 秒触发任务。");
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> sf = service.scheduleAtFixedRate(runnable, delayTime, 2, TimeUnit.SECONDS);
        sf.cancel(true);
    }

    static class TaskFlag {
        public TaskFlag() {
            System.out.println("create TaskFlag object....");
        }
    }
}
