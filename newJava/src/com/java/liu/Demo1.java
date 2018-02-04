package com.java.liu;

public class Demo1 {
	private String name = "好人";
	protected byte age = 100;
	public String nickName ="老张";
}

/**
 * 一个java文件里，最多只能有一个public  Class，且java文件名必须和这个public的类名一样
 * @author Administrator
 *
 */
//public class Demo2 extends Demo1 {
class Demo2 extends Demo1 {
	//main方法也可以写在不是public的类Demo2里，但是java编译器并不会自动识别到main方法
	//因为java编译器是根据java文件名找main方法，java文件名是Demo1,但是Demo1类又没有main方法。
	//这种情况，就应该主动调用Demo2的main方法才行
	public static void main(String args[]){
		Demo2 d=new Demo2();
		System.out.println(d.getAge());
		System.out.println(d.getName());
	}
	//子类虽然不能继承父类的name,但是子类完全可以自己定义一个和父类私有成员name名字一样，类型一样的成员变量
	//来使用。虽然此name非彼name，但是又有什么限制呢？
	private String name= "坏人";
	
	
	

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

	/**
	 * @return the age
	 */
	public Byte getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setName(Byte age) {
		this.age = age;
	}
	
}