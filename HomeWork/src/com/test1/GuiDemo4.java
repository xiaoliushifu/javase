/**
 * 网格布局管理，将窗体分割成多行多列
 * 适合开发计算器
 * 随窗口缩放，组件大小会变化，但所有组件大小都相同的，且相对位置不会变化
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
public class GuiDemo4 extends JFrame {

	//再次学习，java数组初始化时，必须指定大小
	//左边的[]可以放的位置是 
	//	JButton[] jbs
	//	JButton  []jbs
	//	JButton jbs[]
	//右边的写法仅仅一种： Type[10]
	
	JButton[] jbs=new JButton[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo4 g4=new GuiDemo4();
	}
	
	public GuiDemo4()
	{
		int i=0;jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;
		jbs[i]=new JButton(String.valueOf(i));this.add(jbs[i]);i++;

		//设置网格布局管理器(行列，水平间距，垂直间距）
		this.setLayout(new GridLayout(3,3,5,10));
		
		//禁止用户改变窗体大小
		//this.setResizable(false);
		
		this.setTitle("网格布局管理器案例");
		this.setSize(200,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
