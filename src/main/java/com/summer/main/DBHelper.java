package com.summer.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public static final String url = "jdbc:mysql://106.14.161.168/desktop?useUnicode=true&characterEncoding=utf8";
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "summer";
  
    public Connection conn = null;

    public static DBHelper instance;

    static {
        try {
            Class.forName(name);//指定连接类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


  
    public DBHelper() {
        try {  
            conn = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
        } catch (SQLException e) {
            e.printStackTrace();  
        }  
    }  
}