/**
 * 有些情况下，必须使用继承
 * 编写桌面程序的JFrame类
 */
package com.mingwei;

//导入其他包中的类
import javax.swing.*;
public class Demo2 extends JFrame {
	public static void main(String []args)
	{
		Demo2 demo2=new Demo2();
	}
	
	public Demo2()
	{
		this.setVisible(true);
		this.setSize(200,200);
		
	}
}
