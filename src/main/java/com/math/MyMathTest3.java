package com.math;


public class MyMathTest3 extends HausdorffMeasure {

    public static void main(String[] args) {
        mainTest(null);
        long k = 10, max;
        max = (long) (pow(2, k - 1) - 1);
        for (long j = 1; j <= max; j++) {
            System.out.printf("Y%d=%f\n", j, Xj(k, j));
            if (j > 147) {
                break;
            }
        }
    }

    public static void mainTest(String[] args) {
        long k = 10;
        double xj, yj;
        xj = 3;
        yj = pow(C, k - 2) * (1 - C);

        double fenmu = pow(3, 10) * pow(1 - yj, (Math.log10(3) / Math.log10(1.0 / C)));
        double fenzi = pow(3, 10) - 3 * xj;
        double temp = fenmu / fenzi;
        System.out.println("temp:" + temp); //0.9797911870017014 特殊：Hs10=0.999441550730947, Y2=3.000000000000000
    }

}
