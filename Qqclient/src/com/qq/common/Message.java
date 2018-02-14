/**
 * QQ客户端和服务端交互的消息载体
 */
package com.qq.common;

public class Message implements java.io.Serializable{
	private String mesType;
	private String sender;
	private String getter;
	private String con;
	private String sendTime;
	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the getter
	 */
	public String getGetter() {
		return getter;
	}

	/**
	 * @param getter the getter to set
	 */
	public void setGetter(String getter) {
		this.getter = getter;
	}

	/**
	 * @return the con
	 */
	public String getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(String con) {
		this.con = con;
	}

	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

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
