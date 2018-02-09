/**
 * 这是服务端程序，监听在9999端口
 */
package com.net;

import java.io.*;
import java.net.*;

public class MyServer {
	
	public static void main(String[] args){
		MyServer ms = new MyServer();
	}
	//构造方法
	public MyServer(){
		try {
			//创建服务端套接字对象，准备监听在9999端口
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("我是服务端，正在监听，等待客户端来连接...");
			//服务端开始监听，一旦有客户端连接成功，accept返回一个Socket对象，也叫连接对象。全程处理本次的连接
			Socket s = ss.accept();
			
			//连接对象读取客户端的数据，客户端发来的数据是由外到内的过程，需要Input流
			//不是直接进来的，而是经过好几个输入流的倒腾才进来的
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//最终读取客户端发来的数据
			String info = br.readLine();
			System.out.println("接收客户端的信息："+info);
			
			
			//有来有往，下面是服务端要向客户端发送数据了，需要Output流
			//并不是直接发送，还需要PrintWriter倒腾一次。
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("我是服务端，你也好啊");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
