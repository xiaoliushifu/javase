/**
 * 这是客户端程序
 */
package com.net;
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
			//用pw向s的输出流发送信息，true表示在调用（print,println等方法时）及时刷新缓冲区
			//PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			//pw.println("你好，我是客户端");
			
			//对象流，专门用于在网络的双方之间交换对象信息【START】
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			User u = new User();
			u.setName("刘师傅");
			u.setPass("123456");
			oos.writeObject(u);
			//对象流【END】
			
			//客户端读取服务端发来的数据，从外到内，同理也是从Input流开始，经过几次倒腾
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//最终读取客户端发来的数据
			String info = br.readLine();
			System.out.println("接收服务端的信息："+info);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
