/**
 * BorderLayout 边界布局
 * 继承JFrame
 * 创建控件
 * 添加到窗体中
 * 设置窗体属性
 */
package com.test1;
import java.awt.*;
import javax.swing.*;

public class GuiDemo2 extends  JFrame{

	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo2 g2=new GuiDemo2();

	}
	
	public GuiDemo2()
	{
		jb1 = new JButton("中间");
		jb2 = new JButton("北部");
		jb3 = new JButton("东部");
		jb4 = new JButton("南部");
		jb5 = new JButton("西部");
		
		//添加各个控件
		//尝试少添加一个按钮，看看布局会是什么模样
		//this.add(jb1,BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.EAST);
		this.add(jb4, BorderLayout.SOUTH);
		this.add(jb5, BorderLayout.WEST);
		
		//设置窗体属性
		this.setTitle("边界布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
