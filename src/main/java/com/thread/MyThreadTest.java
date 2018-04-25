package com.thread;

import org.apache.log4j.Logger;

public class MyThreadTest extends Thread {
    private static Logger logger = Logger.getLogger(MyThreadTest.class);
    private static long maxSleepTime = 1000;

    public static void setMaxSleepTime(long maxSleepTime) {
        MyThreadTest.maxSleepTime = maxSleepTime;
    }
    
    @Override
    public void run() {
        
        while(true) {
            logger.info(Thread.currentThread().getName() + " is running...., wait time:" + maxSleepTime);
            
            try {
                //Thread.sleep(maxSleepTime);
                synchronized (this) {
                    wait(maxSleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
