package com.liu.struts.bean;

import java.time.LocalDate;

public class Pet {
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nickName=" + nickName + ", resume=" + resume + "]";
	}
	public Pet(Integer id, String nickName, String resume, LocalDate birthDay) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.resume = resume;
		this.birthDay = birthDay;
	}
	private Integer id;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}
	private String nickName;
	private String resume;
	
	private LocalDate birthDay;
	/**
	 * @return the birthDay
	 */
	public LocalDate getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
}
