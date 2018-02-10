/**
 * 这是qq服务器，监听这指定端口，等待连接
 */
package com.qq.server.model;
import java.net.*;
import java.io.*;

public class MyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MyServer() {
		try {
			ServerSocket ss = new ServerSocket(9999);
			//阻塞到这，等待客户端连接，就是所谓的监听。
			Socket s = ss.accept();
			//一旦有客户连接成功，s将被返回，成为活跃的套接字对象
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String info = br.readLine();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
