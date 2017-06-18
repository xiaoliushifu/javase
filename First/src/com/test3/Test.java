/**
 * 接口
 * 接口不能被实例化
 * 接口里的方法全部是抽象方法，一个方法都不能实现（言外之意，应该有子类来实现）
 * 接口体现了程序设计的 多态 和 高内聚低耦合的设计思想
 * 
 */
package com.test3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//接口中定义的变量，可以直接使用
		System.out.println(Cha.a);
		Computer c=new Computer();
		Camera camera=new Camera();
		Phone phone=new Phone();
		c.useUsb(camera);
		c.useUsb(phone);

	}

}

/**
 * 接口使用关键字 interface
 * 只声明两个方法
 * @author Administrator
 *
 */
interface Usb
{
	public void start();
	public void stop();
}

class Single
{
	
}
/**
 * 又定义一个接口
 * 接口中可以有变量【但不能用private,protected修饰】
 * 接口中的变量，基本都是static的,且必须初始化
 * 
 * 接口类不能继承其他类，但它可以继承其他的接口
 * 
 * @author Administrator
 *
 */

interface Cha
{
	//加不加static关键字，都是static的
	int a=1;
}
/**实现关键字implements
 * 照相机类实现了Usb接口类
 * 子类实现某个接口类，则要求子类把接口类中所有的方法通通实现
 * 一个类可以实现多个接口
 * @author Administrator
 *
 */
class Camera implements Usb,Cha
{
	//此即为实现接口Usb的抽象方法stop
	public void stop()
	{
		System.out.println("相机停止工作");
	}
	//此即为实现接口Usb的抽象方法start
	public void start()
	{
		System.out.println("相机开始工作");
	}
}

/**
 * Phone类也实现了Usb接口类
 * @author Administrator
 *
 */
class Phone implements Usb
{
	public void stop()
	{
		System.out.println("手机停止工作");
	}
	public void start()
	{
		System.out.println("手机开始工作");
	}
}


/**
 * 上面有接口类 也有实现接口的子类 它们都是model
 * 下面写一个类Computer，是使用者类,在main中开始调用 
 * @author Administrator
 *
 */
class Computer
{
	//定义一个方法，以多态的形式定义，即使用大类，大接口。
	//Usb接口类型约束usb变量 Usb接口就是打接口
	
	public void useUsb(Usb usb)
	{
		usb.start();
		usb.stop();
		
	}
}