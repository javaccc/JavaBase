package com.extension;

public class Parent {
    
    public String hello() {
        return "Parent, hello";
    }

    public static void say(){
        System.out.println("say Good bye.");
    }

    public static native void play();
}
