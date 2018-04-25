package com.regrex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by acebrook on 2017/5/24.
 */
public class PatternTest {

    public void testFloatParttern() {
        System.out.println(" === testFloatParttern ===");
        //表达式的功能：验证必须为数字（整数或小数）
        String pattern = "(\\-)?[0-9]+(.[0-9]+)?";
        //对()的用法总结：将()中的表达式作为一个整体进行处理，必须满足他的整体结构才可以。
        //(.[0-9]+)? ：表示()中的整体出现一次或一次也不出现
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("2");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("7882.555a55");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("-0007882.55555abd");
        System.out.println("patter result : " + m.matches());
    }


    public void testFloatArrayParttern() {
        System.out.println(" === testFloatArrayParttern ===");
        String pattern = "(\\-)?[0-9]+(.[0-9]+)?(\\s*,\\s*(\\-)?[0-9]+(.[0-9]+)?)*";
        Pattern p= Pattern.compile(pattern);
        Matcher m;
        m = p.matcher("1,2,3,4,5,6,7,8");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("1, 2,  3, 4, 5, 6, 7,8");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("1,2,3, 4.0566,5,615.55f55,7,8");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("155.55,     2.55,  33233, 554.0, 555.1, 6888.5, 7,8");
        System.out.println("patter result : " + m.matches());
    }


    public void testIntPattern() {
        System.out.println(" === testIntPattern ===");
        String pattern = "(\\-)?[0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("123456789");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("-123456789");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("12345ddsfs6789");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("123456789bdd");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("-d123456789");
        System.out.println("patter result : " + m.matches());
    }


    public void testIntArrayPattern() {
        System.out.println(" === testIntArrayPattern ===");
        String pattern = "(\\-)?[0-9]+(\\s*,\\s*(\\-)?[0-9]+)*";
        Pattern p = Pattern.compile(pattern);
        Matcher m;
        m = p.matcher("1,2,3,4,5,6,7,8");
        System.out.println("patter result : " + m.matches());
        m = p.matcher("1, 2,  3, 4, 5, 6, 7,8");
        System.out.println("patter result : " + m.matches());
    }


    public static void main(String[] args) {
        PatternTest pt = new PatternTest();
        pt.testFloatParttern();
        pt.testFloatArrayParttern();
        pt.testIntPattern();
        pt.testIntArrayPattern();
    }
}
