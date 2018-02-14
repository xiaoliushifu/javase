/**
 * 为了解决单个人和多个人互相聊天的并发问题（我对张三,我对李四）
 * 使用该类来管理聊天界面
 */
package com.qq.client.tools;

import java.util.HashMap;

import com.qq.client.view.Qqchat;

public class ManageQqChat {
	private static HashMap hm = new HashMap<String,Qqchat>();
	
	/**
	 * 加入到HashMap中，key是登录者id和对方登录者id的拼接
	 * 可以保持唯一性
	 * @param loginIdAndFriendId
	 * @param qqchat
	 */
	public static void addQqchat(String loginIdAndFriendId,Qqchat qqchat) {
		hm.put(loginIdAndFriendId, qqchat);
	}
	
	//获得
	public static Qqchat getQqchat(String loginIdAndFriendId) {
		return (Qqchat) hm.get(loginIdAndFriendId);
	}
}
