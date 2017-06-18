/**
 * 功能：final
 * 修饰方法时，表示该方法不能被覆盖 
 * 修饰类时，表示该类不可被继承
 * 修饰变量时，子类继承时不能修改，但是子类仍然可以声明和定义属于自己的成员变量，甚至和父类的final变量同名都没有问题。
 * 如果你觉得某个方法或者某个类已经写得非常完美了，没有再修改的余地了
 */
package com.mingwei;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbb b=new Bbb();
		System.out.println(b.rate);
		b.rate=3.55f;
		System.out.println(b.rate);
	}

}

class Aaa
{
	int a=0; //如果不给初值，a=0;这不是好习惯，可能会有的空指针
	//final修饰的变量也不能被修改吗？
	//这里的final修饰成员变量，不影响继承。子类完全可以定义自己与父类同名的成员变量，随意赋值不受其影响。
	final float rate=3.1415926f;
	//final修饰的方法 对继承有影响，子类不可覆盖该方法
	public void sendMes()
	{
		
		System.out.println("发送消息");
	}
}
class Bbb extends Aaa
{
	//这里竟然可以初始化，父类Aaa的final怎么解释呢？
	//final 修饰成员变量时，对继承没有影响
	float rate=4;
	public void sendMes()
	{
		
	}
}
