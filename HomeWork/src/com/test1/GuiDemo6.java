/**
 * 几个常用控件（表单项） 
 * JPanel  面板
 * JLable  标签
 * JButton 按钮
 * JTextField 文本域
 * JPasswordField 密码域
 * 
 * 开发GUI程序的步骤总结：
 * 	继承JFrame
 * 	定义自己的组件
 * 	添加组件到窗体
 * 	设置布局管理器
 * 	设置窗体属性
 * 	显示窗体
 */
package com.test1;

import java.awt.*;
import javax.swing.*;
public class GuiDemo6 extends JFrame {

	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	//文本域
	JTextField jtf1;
	//密码域
	JPasswordField jpf1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo6 g6=new GuiDemo6();
	}
	
	public GuiDemo6()
	{
		
		//创建控件
		jlb1=new JLabel("用户名");
		jtf1=new JTextField(10);
		
		jlb2=new JLabel("密  码");
		jpf1=new JPasswordField(10);
		
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		
		//创建面板1
		jp1 = new JPanel();
		//为面板1添加控件
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		//创建面板2
		jp2 = new JPanel();
		//为面板2添加控件
		jp2.add(jlb2);
		jp2.add(jpf1);
		//创建面板3
		jp3 = new JPanel();
		//为面板3添加控件
		jp3.add(jb1);
		jp3.add(jb2);
		
		//把三个面板都添加到窗体
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//窗体的布局管理器为网格布局
		this.setLayout(new GridLayout(3,1));
		//禁止用户改变窗体大小
		//this.setResizable(false);
		
		this.setTitle("用户登录");
		this.setSize(300,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
