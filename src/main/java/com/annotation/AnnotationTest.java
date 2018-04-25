package com.annotation;


public class AnnotationTest {

    public static void main(String[] args) {
        Person p = new Person();
        Resource resource = p.getClass().getAnnotation(Resource.class);
        print(resource);
    }

    private static void print(Resource resource) {
        String name = resource.name();
        String value = resource.value();
        String description = resource.description();

        System.out.println("name = " + name);
        System.out.println("value = " + value);
        System.out.println("description = " + description);
    }

}
