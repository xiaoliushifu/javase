//操作数据库的类
package com.liu.model;

import java.sql.*;

public class ConnDb {
	Connection conn = null;
	String dburl="jdbc:mysql://localhost:3306/test?useSSL=false&Encodingcharset=utf8";
	String user="root";
	String pass="";
	public Connection getConn(){
		
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			conn = DriverManager.getConnection(dburl, user, pass);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
