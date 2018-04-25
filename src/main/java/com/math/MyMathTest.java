package com.math;

import java.math.BigDecimal;


public class MyMathTest {

    public static BigDecimal getHSValue(BigDecimal a, BigDecimal b) {
        BigDecimal res = b.divide(a);

        return res;
    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(323.33D);
        BigDecimal b = new BigDecimal(1344.33D);

        System.out.println(getHSValue(a, b));
    }


}
