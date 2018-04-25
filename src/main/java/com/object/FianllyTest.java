package com.object;

public class FianllyTest {

    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
            System.out.println("I'm nomal");
        } catch (Exception ex) {
            System.out.println("I'm exception");
        } finally {
            System.out.println("I'm finally.");
        }
        System.out.println("in the end");
    }
}
