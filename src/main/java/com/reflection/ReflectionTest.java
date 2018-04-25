package com.reflection;


import com.reflection.po.Person;

import java.lang.reflect.Field;

/**
 * 说明：反射测试
 *
 * @author acebrook
 * @version 1.0.0
 * @date 2015年11月13日 下午4:15:55
 */
public class ReflectionTest {

    public static void main(String[] args) {
        Person p = reflect2Bean(Person.class);
        System.out.println("username = " + p.getUsername() + ", age = " + p.getAge());
    }

    public static <T> T reflect2Bean(Class<T> clazz) {
        T resultObject = null;
        try {
            resultObject = clazz.newInstance();

            Field field = clazz.getDeclaredField("age");
            field.setAccessible(true); // 打开javabean的访问权限
            field.set(resultObject, 20);

            field = clazz.getDeclaredField("username");
            field.setAccessible(true);
            field.set(resultObject, "acebrook");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultObject;
    }
}
