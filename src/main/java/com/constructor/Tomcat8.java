package com.constructor;

/**
 * Created by acebrook on 2017/9/4.
 */
public class Tomcat8 {

    // main是一个特殊的方法，会影响类的初始化
    public static void main(String[] args) {
        System.out.println("Tomcat = " + Tomcat.name);
        System.out.println("instance = " + Tomcat.instance);
        System.out.println("instance2 = " + Tomcat.instance2);
    }
}
