/**
 * 泛型：
 * 	泛型由java 1.5引入。泛型的本质是参数化类型，就是说所操作的数据类型指定为一个参数，在类，接口，方法中指定泛型，则就有泛型类
 * 	泛型接口，泛型方法（目前的理解就是，事先为集合类指定其将来存放的java对象的数据类型，而不是默认的Object）
 * 
 * java中引入泛型的好处是简单安全
 * java 1.5之前，没有泛型的情况下，通过对Object类型的引用，来达到参数的"任意化"。但前面操作也看到了，需要使用强制类型转换，
 * 并且转换时，开发者得必须事先知道参数类型才可以。如果强制转换错误，在编译阶段发现不了，而是在运行时才会报异常。这就是安全隐患
 * 
 * 泛型是在编译阶段就能坚持类型，存取数据时的强制类型转换都是自动和隐式的，提高效率和安全,代码重用率。
 * 	
 */
package com.jihe;

import java.util.*;
public class FanXing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		//虽然其他文件里有定义Dog类，但并不是public的，即使把那个包引过来也不能使用，故这里只能重新定义Dog类
		Dog dog1=new Dog();
		al.add(dog1);
		
		//取出狗
		Dog temp = (Dog) al.get(0);
		//第二名开发者认为是猫，强制转换。编译器不报错，但运行时报异常!
		Cat temp2=(Cat)al.get(0);
	}

}

class Cat
{
	private String name;
	private int age;
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
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
//定义一个狗类
class Dog
{
	private String name;
	private float weight;
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
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}