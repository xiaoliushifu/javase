/**
 * OrderBean
 */
package com.liu.model;

import java.util.*;
public class OrderBean {
	
	private Integer ordersId; 
	/**
	 * @return the ordersId
	 */
	public Integer getOrdersId() {
		return ordersId;
	}
	/**
	 * @param ordersId the ordersId to set
	 */
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the payMode
	 */
	public String getPayMode() {
		return payMode;
	}
	/**
	 * @param payMode the payMode to set
	 */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	/**
	 * @return the isPayed
	 */
	public Byte getIsPayed() {
		return isPayed;
	}
	/**
	 * @param isPayed the isPayed to set
	 */
	public void setIsPayed(Byte isPayed) {
		this.isPayed = isPayed;
	}
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	private Integer userId;
	private Date orderDate;
	private String payMode;
	private Byte isPayed;
	private float totalPrice;
}