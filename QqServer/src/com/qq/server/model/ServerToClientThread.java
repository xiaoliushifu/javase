/**
 * 服务端和某个客户端的通讯线程
 * 如果有多个客户端登录，则这里将会保存多个客户端的线程，一对多
 */
package com.qq.server.model;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;

import javax.naming.ldap.ManageReferralControl;

import com.qq.common.Message;
import com.qq.common.MessageType;

import java.io.*;

public class ServerToClientThread extends Thread {

	Socket s;
	public ServerToClientThread(Socket s) {
		this.s = s;
	}
	
	/**
	 * 通知其他在线用户，我iam已经在线了
	 * 需要遍历套接字发送信息
	 * @param iam
	 */
	public void notifyOther(String iam) {
		
		Message m=new Message();
		m.setCon(iam);
		m.setMesType(MessageType.message_ret_onLineFriends);
		HashMap hm=ManageServerThread.hm;
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			String onLineUserId = it.next().toString();
			//不用通知自己
			if(onLineUserId.equals(iam)) {
				continue;
			}
			m.setGetter(onLineUserId);
			try {
				ObjectOutputStream oos = new ObjectOutputStream
						(ManageServerThread.getClientThread(onLineUserId).s.getOutputStream());
				oos.writeObject(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//继承Thread类必须实现的方法
	public void run() {
		//接收客户端的消息
		while(true) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(this.s.getInputStream());
				Message m = (Message) ois.readObject();
				//根据客户端的信息类型，分别处理
				if(m.getMesType().equals(MessageType.message_comm_mes)) {
					System.out.println(m.getSender()+"给"+m.getGetter()+"说："+m.getCon());
					//通过客户端进程管理器，获得指定客户端的线程，进而获得该客户端的套接字
					ServerToClientThread stct = ManageServerThread.getClientThread(m.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(stct.s.getOutputStream());
					//把信息转发过去（这个客户端的聊天界面，得不停地接收服务端的消息才行）
					oos.writeObject(m);
				}
				if(m.getMesType().equals(MessageType.message_get_onLineFriends)) {
					System.out.println(m.getSender()+"向服务端要好友列表");
					String res = ManageServerThread.getAllOnlineUserId();
					//组装服务端返回给客户端的包
					Message m2 = new Message();
					m2.setMesType(MessageType.message_ret_onLineFriends);
					m2.setGetter(m.getSender());
					m2.setCon(res);
					ObjectOutputStream oos = new ObjectOutputStream(this.s.getOutputStream());
					oos.writeObject(m2);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
