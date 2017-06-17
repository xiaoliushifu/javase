/**
 * 抽象类
 */
package com.test2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal an=new Animal();
	}

}

/**抽象需用关键字abstract
 * 抽象方法必须属于抽象类
 * 反过来抽象类未必有抽象方法
 * 抽象类不能实例化
 * @author Administrator
 *
 */
abstract class Animal
{
	String name;
	int age;
	//动物会叫
//	abstract public void cry();
}

/**
 * 一个类继承的父类是抽象类的话
 * 需用该类把抽象类中所有的抽象方法全部实现
 * @author Administrator
 *
 */
class Cat extends Animal
{
	public void cry()
	{
		
	}
}