package com.test1;

/**
 * JTable的使用
 */
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class GuiDemo9 extends JFrame {

	//用来存放二维数组的数据，和列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo9 t1=new GuiDemo9();
	}
	
	//构造函数
	public GuiDemo9(){
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
		Vector hang = new Vector();
		hang.add("sp001");
		hang.add("孙悟空");
		hang.add("男");
		hang.add("500");
		hang.add("花果山");
		hang.add("独门的");
		
		//一行加入到rowData中
		rowData.add(hang);
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
