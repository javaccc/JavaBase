package com.math;

public class MyMathTest2 {
    private static final double S = Math.log10(3) / Math.log10(2);

    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public static double getHSValue(long k, long j, long x) {
        double fenmu = pow(pow(2, k) - 2 * j + 1, S);
        double fenzi = pow(3, k) - 3 * x;

        return fenmu / fenzi;
    }

    public static double Yj(long j) {
        int m;
        double ReturnVal;
        if (j == 1) {
            return 1;
        }
        m = (int) (Math.log10(j) / Math.log10(2));
        if (j - (long) pow(2, m) == 0) {
            ReturnVal = pow(3, m);
        } else {
            ReturnVal = 2 * Yj(j - (long) pow(2, m)) + pow(3, m);
        }

        return ReturnVal;
    }

    void initXArray() {
        int i;
        for (i = 349999990; i < 350000000; i++) {
            System.out.println("Y" + i + "=" + Yj(i));
        }
    }

    public static void main(String[] args) {
        long k, tempJ;
        double minHk, tempHk, x = Double.MAX_VALUE;

        for (k = 1; k <= 22; k++) {
            long j, max = (long) pow(2, k - 2);
            tempJ = 1;
            minHk = 1234567890.0;

            for (j = 1; j <= max; j++) {
                x = Yj(2 * j - 1);
                tempHk = getHSValue(k, j, (long) x);
                if (tempHk < minHk) {
                    minHk = tempHk;
                    tempJ = j;
                }
            }
            System.out.println("Hs" + k + "=" + minHk + ", Y" + tempJ + "=" + x);
        }
    }

}
