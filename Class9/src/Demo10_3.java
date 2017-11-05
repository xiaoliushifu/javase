/**
 * 长时间不写java代码，今天复习一下
 * 继续复习java线程知识
 * 一个Pig类，一个Bird类，各自忙自己的事情。
 * 一个做数学加法计算，一个是输出hello。好像是一个流程顺序下来的.
 * 这是简单的复习，到此为止，这两个线程都是由main函数这个主线程创建的。对，没错，main函数就是一个线程
 * 它能创建线程，它创建的线程称之为子线程，那么它本身就可以称之为主线程。
 * 因为Pig线程和bird线程并没有涉及共享资源的争夺，故看不出并发的明显效果。
 * 后续我们还会涉及共享资源，这时就看到并发的明显效果了。
 * @author Administrator
 *
 */
public class Demo10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig p1 = new Pig(10);
		Bird b1 = new Bird(8);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(b1);
		
		t2.start();
		t1.start();

	}

}

class Pig implements Runnable
{
	int n=0;
	int times=0;
	public Pig(int n)
	{
		this.n = n;
	}
	public void run()
	{
		while(true) {
			try {
				Thread.sleep(2300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("我是猪线程，正在输出第"+this.times+"个 Hello");
			if(times == n) {
				break;
			}
		}
	}
}
class Bird implements Runnable
{
	int n=0;
	int times=0;
	int sum = 0;
	public Bird(int n)
	{
		this.n = n;
	}
	public void run()
	{
		while(true) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum = (++times);
			System.out.println("我是鸟线程，正在计算，目前结果是"+sum);
			if(times == n) {
				break;
			}
		}
	}
}
