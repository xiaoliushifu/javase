/**
 * 管理好友列表的类
 * 使用HashMap
 */
package com.qq.client.tools;

import java.util.*;

import com.qq.client.view.QqFriendList;

public class ManageFriendList {
	private static HashMap hm = new HashMap<String,QqFriendList>();
	
	public static void addQqFriendList(String qq,QqFriendList flist) {
		hm.put(qq,flist);
	}
	
	public static QqFriendList getQqFriendList(String qq) {
		return (QqFriendList) hm.get(qq);
	}
}
