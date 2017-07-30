/**
 * FlowLayout流式布局
 * 不限制所管理组件的大小，允许他们有最佳大小
 * 当容器缩放时，组件位置可能会变化，但是组件大小不变
 * 流式布局默认是居中对齐
 */
package com.test1;

import java.awt.*;
import javax.swing.*;
public class GuiDemo3 extends JFrame {

	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo3 g3=new GuiDemo3();
	}
	
	public GuiDemo3()
	{
		jb1 = new JButton("关羽");
		jb2 = new JButton("张飞");
		jb3 = new JButton("赵云");
		jb4 = new JButton("马超");
		jb5 = new JButton("黄忠");
		jb6 = new JButton("威严");
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//添加流式布局管理器(左对齐，居中，拖尾）
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		//禁止用户改变窗体大小
		this.setResizable(false);
		
		this.setTitle("流式布局");
		this.setSize(200,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
