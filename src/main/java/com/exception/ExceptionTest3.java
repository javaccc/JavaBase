package com.exception;

public class ExceptionTest3 {
    
        public ExceptionTest3() {
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
                try {
                ret = testEx2();
                System.out.println("ret:" + ret);
                } catch (Exception e) {
                    System.out.println("eeeeeeeeeeee");
                }
                if (!ret) {  
                    return false;  
                }  
                System.out.println("testEx1, at the end of try");  
                return ret;  
            } catch (Exception e) {  
                System.out.println("testEx1, catch exception");  
                ret = false;  
                throw e;  
            } finally {  
                System.out.println("testEx1, finally; return value=" + ret);  
                ret = true;
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
                System.out.println("testEx2:" + e.getMessage());
                //throw e;
                return true;
            } finally {  
                System.out.println("testEx2, finally; return value=" + ret);  
                //return ret;
                return false;
            }  
        }  
      
        public static void main(String[] args) {  
            ExceptionTest3 test = new ExceptionTest3();
            try {  
                test.testEx();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    } 