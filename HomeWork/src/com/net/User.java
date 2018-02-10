package com.net;

/**
 * 这点和php是一样的，在网络间传输信息都是字符串
 * 所以，对象如果想在网络间传递，需要实现序列化接口，让它在最终把对象发送到网络之前序列化为一个字符串
 * 同时，服务端在接收到这个字符串后，也需要及时反序列化为指定的对象。感觉好像在网络间传递对象一般。
 * @author Administrator
 *
 */


public class User implements java.io.Serializable{
	private String name;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	private String pass;
}
