package spring.entity;

import java.util.Date;

public class Monster {
	private Integer monsterId;
	private String monsterName;
	private String email;
	private Date Birthday;
	private Date entryDate;
	private School school;
	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Monster [monsterId=" + monsterId + ", monsterName=" + monsterName + ", email=" + email + ", Birthday="
				+ Birthday + ", entryDate=" + entryDate + ", school=" + school + "]";
	}
	public Monster(Integer monsterId, String monsterName, String email, Date birthday, Date entryDate, School school) {
		super();
		this.monsterId = monsterId;
		this.monsterName = monsterName;
		this.email = email;
		Birthday = birthday;
		this.entryDate = entryDate;
		this.school = school;
	}
	/**
	 * @return the monsterId
	 */
	public Integer getMonsterId() {
		return monsterId;
	}
	/**
	 * @param monsterId the monsterId to set
	 */
	public void setMonsterId(Integer monsterId) {
		this.monsterId = monsterId;
	}
	/**
	 * @return the monsterName
	 */
	public String getMonsterName() {
		return monsterName;
	}
	/**
	 * @param monsterName the monsterName to set
	 */
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
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
	 * @return the birthday
	 */
	public Date getBirthday() {
		return Birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}
	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}
}
