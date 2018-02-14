/**
 * 聊天界面
 * 
 * 聊天界面需要读取由服务端转发而来的消息，所以需要实现线程
 * 由于我和张三聊天，我和李四聊天这种一对多同时聊天出现的争抢客户端套接字资源问题
 * 所以Qqchat不能使用线程了，需要交由管理类来实现
 * 聊天界面在打开时就加入到管理类的hashMap中
 */
package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.MyClient;
import com.qq.client.tools.ManageClientThread;
import com.qq.common.Message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;

public class Qqchat extends JFrame implements ActionListener{

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

	/**
	 * 在打开的聊天界面中，显示从服务器接收的聊天信息
	 * @param m
	 */
	public void showMessage(Message m) {
		String info = m.getSender()+"给"+m.getGetter()+"说："+m.getCon()+"\n";
		this.jta.append(info);
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
			//经过调整后，通过客户端线程管理器首先获得线程，进而再获得套接字
			try {
				ObjectOutputStream oos = new ObjectOutputStream
						(ManageClientThread.getClientThread(this.ownerId).getS().getOutputStream());
				oos.writeObject(m);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//该线程不断读取由服务端转发而来的消息
	/*public void run() {
		System.out.println(this.ownerId+"和"+this.friendId+"的套接字是"+MyClient.s.hashCode());
		// TODO Auto-generated method stub
		while(true) {
			//读取服务端的消息
			try {
				//一对多聊天时，静态成员变量MyClient.s就会出现争抢的问题
				ObjectInputStream ois = new ObjectInputStream(MyClient.s.getInputStream());
				Message m = (Message) ois.readObject();
				String info = m.getSender()+"给"+m.getGetter()+"说："+m.getCon()+"\n";
				this.jta.append(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

}
