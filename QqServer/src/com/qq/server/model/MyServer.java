/**
 * 这是qq服务器，监听这指定端口，等待连接
 */
package com.qq.server.model;
import java.net.*;

import com.qq.common.*;

import java.io.*;

public class MyServer {

	//服务端管理套接字
	public static ServerSocket ss;
	public MyServer() {
		try {
			System.out.println("服务端开始监听这9999......");
			ss = new ServerSocket(9999);
			
			//长时间的监听，需要无线循环
			while(true){
				//阻塞到这，等待客户端连接，就是所谓的监听。
				Socket s = ss.accept();
				
				//获得对象输入流
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User) ois.readObject();
				Message m = new Message();
				//准备对象输出流
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456")) {
					//返回一个成功登录的信息包Message
					m.setMesType("1");
					oos.writeObject(m);//发送对象输出流
					
					//登录成功，服务端就开启一个线程，该线程与这个客户端保持通讯
					ServerToClientThread stct = new ServerToClientThread(s);
					stct.start();//启动线程
					//用户和套接字的映射关系，加入到服务端的hashMap中
					ManageServerThread.addClientThread(u.getUserId(), stct);
					
				} else {
					m.setMesType("2");
					oos.writeObject(m);
					s.close();//错误时，服务端关闭本次连接，继续循环，又开始新的监听
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
