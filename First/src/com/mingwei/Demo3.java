/**
 * 功能：多态 
 * 一个类型在不同情况下的多种状态
 * 比如示例中的Animal类型
 */
package com.mingwei;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		Cat c1=new Cat();
		c1.cry();
		Dog d1=new Dog();
		d1.cry();
		*/
		
		/*
		//Animal是Cat的父类
		Animal an=new Cat();
		//此时an是cat类
		an.cry();
		an=new Dog();
		//此时an又变成了Dog类
		an.cry();
		*/
		//用最高级的父类声明an,这样它的子类都可以赋值给它，也就是说，an是个活指针，把Dog交给an，an就可以执行Dog的方法；把Cat给
		//an,那么an就能执行Cat的方法。an不变，但是它的指向在改变。
		
		//问题：反过来可不可行呢？如下：
		/*
		 * Cat c1=new Animal();
		 * 上述在什么条件下可以呢？
		 * */
		
		Master m=new Master();
		m.feed(new Dog(),new Bone());
		
	}

}

class Animal
{
	int age;
	String name;
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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
	//都会叫唤
	protected void cry()
	{
		System.out.println("我是动物，不知道怎么叫唤");
	}
	
	protected void eat()
	{
		System.out.println("不知道吃什么");;
	}
}

//猫类
class Cat extends Animal
{
	//覆盖父类的方法，方法覆盖 overide
	public void cry()
	{
		System.out.println("miao miao");
	}
	
	public void eat()
	{
		System.out.println("吃鱼");
	}
}

//狗类
class Dog extends Animal
{
	//覆盖父类的方法，方法覆盖 overide
	public void cry()
	{
		System.out.println("wang wang");
	}
	
	public void eat()
	{
		System.out.println("吃骨头");
	}
}

class Master
{
	//喂食物
	public void feed(Animal a,Food f)
	{
		a.eat();
		f.showName();
	}
}

class Food
{
	String name;
	public void showName()
	{
		
	}
}

class Fish extends Food
{
	public void showName()
	{
		System.out.println("鱼");
	}
}

class Bone extends Food
{
	public void showName()
	{
		System.out.println("骨头");
	}
}
