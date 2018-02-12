/**
 * 客户端和服务端通讯的线程
 */

package com.qq.client.tools;

import java.net.*;
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
				//通过客户端进程管理器，获得指定客户端的线程，进而获得该客户端的套接字
				//ServerToClientThread stct = ManageClientThead.getClientThread(m.getGetter());
				//ObjectOutputStream oos = new ObjectOutputStream(stct.s.getOutputStream());
				//把信息转发过去（这个客户端的聊天界面，得不停地接收服务端的消息才行）
				//oos.writeObject(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
