/**
 * 几个常用控件（表单项） 
 * JPanel  面板
 * JLable  标签
 * JButton 按钮
 * JRadioButton 单选
 * JCheckBox 复选框
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
public class GuiDemo7 extends JFrame {

	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	//复选框
	JCheckBox jcb1,jcb2,jcb3;
	//单选框
	JRadioButton jrb1,jrb2,jrb3;
	//按钮组，容器控件
	ButtonGroup bg;
	//密码域
	JPasswordField jpf1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo7 g7=new GuiDemo7();
	}
	
	public GuiDemo7()
	{
		
		//创建控件
		jlb1=new JLabel("你喜欢的运动");
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("乒乓球");
		
		jlb2=new JLabel("你的性别");
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		//需要把radiobutton放到button组中
		//放到数组里，只是说明它们是多选一
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		//创建面板1
		jp1 = new JPanel();
		//为面板1添加控件
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		//创建面板2
		jp2 = new JPanel();
		//为面板2添加控件
		jp2.add(jlb2);
		jp2.add(jrb1);//radio仍然得一个个得添加
		jp2.add(jrb2);
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
