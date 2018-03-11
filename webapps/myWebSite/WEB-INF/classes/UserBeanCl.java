/**
 * @(#)UserBeanCl.java
 * 这个处理方法专门处理UserBean相关的逻辑
 *
 * @author 
 * @version 1.00 2018/3/11
 */
package com.liu;

import java.sql.*;
import java.util.*;

public class UserBeanCl {

    //初始化连接对象
    private Connection conn = null;
    private ResultSet rs=null;
    private PreparedStatement stmt =null;
    
    /**
     *获得分页数据
     */
    public ArrayList getResultByPage(int pageSize,int pageNow){
    	ArrayList al = new ArrayList();
    	try{
	    	int rowCount=0;//总共多少条记录(查库)
	        int pageCount=0;//总共多少页（通过计算得到
	        DbConn db = new DbConn();
	        rowCount = db.count("*");
	        if(rowCount%pageSize==0) {
	        	pageCount = rowCount/pageSize;
	        } else {
	        	pageCount = rowCount/pageSize+1;
	        }
	        rs = db.selectAll((pageNow-1)*pageSize,pageSize);
	        while(rs.next()) {
	        	//每次遍历的一条记录，都生成一个ub
	        	UserBean ub = new UserBean();
	        	ub.setId(rs.getInt(1));
	        	ub.setUname(rs.getString(2));
	        	ub.setPass(rs.getString(3));
	        	ub.setAge(rs.getInt(4));
	        	//加入到集合中
	        	al.add(ub);
	        }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }finally{
        	this.close();
        }
        return al;
    }
    
    
    
    /**
 	 *登录验证
 	 **/
	public boolean check(String name,String pass) {
		boolean b=false;
		try{
		    String sql = "SELECT `pass` FROM `mwdb` where `uname`='"+name+"'";
		    DbConn db = new DbConn();
		    conn = db.getDbConn();
		    stmt = conn.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
		    //遍历结果集，内部用游标得到每一行的记录
		    if(rs.next()){
		    	String dbpass  = rs.getString("pass");
		    	if(dbpass.equals(pass)) {
		    		b=true;
		    	}
			}
		}
		catch(Exception e){
		    // 处理 Class.forName 错误
		    e.printStackTrace();
		}
		finally{
		    // 关闭资源
		    this.close();
		}
		return b;
	}
	
	/**
	 *关闭资源
	 *
	 */
	public void close(){
		try{
	        if(rs != null) rs.close();
	        if(stmt!=null) stmt.close();
	        if(conn!=null) conn.close();
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	}
    
}