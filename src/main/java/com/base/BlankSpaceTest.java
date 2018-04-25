package com.base;

import java.util.Arrays;

/**
 * 说明： 空格测试
 *
 * @author acebrook
 * @version 1.0.0
 * @date 2015年11月24日 下午11:30:45
 */
public class BlankSpaceTest {

    /**
     * 将连续多个空格替换为一个
     */
    public static String replaceSpace(String src) {
        return src.replaceAll("\\s+", " ");
    }

    public static String split(String sql, String splitStr) {
        String[] temp = sql.split(splitStr);
        System.out.println(Arrays.asList(temp));
        temp = temp[1].split(" ");
        System.out.println(Arrays.asList(temp));
        return temp[0];
    }

    /**
     * 根据处理后的SQL语句：获取DBObjectName
     */
    public static String getDBObjectName(String sql) {
        System.out.println("sql:" + sql);

        String temp = "CREATE OR REPLACE TYPE ";
        if (sql.contains(temp)) {
            return split(sql, temp);
        }

        temp = "CREATE TYPE ";
        if (sql.contains(temp)) {
            return split(sql, temp);
        }

        return null;
    }

    public static void main(String[] args) {
        String temp;

        temp = replaceSpace("CREATE OR REPLACE TYPE CC    .   abc IS TABLE OF cdf".toUpperCase());
        System.out.println(getDBObjectName(temp));

        temp = replaceSpace("CREATE OR REPLACE TYPE CC    .  abc IS OBJECT(".toUpperCase());
        System.out.println(getDBObjectName(temp));

    }

}
