package com.qq.client.tools;

import java.util.HashMap;

public class ManageClientThread {
		public static HashMap hm=new HashMap<String, ClientToServerThread>();
		
		//添加一个客户端进程到hm中
		public static void addClientThread(String uid,ClientToServerThread ctct) {
			hm.put(uid, ctct);
		}
		
		//根据用户id，获得它的线程
		public static ClientToServerThread getClientThread(String uid) {
			return (ClientToServerThread) hm.get(uid);
		}
}
