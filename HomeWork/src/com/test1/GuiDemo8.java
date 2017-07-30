/**
 * 几个常用控件（表单项） 
 * JPanel  面板
 * JLable  标签
 * 
 * 
 * 所有的单选框，应该放置到一个按钮组
 * ButtonGroup 单选框组
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
public class GuiDemo8 extends JFrame {

	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb1;//类似于select控件
	//这俩组件在HTML中没有见过好像
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo8 g7=new GuiDemo8();
	}
	
	public GuiDemo8()
	{
		
		//创建控件
		jlb1=new JLabel("你的籍贯");
		String jp[]={"北京","上海","河北","火星"};
		jcb1 = new JComboBox(jp);
		
		
		jlb2=new JLabel("旅游地");
		String dd[]={"九寨沟","故宫","长城","京娘湖"};
		jlist = new JList(dd);
		//每次显示2个
		jlist.setVisibleRowCount(2);
		//可以滚动条
		jsp =new JScrollPane(jlist);
		
		//创建面板1
		jp1 = new JPanel();
		//为面板1添加控件
		jp1.add(jlb1);
		jp1.add(jcb1);
		
		//创建面板2
		jp2 = new JPanel();
		//为面板2添加控件
		jp2.add(jlb2);
		jp2.add(jsp);
		
		//把三个面板都添加到窗体
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		
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
