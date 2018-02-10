/**
 * 这是客户端程序
 * 可以从输入框输入数据和服务端交互，比控制台更高级些
 */
package com.net3;
import java.net.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyClient extends JFrame implements ActionListener{

	JPanel jp = null;
	JTextArea jta = null;
	JScrollPane jsp = null;
	JTextField jtf = null;
	JButton jb =null;
	PrintWriter pw = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient c= new MyClient();
	}
	
	public MyClient(){
		//为了滚动效果
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
		
		this.setTitle("简单聊天程序 客户端");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		try {
			Socket s = new Socket("127.0.0.1",9999);
			
			//输出流，用pw向s的输出流发送信息，true表示在调用（print,println等方法时）及时刷新缓冲区
			pw = new PrintWriter(s.getOutputStream(),true);
			
			//输入流，客户端读取服务端发来的数据
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			while(true){
				//不断读取服务端发来的数据
				String info = br.readLine();
				jta.append("服务端:"+info+"\n");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			//从文本框获得数据
			String str = jtf.getText();
			pw.println(str);
			jtf.setText("");
			jta.append("客户端 :"+str+"\n");
		}
	}

}
