/**
 * 创建一个JTable可以使用的表模型，对JTable的数据来源就比较容易管理
 * 这个模型与学生表Stus是一对一的
 * 不是直接查询数据库sql,而是让模型去查询sql，JTable只关系Table模型就行了。
 * 需要继承一个抽象类AbstractTableModel,并实现一些方法
 */
package com.test1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

class StuModel extends AbstractTableModel {

	//下面是数据库的几个信息
	static final String DB_URL = "jdbc:mysql://localhost:3306/spdb1?useSSL=false&characterEncoding=utf8";
	//数据库用户名
	static final String USER="root";
	static final String PASS="";
	Connection conn = null;
	Statement stat = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//用来存放二维数组的数据，和列名
	Vector rowData,columnNames;
		
	//共用的初始化方法
	public void init(String sql){
		if(sql.equals("")) {
			sql = "select * from stus";
		}
		columnNames = new Vector();
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		//可以嵌套多行，每行也是一个vector
		rowData = new Vector();
		//有关数据库的操作
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//根据sql创建预编译对象
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//循环读取一行
			while(rs.next()){
				Vector hang = new Vector();
				hang.add(rs.getInt(1));//数据库语法下，下标从1开始的
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getShort(4));//注意范围,数据库用的是无符号一个字节
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				rowData.add(hang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}finally{
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
		
	//添加一个学生
	public void StuAdd(){
		
	}
		
	//构造函数，初始化model,传递一个sql
	public StuModel(String sql){
		this.init(sql);
	}
	
	public StuModel(){
		this.init("");
	}
		
	@Override
	//得到共有多少列，调用一次
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	//得到共有多少行,调用多次
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	//得到某行某列的数据
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Vector rowData = (Vector)this.rowData.get(row);
		return rowData.get(column);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 *  处理列的名字,根据实际的列的数量，调用多次
	 *  因为从向量里获得数据，类型不能提前知道，需要强转类型
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
