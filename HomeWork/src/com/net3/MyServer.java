/**
 * 这是服务端程序，监听在9999端口
 * 可以通过输入框来互相发送信息，比控制台更好了
 */
package com.net3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MyServer extends JFrame implements ActionListener{
	
	JPanel jp = null;
	JTextArea jta = null;
	JScrollPane jsp = null;
	JTextField jtf = null;
	JButton jb =null;
	
	//全局变量pw,可以实现在响应方法里向客户端发送数据
	PrintWriter pw=null;
	public static void main(String[] args){
		MyServer ms = new MyServer();
	}
	//构造方法
	public MyServer(){
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		
		jtf = new JTextField(20);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp = new JPanel();
		//按钮和输入框在面板里
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		//文本域直接在窗体中
		this.add(jsp,"Center");
		
		this.setTitle("简单聊天程序 服务端");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		try {
			//创建服务端套接字对象，准备监听在9999端口
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("我是服务端正监听在9999...");
			//服务端开始监听，一旦有客户端连接成功，accept返回一个Socket对象，也叫连接对象。全程处理本次的连接
			Socket s = ss.accept();
			
			//输入流，即从客户端来的
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//输出流，要写给客户端的，在响应方法里完成发送
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true){
				//不断读取客户端发来的信息
				String info = br.readLine();
				jta.append("客户端:"+info+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==jb) {
			//服务端从文本框读入数据，发送给客户端
			String str = jtf.getText();
			pw.println(str);
			//清空文本框
			jtf.setText("");
			//把该段文字添加到文本域中
			jta.append("服务端:"+str+"\n");
		}
	}
}
