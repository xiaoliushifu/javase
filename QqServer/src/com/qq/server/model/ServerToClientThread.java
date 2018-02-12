/**
 * 服务端和某个客户端的通讯线程
 * 如果有多个客户端登录，则这里将会保存多个客户端的线程，一对多
 */
package com.qq.server.model;

import java.net.*;

import com.qq.common.Message;

import java.io.*;

public class ServerToClientThread extends Thread {

	Socket s;
	public ServerToClientThread(Socket s) {
		this.s = s;
	}
	//继承Thread类必须实现的方法
	public void run() {
		//接收客户端的消息
		while(true) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(this.s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println(m.getSender()+"给"+m.getGetter()+"说："+m.getCon());
				
				//通过客户端进程管理器，获得指定客户端的线程，进而获得该客户端的套接字
				ServerToClientThread stct = ManageServerThread.getClientThread(m.getGetter());
				ObjectOutputStream oos = new ObjectOutputStream(stct.s.getOutputStream());
				//把信息转发过去（这个客户端的聊天界面，得不停地接收服务端的消息才行）
				oos.writeObject(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
