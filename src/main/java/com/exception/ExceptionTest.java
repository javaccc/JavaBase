package com.exception;

public class ExceptionTest {

    public static void main(String[] args) {
        
        try {
            int res = 22 / 0;
            System.out.println("处理异常之后");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("异常已经解决");
    }
    
}
