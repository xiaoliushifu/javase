/**
 * java中的集合类
 * ArrayList,Map,Set,Queue四大类必须学会。
 * 今天先看ArrayList
 * List结构的集合类
 * 		ArrayList,LinkedList,Vector,Stack
 * Set结构的集合类
 * 	
 * Map结构的集合类
 * 		hashMap,hashtable
 * 
 */
package com.jihe;

//所有的集合类都在这个包中
import java.util.*;
public class Forlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//声明一个ArrayList对象，集合类的对象。这个集合类里只能放Object类型的对象，但java中的所有类都是Object类的子类，所以
		//ArrayList可以放任何对象。
		ArrayList al = new ArrayList();
		//先来看看它的大小
		System.out.println("al大小是:"+al.size());
		//声明一个员工
		Clerk clerk1 = new Clerk("唐僧",30,1000);
		Clerk clerk2 = new Clerk("悟空",15,1800);
		Clerk clerk3 = new Clerk("八戒",18,1500);
		Clerk clerk4 = new Clerk("沙僧",18,1500);
		//把它加入到集合类中,注意ArrayList只能放Object类型的对象。
		al.add(clerk1);
		al.add(clerk2);
		al.add(clerk3);
		al.add(clerk4);
		al.add(clerk1);//放了两个唐僧，是可以的。就是多了一个引用而已呗
		//添加一个员工之后，我们再打印一下：
		System.out.println("al大小是:"+al.size());
		
		//打印第一个员工的信息
		Clerk temp = (Clerk)al.get(0);
		System.out.println("第一个人的名字是："+temp.getName());
		
		//遍历输出al中的元素
		for(int i=0;i<al.size();i++) {
			Clerk t = (Clerk)al.get(i);
			System.out.println("第"+(i+1)+"个"+t.getName());
		}
		System.out.println("==========删除八戒之后===========");
		al.remove(2);
		//遍历输出al中的元素
		for(int i=0;i<al.size();i++) {
			Clerk t = (Clerk)al.get(i);
			System.out.println("第"+(i+1)+"个"+t.getName());
		}
	}

}

class Clerk
{
	private String name;
	private int    age;
	private float  salary;
	
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

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Clerk(String name,int age,float salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
}
