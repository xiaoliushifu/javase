package com.xiaoqiang;

public class Test2 {
	//在其他包中，只有public的成员a可以让对象访问到
	//其他三个成员都不能访问到
	public int a;
	protected String name;
	String color;
	private int age;
	
	public void ab1()
	{
		//在不混淆的情况下，在方法内部访问成员属性时，也可以不加this.
		//有意思不？？嘿嘿
		System.out.println(a);
		System.out.println(this.a);
	}
}

class Dog
{
	public int a;
	protected String name;
	String color;
	private int age;
	
}
