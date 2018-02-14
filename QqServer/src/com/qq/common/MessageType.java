/**
 * 为了便于管理信息包的种类
 * 特此增加该接口，定义信息包的类型
 */
package com.qq.common;

public interface MessageType {
	String message_login_succeed ="1";//登录成功
	String message_login_fail="2";//登录失败
	String message_comm_mes="3";//普通聊天信息包
	String message_get_onLineFriends="4";//请求某客户端的在线好友包
	String message_ret_onLineFriends="5";//获得某客户端的在线好友包
}
