package com.thread;

import org.apache.log4j.Logger;

public class NotifyTest2 {
    private static Logger logger = Logger.getLogger(NotifyTest2.class);
    
    public static void main(String[] args) {
        MyThreadTest thread = new MyThreadTest();
        thread.start();
        
        logger.info("休眠中");
        try {
            synchronized (thread) {
                thread.wait(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("休眠结束");
        
        
    }
    
}
