/**
 * 功能：说明继承的必要性
 * java中的继承，和php一样也是单继承，目前只见到C++是多继承
 * 越底层的类，因为其父类，爷爷类，祖先类的继承关系，底层类的功能是非常丰富的
 * jdk6 中有202个包，有3777个类，接口，异常，枚举、注释和错误
 * 多查google
 */
package com.mingwei;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1=new Pupil();
		

	}

}

//将学生的共有属性提出，定义一个父类
class Student
{
	//定义成员属性
	public int age;
	public String name;
	public float fee;
	int height;
	private String job;
	//除了父类的private成员，其他public,protected,默认,子类都会继承这三种成员
	
	public void printName()
	{
		System.out.println("名字"+this.name);
		
	}
}


//小学生类,继承 Student类
class Pupil extends Student
{
	//交学费
	public void pay(float fee)
	{
		this.fee=fee;
	}
}

//中学生类，继承学生类
class MiddleStu extends Student
{
	//交学费
	public void pay(float fee)
	{
		
		this.fee=fee*0.8f;;
	}
}

//大学生类，也继承学生类
class ColStu extends Student
{
	//交学费
	public void pay(float fee)
	{
		this.fee=fee*0.2f;
	}
}