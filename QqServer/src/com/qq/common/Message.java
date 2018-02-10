/**
 * QQ客户端和服务端交互的消息载体
 */
package com.qq.common;

public class Message implements java.io.Serializable{
	private String mesType;

	/**
	 * @return the mesType
	 */
	public String getMesType() {
		return mesType;
	}

	/**
	 * @param mesType the mesType to set
	 */
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	
}
