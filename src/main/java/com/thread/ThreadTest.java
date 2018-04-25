package com.thread;

import org.apache.log4j.Logger;

public class ThreadTest {
    private static Logger logger = Logger.getLogger(ThreadTest.class);
    private static final long MAX_SLEEP_TIME = 2000L;

    public static void main(String[] args) {
        MyThreadTest thread = new MyThreadTest();
        thread.start();

        int i = 1;

        while (true) {

            // 修改线程的睡眠时间
            long time = MAX_SLEEP_TIME + 1000 * i;
            logger.info("i=" + i + ", 修改休眠时间为：" + time);
            i++;
            MyThreadTest.setMaxSleepTime(time);
            try {
                Thread.sleep(10 * MAX_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(0 == i % 5) {
                logger.info("唤醒线程 [开始]");
                synchronized (thread) {
                    thread.notify();
                }
                logger.info("唤醒线程 [结束]");
            }
        }

    }

}
