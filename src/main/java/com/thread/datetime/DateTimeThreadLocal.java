package com.thread.datetime;

import java.text.SimpleDateFormat;

/**
 * @author acebrook
 * @date 2017/11/16 14:12
 */
public class DateTimeThreadLocal {
    private static final String format = "";
    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public void set(SimpleDateFormat simpleFormatter) {
        threadLocal.set(simpleFormatter);
    }

    public SimpleDateFormat get() {
        SimpleDateFormat format = threadLocal.get();
        if (null == format) {
            threadLocal.set(new SimpleDateFormat(DateTimeThreadLocal.format));
        }
        return threadLocal.get();
    }

}
