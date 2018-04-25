package com.object;

/**
 * @author acebrook
 * @date 2017/11/16 17:45
 */
public class Wait {

    public static void main(String[] args) {
        System.out.println("开始....");
        Object obj = new Object();
        synchronized (obj) {
            try {
                obj.wait(3 * 1000); // 只有在同步代码块中才能调用，而且是同步的是当前对象obj才行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束....");
    }

}
