package com.test1;

import javax.swing.*;
import java.awt.*;
public class demo9_1 extends JFrame{

		public static void main(String[] args){
			demo9_1 d = new demo9_1();
		}
		public demo9_1()
		{
			//只是实例化Panel子类MyPanel,并没有调用paint()方法。页面显示出圆圈，可见是系统自动调用的
			MyPanel mp = new MyPanel();
			this.add(mp);
			this.setSize(400,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}

class MyPanel extends JPanel
{
	//覆盖JPanel的paint方法
	//Graphics 是绘图的重要类，就是一个画笔
	//该方法在程序运行之初，会被系统自动调用，
	//以下场景也会再次调用
	/**
	 * 窗口大，窗口小
	 * 窗口大小发生变化
	 * repaint函数被调用
	 */
	public void paint(Graphics g)
	{
		//调用父类函数初始化
		super.paint(g);
		//画一个圆圈
		//g.drawOval(10, 10, 30, 30);
		//画直线
		//g.drawLine(10, 10, 40, 40);
		
		//画矩形边框
		//g.drawRect(10, 10, 40, 60);
		
		//画填充矩形
		//首先设置填充色（默认是黑色）
		g.setColor(Color.blue);
		g.fillRect(10, 10, 40, 60);
		System.out.println("Paint调用了");
	}
	//还有一个重要的方法repaint。刷新外观
}