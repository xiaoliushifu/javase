package com.mysql.test;

import java.sql.*;
public class demo1 {

	// JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //连接字符串,涉及主机名，端口，数据库名
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "";
 
    public static void main(String[] args) {
    	//初始化连接对象
        Connection conn = null;
        //初始化Statement对象
        Statement stmt = null;
        try{
            // 注册 JDBC的mysql驱动,其他驱动类似
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            //驱动管理类DriverManager是哪里来的？
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对...");
            //用conn创建statement
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM test";
            //stmt是直接执行sql的对象
            ResultSet rs = stmt.executeQuery(sql);
        
            //遍历结果集，内部用游标得到每一行的记录
            while(rs.next()){
            	//rs.next就代表指针移动了一行，rs表示当前行
                // 在当前行通过字段检索
            	
                int id  = rs.getInt("id");
                String name = rs.getString("name");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();//关闭结果集
            stmt.close();//关闭statement对象
            conn.close();//关闭连接
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
