/**
 * 客户端的套接字，用于连接服务器
 */
package com.qq.client.model;

import java.util.*;

import com.qq.client.tools.ClientToServerThread;
import com.qq.client.tools.ManageClientThread;
import com.qq.common.Message;
import com.qq.common.User;

import java.net.*;
import java.io.*;

public class MyClient {


	//用静态成员变量s的优点是，可以让这个套接字在多个java文件里共享访问，非常方便。
	//缺点是，当一个客户端和多个客户端聊天时，那么多个聊天窗口里的进程都将争抢MyClient.s
	//比如 1和2,1和3两个聊天。1分别向他们发送消息是OK的。2的MyClient与3的MyClient也是不冲突的，
	//2和3的进程是独立的，所以MyClient也是独立的；
	//但是2向1或者3向1发是不行的。
	//因为1号客户端是在一个进程下开启了两个窗口，两个窗口就是两个线程，
	//多线程争抢1号客户端的MyClient.s就会出问题
	public static Socket s;
	//发送登录信息到服务端
	public boolean sendLoginInfoToServer(Object o) {
		boolean b=false;
		try {
			//客户端初次建立与服务端的套接字，并保存到静态变量s里
			s = new Socket("127.0.0.1",9999);
			//初始化对象流，输出流
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			//初始化对象流，输入流
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message) ois.readObject();
			if(ms.getMesType().equals("1")) {
				//一旦登录成功，就开启一个线程，该线程被ManageClientThread管理起来
				ClientToServerThread ctst = new ClientToServerThread(s);
				ManageClientThread.addClientThread(((User)o).getUserId(), ctst);
				ctst.start();
				b=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return b;
	}
	public void sendInfoToServer(Object o) {
		try {
			Socket s = new Socket("127.0.0.1",9999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
