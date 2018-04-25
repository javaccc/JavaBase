package com.enumeration;

/**
 * 说明：枚举类型
 *
 * @author acebrook
 * @date 2015-10-26 下午2:49:14
 */
public class EnumTest2 {

    public enum Day {
        // 首先，枚举类，编译器会转换为继承Enum的Java普通类
        // 这里在底层的实现，传参（字段名称和顺序）给构造器，每个字段创建一个对象
        MONDAY,
        TUESDAY,
        WEDNESDAH,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        Day day = Day.valueOf(Day.class, "WEDNESDAH");
        print(day);
        print(Day.valueOf("MONDAY"));
        print(Day.TUESDAY);
    }

    private static void print(Day day) {
        System.out.println(day);
    }

}
