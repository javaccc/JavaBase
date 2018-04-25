package com.math;

import java.util.Scanner;

/**
 * @author acebrook
 * @date 2015-04
 */
public class HausdorffMeasure {
    public static double C = 0.5D;//pow(2, 1.0/3.0) / 3.0D;
    public static double S = Math.log10(3) / Math.log10(1.0 / C);
    public static final long MAX_K = 25;

    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public static double getHSValue(long k, long j, long x) {
        double fenmu = pow(3, k) * pow(1 - Xj(k, j), S);
        double fenzi = pow(3, k) - 3 * x;

        return fenmu / fenzi;
    }

    public static double Xj(long k, long j) {
        long m, temp;
        double ReturnVal;
        if (1 == j) {
            return pow(C, k - 1) * (1 - C);
        }
        m = (int) (Math.log10(j) / Math.log10(2));
        temp = (long) pow(2, m);
        if (j - temp == 0) {
            ReturnVal = pow(C, k - m - 1) * (1 - C);
        } else {
            ReturnVal = pow(C, k - m - 1) * (1 - C) + Xj(k, j - temp);
        }

        return ReturnVal;
    }

    public static double Yj(long j) {
        int m;
        double ReturnVal;
        long temp;
        if (j == 1) {
            return 1;
        }
        m = (int) (Math.log10(j) / Math.log10(2));
        temp = (long) pow(2, m);
        if (j - temp == 0) {
            ReturnVal = pow(3, m);
        } else {
            ReturnVal = 2 * Yj(j - temp) + pow(3, m);
        }

        return ReturnVal;
    }

    public static void run() {
        long k, tempJ = 1, allTempJ = 1, allTempK = 1;
        double minHk = Double.MAX_VALUE, tempHk, x = Double.MAX_VALUE, allMinHk = Double.MAX_VALUE;

        for (k = 2; k <= MAX_K; k++) {
            long j, max = (long) pow(2, k - 1) - 1;
            tempJ = 1;
            minHk = Double.MAX_VALUE;

            for (j = 1; j <= max; j++) {
                x = Yj(j);
                tempHk = getHSValue(k, j, (long) x);
                if (tempHk < minHk) {
                    minHk = tempHk;
                    tempJ = j;
                }
            }
            //System.out.printf("k=%d, Hs=%.20f, Y%d=%.20f\n", k, minHk, tempJ, x);
            if (minHk < allMinHk) {
                allMinHk = minHk;
                allTempJ = tempJ;
                allTempK = k;
            }
        }
        System.out.printf("c=%f, k=%d, Hs=%.20f, j=%d\n", HausdorffMeasure.C, allTempK, allMinHk, allTempJ);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入C的值：");
        HausdorffMeasure.C = scanner.nextDouble();
        HausdorffMeasure.S = Math.log10(3) / Math.log10(1.0 / C);
        run();
	    /*C = 0.35D;
	    S = Math.log10(3) / Math.log10(1.0 / C);
	    run();
	    C = 0.49D;
        S = Math.log10(3) / Math.log10(1.0 / C);
        run();
        C = 0.5D;
        S = Math.log10(3) / Math.log10(1.0 / C);
        run();*/
    }

}
