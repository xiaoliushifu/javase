/**
 * 功能：说明继承的必要性
 */
package com.mingwei;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//小学生类
class Pupil
{
	//定义成员属性
	private int age;
	private String name;
	private float fee;
	
	//交学费
	public void pay(float fee)
	{
		
		this.fee=fee;
	}
}

//中学生类
class MiddleStu
{
	//定义成员属性
		private int age;
		private String name;
		private float fee;
		
		//交学费
		public void pay(float fee)
		{
			
			this.fee=fee*0.8f;;
		}
}

class ColStu
{
	//定义成员属性
		private int age;
		private String name;
		private float fee;
		
		//交学费
		public void pay(float fee)
		{
			
			this.fee=fee*0.2f;
		}
}