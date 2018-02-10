package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyServer;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyServerFrame extends JFrame implements ActionListener {

	JPanel jp;
	JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServerFrame msf = new MyServerFrame();
	}

	public MyServerFrame(){
		jp = new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("停止服务器");
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==jb1) {
			new MyServer();
		}
	}
}
