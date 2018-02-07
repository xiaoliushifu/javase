package com.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	static final String driver="com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/spdb1?useSSL=false&characterEncoding=utf8";
	//数据库用户名
	static final String USER="root";
	static final String PASS="";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	/**
	 * 认清构造方法
	 */
	public SqlHelper(){
		//加载驱动
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 增删改的综合方法
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	public boolean UpdExecute(String sql,String param[]){
		try {
			ps = conn.prepareStatement(sql);
			for (int i=0;i<param.length;i++) {
				ps.setString(i+1, param[i]);
			}
			if (ps.executeUpdate() > -1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**查询的方法
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public ResultSet QueryExecute(String sql,String param[]){
		
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				ps.setString(i+1, param[i]);
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 关闭资源与连接
	 */
	public void close()
	{
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
