/**
 * 定义一个泛型类Gen<T>
 * 具体这个类到底是哪个已存在的java数据类型待定，而是在new的时候才知道。
 * 例子中，实例化String,实例化Integer,Bird数据类型等都可以。这就是泛型的好处，提供代码重用率，
 * 无需单独定义String,Integer,Bird这些类
 * 
 * 泛型优点
 * 	①类型安全
 * 	②向后兼备
 *  ③层次清晰
 *  ④性能较高 Generation Java(泛型java,GJ)在编译阶段能够识别类型，为编译器和java虚拟机提供更多的类型信息，对java程序的优化提供条件
 */
package com.jihe;

import java.lang.reflect.Method;

public class FanXing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//存放String类型
		Gen<String> f1=new Gen<String>("laoli");
		f1.showTypeName();
		
		//可以存放Integer类型
		Gen<Integer> f2=new Gen<Integer>(34);
		f2.showTypeName();
		
		//可以存放自定义的Bird类型
		Gen<Bird> f3=new Gen<Bird>(new Bird());
		f3.showTypeName();
	}

}

class Bird
{
	public void name(){
		System.out.println("name是");
	}
}
//定义一个泛型
class Gen<T>
{
	private T o;
	//今天才注意到构造函数不能加返回类型，虽然本质上是void，但也并不能加void，否则编译器不认为是构造函数。
	public Gen(T o) {
		this.o=o;
	}
	
	public void showTypeName()
	{
		System.out.println("类型是:"+o.getClass().getName());
		//通过反射机制，可以获得某个类的详细信息
		Method []m=o.getClass().getDeclaredMethods();
		//打印
		for(int i=0;i<m.length;i++) {
			System.out.println(m[i].getName());
		}
	}
}