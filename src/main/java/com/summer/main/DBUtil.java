package com.summer.main;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {


    public static Connection getConnection() throws NamingException,SQLException {
        Connection result=null;
        InitialContext ctx=new InitialContext();
        DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/MySQL");
        result =ds.getConnection();
        return result;
    }

    public static void close(Connection connection , PreparedStatement ps, ResultSet set){
        if(set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}