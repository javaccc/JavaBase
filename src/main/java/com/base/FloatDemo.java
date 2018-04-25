package com.base;

import org.junit.Test;

public class FloatDemo {

    // 浮点型精度测试
    @Test
    public void test() {
        // 这里必须强制转型（没有小数点，默认是int，有小数点，默认是double）
        float f = 3.4f;
        System.out.println("f = " + f);
    }

}
