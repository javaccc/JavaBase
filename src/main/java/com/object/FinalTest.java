package com.object;

import org.junit.Test;

/**
 * final关键字测试
 *
 * @author acebrook
 */
public class FinalTest {

    public void change1(final Object obj) {
        //obj = new Integer(222);  //编译出错了
    }

    public void change2(Object obj) {
        System.out.println(obj);
        obj = new Integer(222);
        System.out.println(obj);  //obj被改变了
    }

    public void change(final Object obj) {
        change1(obj);
        change2(obj);
        System.out.println("###############");
        System.out.println(obj);
    }

    @Test
    public void run() {
        change(new Object());
    }

}
