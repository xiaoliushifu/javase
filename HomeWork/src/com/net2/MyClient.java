/**
 * 这是客户端程序
 * 可以从控制台读入数据，发送给服务端
 */
package com.net2;
import java.net.*;
import java.io.*;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient c= new MyClient();
	}
	
	public MyClient(){
		try {
			//下面这行代码，会立即连接指定ip：port的套接字
			Socket s = new Socket("127.0.0.1",9999);
			
			//输出流，用pw向s的输出流发送信息，true表示在调用（print,println等方法时）及时刷新缓冲区
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			//输入流，客户端读取服务端发来的数据
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			//输入流,读取控制台输入的信息
			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);
			
			while(true){
				//客户端从控制台读取数据，发送给服务端，客户端先发送数据
				System.out.println("请输入发给服务端的消息");
				String locStr = br2.readLine();
				pw.println(locStr);
				if(locStr.equals("bye")){
					System.out.println("我客户端要走了");
					s.close();
					break;
				}
				
				//不断读取服务端发来的数据
				String info = br.readLine();
				System.out.println("服务端发来："+info);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
