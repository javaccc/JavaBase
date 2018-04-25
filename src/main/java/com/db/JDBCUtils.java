package com.db;

import java.sql.*;

public class JDBCUtils {

    private Connection conn = null;
    public static String URL = "jdbc:oracle:thin:localhost:8999:db";
    public static String USERNAME = "";
    public static String PWD = "";

    private PreparedStatement pstmt;
    private ResultSet resultSet;

    public JDBCUtils() {

        initConnection();
    }

    public JDBCUtils(String url, String userName, String pwd) {
        URL = url;
        USERNAME = userName;
        PWD = pwd;
        initConnection();
    }

    public void initConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conn = DriverManager.getConnection(URL, USERNAME, PWD);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        if (conn == null) {
            initConnection();
        }

        return conn;
    }


}
