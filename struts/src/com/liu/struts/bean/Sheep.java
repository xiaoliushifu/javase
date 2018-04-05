package com.liu.struts.bean;

public class Sheep {
	public Sheep() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sheep(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	private String name;
}
