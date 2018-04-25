package com.thread.po;

/**
 * @author acebrook
 * @date 2017/11/16 14:38
 */
public class MyTask {
    private String name;

    public void go() {
        int i = 100;
        System.out.println(Thread.currentThread().getName() + " 开始执行go....., i = " + i);
        i = 150;

        try {
            Thread.sleep(1 * 1000);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 结束执行go.....，i = " + i);
    }

    public void go2() {
        name = "go2";
        System.out.println(Thread.currentThread().getName() + " 开始执行go....., name = " + name);
        name = "I am acebrook.";

        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 结束执行go.....，name = " + name);
    }
}
