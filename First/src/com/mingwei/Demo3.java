/**
 * 功能：方法的覆盖有哪些注意的地方
 * 方法覆盖发生在具有继承关系的父子类两者中的子类
 * 子类定义了和父类同名的方法：该方法的返回类型，方法名称，参数要和父类完全一样。
 * 仅仅是方法体不同而已。
 * 还有，子类覆盖父类的方法，不能缩小父类方法的访问权限(can't reduce visibility)
 * 言外之意，子类可以增大父类方法的访问权限：比如父类是protected,子类覆盖时可以是public的
 */
package com.mingwei;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat c1=new Cat();
		c1.cry();
		Dog d1=new Dog();
		d1.cry();
	}

}

class Animal
{
	int age;
	String name;
	//都会叫唤
	protected void cry()
	{
		System.out.println("我是动物，不知道怎么叫唤");
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
}

//狗类
class Dog extends Animal
{
	//覆盖父类的方法，方法覆盖 overide
	public void cry()
	{
		System.out.println("wang wang");
	}
}
