package com.constructor;

/**
 * Created by acebrook on 2017/9/4.
 * 是的，就是为了测测类的初始化，我把tomcat请出来了
 */
public class Tomcat {
    public static final String name = "Tomcat 7";
    public static final Tomcat instance = new Tomcat();
    public static Tomcat instance2 = new Tomcat();
    // 这有问题 ，会造成初始化死循环
//    private Tomcat tomcat = new Tomcat();

    public Tomcat() {
        System.out.println("instance = " + instance);
        System.out.println(" contructor init ing... " );
    }
}
