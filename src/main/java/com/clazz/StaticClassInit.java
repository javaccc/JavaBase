package com.clazz;

/**
 * Created by acebrook on 2017/9/4.
 */
public class StaticClassInit {
    // 静态变量的作用域，以及初始化顺序
    static {
        name = "acebrook";
    }

    private static String name = "acebrook";

    {
        // 不加this，这句代码会报错，报错原因，猜测是因为编译器检查到变量还未初始化完成，所以不能被使用
//        System.out.println("value = " + value);
        System.out.println("value = " + this.value);
        value = "go";
//        System.out.println("value = " + value);
        System.out.println("value = " + this.value);
        value = 1 + "";
        // Above two examples can be summarized like this,
        // We can’t use a field before it is defined
        // but we can initialize a field before it is defined.
        // 参考自http://javaconceptoftheday.com/illegal-forward-reference-error-java/
    }

    private String value;


    public static void main(String[] args) {
        StaticClassInit sc = new StaticClassInit();
        System.out.println("sc = " + sc);
    }
}
