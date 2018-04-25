package com.thread;


import com.thread.po.MyTask;

/**
 * @author acebrook
 */
public class MultipleThreadTest {
    private static MyTask myTask = new MyTask();
    private static Runnable runnable = new Runnable() {

        @Override
        public void run() {
            while (true) {
//                synchronized (myTask) {
                    myTask.go2();
//                }
            }
        }
    };

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

    }

}
