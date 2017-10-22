/**
 * 多线程的实现
 * 线程的概念也很重要，这里就不说了
 * 在java中实现多线程有两种方法：
 * 继承Thread类 该类是java.lang.Thread无需引入包，就在常用包中，然后重新run()方法即可。
 * 实现runnable接口，然后重写run()方法即可。
 * 从jdk上来看，其实Thread类也实现了runnable接口。
 * 故本质上，他俩都是runnable接口在发挥作用。
 * 常用来说，还是使用runnable接口比较好，因为它还给当前类留有继承的机会。
 * @author Administrator
 *
 */
public class Demo10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c=new Cat(10,"花花");
		Cat d=new Cat(10,"瓜瓜");
		
		//Thread类，是调用start()方法开始的。固定的套路
		c.start();
		d.start();
	}

}

//一个类实现多线程的方式
class Cat extends Thread
{
	int times=0;
	int n=0;
	String name=null;
	/**
	 * 构造函数.没有void
	 * @param n
	 */
	public Cat(int n,String name)
	{
		this.n=n;
		this.name=name;
	}
	/**
	 * 必须重新run方法才行
	 * 该方法是每个线程对象（类）运行的方法
	 */
	public void run()
	{
		while(true)
		{
			try {
				//线程阻塞，单位毫秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("hello,"+this.name+" "+times);
			if(times==n){
				break;
			}
		}
	}
}