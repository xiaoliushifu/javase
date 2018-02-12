/**
 * 聊天界面
 * 
 * 聊天界面需要读取由服务端转发而来的消息，所以需要实现线程
 */
package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.MyClient;
import com.qq.common.Message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;

public class Qqchat extends JFrame implements ActionListener,Runnable{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp=null;
	String ownerId;
	String friendId;
	
	public Qqchat(String ownerId,String friendNo)	{
		this.ownerId=ownerId;
		this.friendId = friendNo;
		jta =new JTextArea();
		jsp=new JScrollPane(jta);
		
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		this.add(jsp,"Center");
		this.add(jp,"South");
		
		this.setTitle(ownerId+"正在和"+friendNo+"聊天");
		//加个图标，默认就是那个java图标
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			Message m = new Message();
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			jtf.setText("");
			m.setSendTime(new java.util.Date().toString());//获得当前时间
			
			//在该页面，如何获得客户端的套接字呢？也就是在MyClient.java里的socket呢？
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(MyClient.s.getOutputStream());
				oos.writeObject(m);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	//该线程不断读取由服务端转发而来的消息
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//读取服务端的消息
			try {
				ObjectInputStream ois = new ObjectInputStream(MyClient.s.getInputStream());
				Message m = (Message) ois.readObject();
				String info = m.getSender()+"给"+m.getGetter()+"说："+m.getCon()+"\n";
				this.jta.append(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
