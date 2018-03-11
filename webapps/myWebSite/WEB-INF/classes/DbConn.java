/**
 * @(#)DbConn.java
 *hello
 *jar���������tomcat��libĿ¼�£�������webapps����
 * ���jar������ĳ��webapp�£���ֻ��������ʹ�����jar��
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;

import java.sql.*;

public class DbConn {

	// JDBC �����������ݿ� URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //�����ַ���,�漰������localhost���˿�3306�����ݿ���test
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "";
    
    //��ʼ�����Ӷ���
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement stmt =null;
 
 	/**
 	 *�õ����ݿ������
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
	 *��ѯ���ݿ������
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
		
		    //������������ڲ����α�õ�ÿһ�еļ�¼
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
	 *��ҳ��ѯ
	 */
	public ResultSet selectAll(int offset,int limit) {
		try{
			String sql ="select * from mwdb limit "+offset+","+limit;
			System.out.println(sql);
			//String sql ="SELECT  * FROM `mwdb` LIMIT ? OFFSET ?";//����
			//String sql ="SELECT  * FROM `mwdb` LIMIT ?,?";//Ҳ����
		    stmt = this.conn.prepareStatement(sql);
		    //stmt.setInt(1,offset);
		    //stmt.setInt(2,limit);
		    return stmt.executeQuery(sql);
		}catch(Exception e) {
	    	e.printStackTrace();
	    }
	    /**finally{
		    // �ر���Դ
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
