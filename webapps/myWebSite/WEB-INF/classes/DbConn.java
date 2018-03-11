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
 
    public DbConn() {
    	try{
    		//除了把jar包拷贝到公共lib目录下之外
    		//还得配置classPath。jdk profile下。
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
      
    }
 	
 	/**
 	 *登录验证
 	 *
 	 *
 	 **/
	public boolean check(String name,String pass) {
		try{
			String sql;
		    sql = "SELECT `pass` FROM `mwdb` where `uname`='"+name+"'";
		    stmt = this.conn.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
		
		    //遍历结果集，内部用游标得到每一行的记录
		    if(rs.next()){
		    	String dbpass  = rs.getString("pass");
		    	if(dbpass.equals(pass)) {
		    		return true;
		    	} else {
		    		return false;
		    	}
		    }
		    
		    // 完成后关闭
		    rs.close();//关闭结果集
		    stmt.close();//关闭statement对象
		    conn.close();//关闭连接
			return false;
		}catch(SQLException se){
	    	se.printStackTrace();
		}catch(Exception e){
		    // 处理 Class.forName 错误
		    e.printStackTrace();
		}finally{
		    // 关闭资源
		    try{
		        if(rs != null) rs.close();
		        if(stmt!=null) stmt.close();
		        if(conn!=null) conn.close();
		    }catch(SQLException se2){
		    
		    }
		   
		}
		return false;
	}
	
	/**
	 *查询数据库的数量
	 */
	public int count(String fields) {
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
