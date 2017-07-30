/**
 * 多种布局管理器的组合
 * 一个JFrame只能有一个窗口，但允许有多个JPanel。
 * JPanel就是一个面板，它是一个二级容器窗口，非顶层容器，顶层容器就是JFrame。
 * 一个JFrame窗口里可以有多个JPanel,每个JPanel都可以有自己的布局管理器
 * 
 * JPanel是JComponent类的一个子类
 * JPanel属于容器组件，意味着它可以容纳其他控件
 * 
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
public class GuiDemo5 extends JFrame {

	//再次学习，java数组初始化时，必须指定大小
	//左边的[]可以放的位置是 
	//	JButton[] jbs
	//	JButton  []jbs
	//	JButton jbs[]
	//右边的写法仅仅一种： Type[10]
	JPanel jp1,jp2;
	JButton[] jbs=new JButton[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo5 g5=new GuiDemo5();
	}
	
	public GuiDemo5()
	{
		
		//创建面板,面板的默认布局管理器就是流式布局
		jp1 = new JPanel();
		jp2 = new JPanel();
		int i=0;jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		
		//添加控件到面板
		jp1.add(jbs[0]);
		jp1.add(jbs[1]);
		//面板1的布局管理器为网格布局
		jp1.setLayout(new GridLayout(4,4));
		
		//添加控件到面板2
		jp2.add(jbs[2]);
		jp2.add(jbs[3]);
		jp2.add(jbs[4]);
		
		//把面板1添加到窗体
		this.add(jp1,BorderLayout.NORTH);
		//直接添加一个控件到窗体
		this.add(jbs[5],BorderLayout.CENTER);
		//再添加一个面板到窗体
		this.add(jp2,BorderLayout.SOUTH);
		
		//禁止用户改变窗体大小
		//this.setResizable(false);
		
		this.setTitle("面板布局管理器案例");
		this.setSize(200,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
