/**
 * 用于订单成功后，方便一次性获得订单信息（订单和订单详情信息）
 */
package com.liu.model;

public class OrderInfoBean {
	
	private String username;
	private String truename;
	private String passwd;
	private String email;
	private String phone;
	private String address;
	private String postcode;
	private Byte grade;
	private Integer ordersId;
	private Float totalPrice;
	
	/**
	 * @return the totalPrice
	 */
	public Float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
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
	private Integer userid;
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the truename
	 */
	public String getTruename() {
		return truename;
	}
	/**
	 * @param truename the truename to set
	 */
	public void setTruename(String truename) {
		this.truename = truename;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the grade
	 */
	public Byte getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Byte grade) {
		this.grade = grade;
	}
	
    
}
