/**
 * @(#)UserBeanCl.java
 * ���������ר�Ŵ���UserBean��ص��߼�
 *
 * @author 
 * @version 1.00 2018/3/11
 */
package com.liu;

import java.sql.*;
import java.util.*;

public class UserBeanCl {

    //��ʼ�����Ӷ���
    private Connection conn = null;
    private ResultSet rs=null;
    private PreparedStatement stmt =null;
    
    /**
     *��÷�ҳ����
     */
    public ArrayList getResultByPage(int pageSize,int pageNow){
    	ArrayList al = new ArrayList();
    	try{
	    	int rowCount=0;//�ܹ���������¼(���)
	        int pageCount=0;//�ܹ�����ҳ��ͨ������õ�
	        DbConn db = new DbConn();
	        rowCount = db.count("*");
	        if(rowCount%pageSize==0) {
	        	pageCount = rowCount/pageSize;
	        } else {
	        	pageCount = rowCount/pageSize+1;
	        }
	        rs = db.selectAll((pageNow-1)*pageSize,pageSize);
	        while(rs.next()) {
	        	//ÿ�α�����һ����¼��������һ��ub
	        	UserBean ub = new UserBean();
	        	ub.setId(rs.getInt(1));
	        	ub.setUname(rs.getString(2));
	        	ub.setPass(rs.getString(3));
	        	ub.setAge(rs.getInt(4));
	        	//���뵽������
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
 	 *��¼��֤
 	 **/
	public boolean check(String name,String pass) {
		boolean b=false;
		try{
		    String sql = "SELECT `pass` FROM `mwdb` where `uname`='"+name+"'";
		    DbConn db = new DbConn();
		    conn = db.getDbConn();
		    stmt = conn.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
		    //������������ڲ����α�õ�ÿһ�еļ�¼
		    if(rs.next()){
		    	String dbpass  = rs.getString("pass");
		    	if(dbpass.equals(pass)) {
		    		b=true;
		    	}
			}
		}
		catch(Exception e){
		    // ���� Class.forName ����
		    e.printStackTrace();
		}
		finally{
		    // �ر���Դ
		    this.close();
		}
		return b;
	}
	
	/**
	 *�ر���Դ
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