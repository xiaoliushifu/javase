/**
 * 聊天界面
 */
package com.qq.client.view;

import javax.swing.*;
import java.awt.*;

public class Qqchat extends JFrame{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qqchat qc = new Qqchat("2");
	}
	
	public Qqchat(String friendNo)	{
		jta =new JTextArea();
		jsp=new JScrollPane(jta);
		
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		this.add(jsp,"Center");
		this.add(jp,"South");
		
		this.setTitle("你正在和"+friendNo+"聊天");
		//加个图标，默认就是那个java图标
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
