package com.annotation;

//@Resource("acebrook") // 没有指明具体的变量，这里默认是赋值给value
@Resource(name = "acebrook", value = "20", description = "Person info")
public class Person {
    private int age;
    private String username;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
