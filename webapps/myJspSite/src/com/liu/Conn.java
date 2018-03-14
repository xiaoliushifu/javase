/**
 * 把数据库的初始化加载驱动，建立连接写在这个文件里
 */
package com.liu;

import java.sql.*;

public class Conn {
    private Connection conn = null;
    private String jdbcURL ="jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
    private String USER="root";
    private String PASS="";

    /**
     * @return
     */
    public Connection getConn() {
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL,USER,PASS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
