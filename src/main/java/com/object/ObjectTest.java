package com.object;

public class ObjectTest {

    /**
     * 变量在for循环内
     *
     * @param sum
     */
    public static void withoutVar(long sum) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < sum; i++) {
            Object obj = new Object();
        }
        long end = System.currentTimeMillis();
        System.out.println("[withoutVar]所用时间：" + (end - start));
    }

    /**
     * 变量在for循环外
     *
     * @param sum
     */
    public static void withVar(long sum) {
        long start = System.currentTimeMillis();
        Object obj;
        for (long i = 0; i < sum; i++) {
            obj = new Object();
        }
        long end = System.currentTimeMillis();
        System.out.println("[withVar]所用时间：" + (end - start));
    }

    public static void createObject() {
        final long sum = 1000000000;

        withoutVar(sum);

        withVar(sum);
    }

    public static void main(String[] args) {
        createObject();
    }
}
