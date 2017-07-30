package com.test1;

import java.awt.*;
import javax.swing.*;
//JFrame是顶层的容器类
public class GuiDemo1 extends JFrame {
	
	//一个按钮控件
	JButton jb1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo1 jf = new GuiDemo1();
		
	}
	//来个构造函数
	public GuiDemo1()
	{
		//给窗体设置标题
		this.setTitle("Hello world");;
		
		//创建一个button,孤零零地，需要填充到容器中
		jb1=new JButton("我是按钮");
		//添加一个按钮，默认占满整个窗口
		this.add(jb1);
		
		//默认点击窗口的X按钮关闭窗口时，javaw.exe仍然在后台运行，JVM不退出，消耗内存。可使用关闭事件来退出内存
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//设置窗体大小（像素）
		this.setSize(300,200);
		
		//设置窗体坐标（屏幕左上角为（0，0））
		this.setLocation(100, 568);
		//显示在电脑屏幕上
		this.setVisible(true);
	}

}
