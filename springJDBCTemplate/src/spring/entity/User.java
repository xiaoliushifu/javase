/**
 * 这是hibernate测试使用到的实体类
 * 还需要一个User.hbm.xml文件，两个是一对都在同一个目录下
 */
package spring.entity;

public class User {
	private Integer userId;
	private String userName;
	private Double money;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the money
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	public User(Integer userId, String userName, Double money) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.money = money;
	}
}
