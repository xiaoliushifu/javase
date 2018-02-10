/**
 * 用于验证和处理客户端的用户登录的问题
 * 目前是通过客户端套接字建立连接把用户信息直接发送给服务端，去验证
 */
package com.qq.client.model;

import com.qq.common.*;

public class QqClientUser {

	public boolean checkUser(User u) {
		return new MyClient().sendLoginInfoToServer(u);
	}
}
