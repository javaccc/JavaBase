package com.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 创建数组，初始化时，数组元素的值是否为空
 *
 * @author acebrook
 */
public class ArrayTest {

    @Test
    public void testArrayElement() {
        //即使分配了数组的长度，数组的元素还未初始化，元素的值还是null
        Object[] obj = new Object[3];

        System.out.println(obj[0]);
        System.out.println(obj[1]);
        System.out.println(obj[2]);
    }

    public void test() {
        ArrayList list = new ArrayList();
        Vector vector = new Vector();
    }

}
