package com.qq.server.view;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class MyServerFrame extends JFrame {

	JPanel jp;
	JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServerFrame msf = new MyServerFrame();
	}

	public MyServerFrame(){
		jp = new JPanel();
		jb1=new JButton("启动服务器");
		jb2=new JButton("停止服务器");
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
