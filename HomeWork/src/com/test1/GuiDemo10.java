package com.test1;

/**
 * JTable的使用
 * 连接数据库
 * 加载驱动
 * 建立连接
 * 根据sql创建预处理对象ps
 * 执行sql
 * 	循环
 * 	验证sql准确否
 */
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class GuiDemo10 extends JFrame {

	//下面是数据库的几个信息
	//定义连接字符串
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
	JTable jt=null;
	JScrollPane jsp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo10 t1=new GuiDemo10();
	}
	
	//构造函数
	public GuiDemo10(){
		//初始化列名
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
			ps= conn.prepareStatement("select * from stus");
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
		//一行加入到rowData中
		//rowData.add(hang);
		//初始化JTable
		jt = new JTable(rowData,columnNames);
		//初始化JScrollPane
		jsp = new JScrollPane(jt);
		
		//把jsp放到JFrame中
		this.add(jsp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
