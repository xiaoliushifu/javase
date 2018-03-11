/**
 * @(#)UserBean.java
 * userbean是关联user表的一个类
 * userbean的对象，代表user表的一个记录
 * 很像Yii2里的AR
 *
 * @author 
 * @version 1.00 2018/3/11
 */
package com.liu;

public class UserBean {

    private int id=0;
    private String uname="";
    private String pass="";
    private int age=0;
    
    public void setId(int id){
    	this.id=id;
    }
    public int getId(){
    	return this.id;
    }

	
	public void setUname(String uname) {
		this.uname = uname; 
	}

	public void setPass(String pass) {
		this.pass = pass; 
	}

	public void setAge(int age) {
		this.age = age; 
	}

	public String getUname() {
		return (this.uname); 
	}

	public String getPass() {
		return (this.pass); 
	}

	public int getAge() {
		return (this.age); 
	}
    
}