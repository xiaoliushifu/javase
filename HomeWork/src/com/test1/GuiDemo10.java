package com.test1;

/**
 * 修改为小型的学生管理系统
 * 
 * 实现增删改查功能
 * 
 * 查询，就是一个按钮，绑定点击事件，触发时获得文本域的字符，去数据库查询，返回数据，重新生成JTable
 * 
 * 
 * 
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
public class GuiDemo10 extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	//label标签
	JLabel jl1;
	//文本域
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	JTable jt=null;
	JScrollPane jsp=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo10 t1=new GuiDemo10();
	}
	
	//构造函数
	public GuiDemo10(){
		
		jp1 = new JPanel();
		jl1=new JLabel("请输入名字");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		//希望被当前对象监听
		jb1.addActionListener(this);
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		//第二个面板
		jp2 =new JPanel();
		jb2= new JButton("添加");
		jb2.addActionListener(this);
		jb3= new JButton("修改");
		jb4= new JButton("删除");
		//往面板里添加按钮
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		//中间部分，就是JTable
		StuModel sm = new StuModel();
		jt = new JTable(sm);
		//初始化JScrollPane，需要JTable对象作为构造函数的参数
		jsp = new JScrollPane(jt);
		
		//把jsp放到JFrame中
		this.add(jsp);
		//本身就是自上向下的布局，加个North，往最上面走
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//查询按钮
		if(arg0.getSource() == jb1) {
			//事件发生是，直接在jtf对象上获得文本即可
			String name=this.jtf.getText().trim();
			String sql = "select * from stus where StuName='"+name+"'";
			StuModel sm = new StuModel(sql);
			//JTable是有数据模型的，所以这次使用set方法更新为新的数据模型即可
			jt.setModel(sm);
			
		}
		//添加按钮
		if(arg0.getSource() == jb2) {
			StuAddDialog sa = new StuAddDialog(this,"添加一个学生",true);
		}
		
	}

}
