package com.extension;

public class Son extends Parent {

    public Son() {
        super();
        //System.out.println("dddd");
    }
    
    @Override
    public String hello() {
        System.out.println("start ...");
        System.out.println(super.hello());
        System.out.println("end ...");
        System.out.println();
        
        return "son, hello";
    }

    public static native void yield();

    public static  void display(){}

    public static void main(String[] args) {
        Parent parent = new Son();
        System.out.println(parent.hello());
        Son.say();
        Son.play();
        Son son = new Son();
        son.yield();
        son.display();
    }
}
