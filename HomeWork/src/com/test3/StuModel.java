/**
 * 创建一个JTable可以使用的表模型，对JTable的数据来源就比较容易管理
 * 这个模型与学生表Stus是一对一的
 * 不是直接查询数据库sql,而是让模型去查询sql，JTable只关系Table模型就行了。
 * 需要继承一个抽象类AbstractTableModel,并实现一些方法
 */
package com.test3;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

class StuModel extends AbstractTableModel {

	//用来存放二维数组的数据，和列名
	Vector rowData,columnNames;
	ResultSet rs= null;
	SqlHelper db =null;
	

	//构造函数，初始化model,传递一个sql,不能加void
	public StuModel(String sql,String[] params){
		this.init(sql,params);
	}
	//构造函数，初始化model,传递一个sql,不能加void
	public StuModel(){
		
	}
		
	//共用的初始化方法
	public void init(String sql,String params[]){
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
			db = new SqlHelper();
			rs = db.QueryExecute(sql, params);
			//循环读取一行
			while(rs.next()){
				System.out.println("come");
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
			db.close();
		}
	}
		
	//修改一个学生（增加，删除，改）
	public boolean UpdStu(String sql,String param[]){
		SqlHelper db = new SqlHelper();
		db.UpdExecute(sql, param);
		return true;
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
