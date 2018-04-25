package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKDynamicProxyTest {

    public static void main(String[] args) {
        final PersonService target = new PersonServiceImpl();
        PersonService proxy = (PersonService)
                Proxy.newProxyInstance(PersonService.class.getClassLoader(),
                        new Class<?>[]{PersonService.class}, new InvocationHandler() {

                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                                System.out.println("------Proxy Start------");

                                System.out.println("method:" + method.getName());
                                System.out.println("args:" + Arrays.asList(args));
                                Object result = 2;//method.invoke(target, args);

                                System.out.println("------Proxy End------");
                                return result;
                            }
                        });

        Person p = new Person();
        p.setId(222);
        p.setName("skywolf");

        int res = proxy.save(p);
        System.out.println("res:" + res);
        /**
         * 这两者的类型是不一样的
         *  class com.sun.proxy.$Proxy0
         class com.java.proxy.PersonServiceImpl
         */
        System.out.println(proxy.getClass());
        System.out.println(target.getClass());
    }

}
