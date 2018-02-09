/**
 * 这是服务端程序，监听在9999端口
 * 可以通过控制台来输入数据和客户端交互，不是写死在代码里的
 */
package com.net2;

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
			System.out.println("我是服务端正监听在9999...");
			//服务端开始监听，一旦有客户端连接成功，accept返回一个Socket对象，也叫连接对象。全程处理本次的连接
			Socket s = ss.accept();
			
			//输入流，即从客户端来的
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			//输出流，要写给客户端的
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			//输入流，服务端从控制台读取数据，将来发送给客户端
			InputStreamReader isr2 =new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);
			
			//最终读取客户端发来的数据
			while(true){
				//不断读取客户端发来的信息
				String info = br.readLine();
				System.out.println("客户端发来："+info);
				
				if(info.equals("bye")){
					System.out.println("服务端走了");
					s.close();
					break;
				}
				
				System.out.println("请输入发给客户端的信息");
				//服务端从控制台读取数据，发送给客户端
				String toclient= br2.readLine();
				pw.println(toclient);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
