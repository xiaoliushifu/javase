/**
 * 客户端的套接字，用于连接服务器
 */
package com.qq.client.model;

import java.util.*;

import com.qq.common.Message;

import java.net.*;
import java.io.*;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MyClient() {
		/*try {
			Socket s = new Socket("127.0.0.1",9999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
				
	}
	
	//发送登录信息到服务端
	public boolean sendLoginInfoToServer(Object o) {
		boolean b=false;
		try {
			Socket s = new Socket("127.0.0.1",9999);
			//初始化对象流，输出流
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			//初始化对象流，输入流
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message) ois.readObject();
			if(ms.getMesType().equals("1")) {
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
