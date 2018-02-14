/**
 * 用来管理服务端与客户端的套接字，套接字存在于服务端的线程里
 * 该类用来管理服务端与每个客户都会启动的线程
 */
package com.qq.server.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
	
	/**
	 * 返回所有在线用户的id
	 * 初次使用迭代器
	 * @return
	 */
	public static String getAllOnlineUserId() {
		//迭代器，使之可以遍历，迭代器具有普遍性。
		//其实如果知道当前hashMap的key是字符串的话，可以使用字符串数组来接收key，更精准
		Iterator it = hm.keySet().iterator();
		String res="";
		while(it.hasNext()) {
			res += it.next().toString()+" ";
		}
		return res;
	}
	
}
