/**
 * 用来管理服务端与客户端的套接字，套接字存在于服务端的线程里
 * 该类用来管理服务端与每个客户都会启动的线程
 */
package com.qq.server.model;

import java.util.HashMap;

public class ManageServerThread {
	public static HashMap hm=new HashMap<String, ServerToClientThread>();
	
	//添加一个客户端进程到hm中
	public static void addClientThread(String uid,ServerToClientThread stct) {
		hm.put(uid, stct);
	}
	
	//根据用户id，获得它的线程
	public static ServerToClientThread getClientThread(String uid) {
		return (ServerToClientThread) hm.get(uid);
	}
	
}
