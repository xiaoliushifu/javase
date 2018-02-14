/**
 * 客户端和服务端通讯的线程
 * 一旦某个客户端成功登录，就开启一个客户端线程，该线程保存客户端和服务端通讯的套接字s,
 * 用来处理后续和服务端通讯的情况
 */

package com.qq.client.tools;

import java.net.*;

import com.qq.client.view.Qqchat;
import com.qq.common.Message;

import java.io.*;

public class ClientToServerThread extends Thread {

	private Socket s;
	/**
	 * @return the s
	 */
	public Socket getS() {
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(Socket s) {
		this.s = s;
	}
	public ClientToServerThread(Socket s) {
		this.s = s;
	}
	//继承Thread类必须实现的方法
	public void run() {
		//接收客户端的消息
		while(true) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(this.s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println("读取到从服务端发来的消息:"+m.getSender()+"给"+m.getGetter()+" "+m.getCon());
				//从ManageQqchat中获得聊天界面，把从服务端返回的信息，显示出来；根据getter和sender的组合作为key来获取
				//这是解决同一个人和多个人同时聊天并发问题的关键
				Qqchat qc = ManageQqChat.getQqchat(m.getGetter()+" "+m.getSender());
				qc.showMessage(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
