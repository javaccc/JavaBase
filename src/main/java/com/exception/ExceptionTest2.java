package com.exception;

/**
 * 
 * 说明：1.先处理catch语句，再处理finally语句
 *      2.return语句处不一定马上返回，如果碰到异常，
 *          try和finally中的return语句返回值压倒栈中，处理完catch语句再返回。
 *          注意：压倒栈中的句柄的值，可能会被修改。
 *      3.异常是特殊的返回值，如果上层语句接收到异常，那么接收到的method返回值为Java对象的默认值。
 * @author acebrook
 * @version 1.0.0
 * @date 2016年2月18日 上午12:03:51
 */
public class ExceptionTest2 {

    public ExceptionTest2() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            System.out.println("testEx1, ret=" + ret);
            if (!ret) {
                System.out.println("你猜猜：这里有没有返回");
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;//这里的异常被finally的return返回值覆盖了
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
      // System.out.println("这里不会被执行");
    }

    public static void main(String[] args) {
        ExceptionTest2 testException1 = new ExceptionTest2();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
