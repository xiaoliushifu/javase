//这是model类  ------>Goods表
package com.liu.model;


public class GoodsBean {
	private Integer goodsId ;
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
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * @return the goodsIntro
	 */
	public String getGoodsIntro() {
		return goodsIntro;
	}
	/**
	 * @param goodsIntro the goodsIntro to set
	 */
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	/**
	 * @return the goodsPrice
	 */
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * @return the goodsNum
	 */
	public Byte getGoodsNum() {
		return goodsNum;
	}
	/**
	 * @param goodsNum the goodsNum to set
	 */
	public void setGoodsNum(Byte goodsNum) {
		this.goodsNum = goodsNum;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	private String goodsName;
	private String  goodsIntro;
	private Float   goodsPrice;
	private Byte   goodsNum;
	private String  publisher;
	private String  photo;
	private String  type;
}
