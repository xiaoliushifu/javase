package com.mingwei;

public class Demo2
{
	public static void main(String []args)
	{
		Abc a=new Abc();
		//向下面这种调用getMax方式，会调用Abc类的第一个方法还是第二个方法呢？
		//第二个，因为整数类型会强制转换给高精度的float类型
		System.out.println(a.getMax(10, 20f));
	}
	
}

class Abc
{
	
	public int getMax(int i,int j)
	{
		if (i>j) {
			return i;
		} else {
			return j;
		}
	}
	
	//overload 方法重载
	//可以定义同名的，参数类型的不同的方法
	//可以认为是同一种功能的多种实现方式
	//同一个功能：getMax 取得两者中的最大数
	//不同实现：一个是整数，一个是浮点数
	public float getMax(float i,float j)
	{
		if (i>j) {
			return i;
		} else {
			return j;
		}
	}
	
	//参数换一个类型，方法重载也是可以的
	public float getMax(double i,float j)
	{
		if (i>j) {
			return (float)i;
		} else {
			return j;
		}
	}
	
	//与上一个相比，参数顺序发生了变化（或者两个参数的类型都变了）
	//也可以形成重载
	public float getMax(float i,double j)
	{
		if (i>j) {
			return i;
		} else {
			return (float)j;
		}
	}
	
	//如果只是方法的返回类型不一样，能否形成重载？
	//会报错，duplicated
	//仅仅方法的返回类型不同，不可形成重载
	/*
	public double getMax(float i,float j)
	{
		if (i>j) {
			return i;
		} else {
			return j;
		}
	}
	*/
	
	//如果只是访问修饰符不一样，能否形成重载？
	//也不行 Duplicated
	/*
	protected float getMax(float i,float j)
	{
		if (i>j) {
			return i;
		} else {
			return j;
		}
	}
	*/
}
