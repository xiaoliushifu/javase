package com.liu.model;

public class OrderDetailBean {
	
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
	 * @return the goodsId
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * @return the nums
	 */
	public Integer getNums() {
		return nums;
	}
	/**
	 * @param nums the nums to set
	 */
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	private Integer goodsId;
	private Integer nums;
    
}
