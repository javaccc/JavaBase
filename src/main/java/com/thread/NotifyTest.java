package com.thread;

import org.apache.log4j.Logger;

public class NotifyTest {
    private static Logger logger = Logger.getLogger(NotifyTest.class);
    
    public static void main(String[] args) {
        NotifyTest t = new NotifyTest();
        //MyThreadTest thread = new MyThreadTest();
        //thread.start();
        
        logger.info("休眠中");
        try {
            synchronized (t) {
                t.wait(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("休眠结束");
        
        
    }
    
}
