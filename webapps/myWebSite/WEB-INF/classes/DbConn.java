/**
 * @(#)DbConn.java
 *hello
 *jar包如果放在tomcat的lib目录下，则所有webapps共享
 * 如果jar包放在某个webapp下，则只有它可以使用这个jar包
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;

import java.sql.*;

public class DbConn {

	// JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //连接字符串,涉及主机名localhost，端口3306，数据库名test
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "";
    
    //初始化连接对象
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement stmt =null;
 
 	/**
 	 *得到数据库的连接
 	 *
 	 */
    public Connection getDbConn() {
    	try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        return conn;
    }
	/**
	 *查询数据库的数量
	 */
	public int count(String fields) {
		if (conn == null) {
			this.getDbConn();
		}
		String sql;
	    sql = "SELECT count('+fields+') FROM `mwdb`";
	    try{
		    stmt = this.conn.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
		
		    //遍历结果集，内部用游标得到每一行的记录
		    if(rs.next()){
		    	return rs.getInt(1);
		    }
		    return 0;
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return 0;
	}
	
	/**
	 *分页查询
	 */
	public ResultSet selectAll(int offset,int limit) {
		try{
			String sql ="select * from mwdb limit "+offset+","+limit;
			System.out.println(sql);
			//String sql ="SELECT  * FROM `mwdb` LIMIT ? OFFSET ?";//不行
			//String sql ="SELECT  * FROM `mwdb` LIMIT ?,?";//也不行
		    stmt = this.conn.prepareStatement(sql);
		    //stmt.setInt(1,offset);
		    //stmt.setInt(2,limit);
		    return stmt.executeQuery(sql);
		}catch(Exception e) {
	    	e.printStackTrace();
	    }
	    /**finally{
		    // 关闭资源
		    try{
		        if(rs != null) rs.close();
		        if(stmt!=null) stmt.close();
		        if(conn!=null) conn.close();
		    }catch(SQLException se2){
		    
		    }
		   
		}*/
		return rs;
	}
}
