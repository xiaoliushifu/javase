/**
 * 这是hibernate测试使用到的实体类
 * 还需要一个对应的xml文件，并且映射配置到hibernate配置文件中
 */
package spring.entity;

public class Goods {
	private Integer goodsID;
	private String goodsName;
	private Float price;
	private Integer amount;
	
	/**
	 * @return the goodsID
	 */
	public Integer getGoodsID() {
		return goodsID;
	}
	/**
	 * @param goodsID the goodsID to set
	 */
	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
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
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", goodsName=" + goodsName + ", price=" + price + "]";
	}
	public Goods(Integer goodsID, String goodsName, Float price, Integer amount) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.price = price;
		this.amount = amount;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

}
