/**
 * 线程安全问题
 * 一个线程只能启动一次，即只能start()一次，否则会报异常(非法线程状态异常）
 * 这个自己start()两次就知道了。
 * 下面使用三个售票窗口卖票的问题来说明另一个问题
 * 三个售票窗口各自卖票，总票数是2000张，是三个售票口共2000张，不是单独一个窗口2000张
 * （两种方式   1多个线程使用同一个窗口对象，即三个售票窗口就启动三个线程，但是都使用同一个窗口对象，
 * 2 三个线程各自使用一个窗口对象，但是，num属性得是静态的，这样才能实现资源共享）
 * @author Administrator
 * 一旦资源共享后，我们就发现了一个问题：
 * 三个售票窗口我们发现，这涉及到资源共享的问题，有可能线程1在读取了num之后，还未num--,此时线程2也读取了
 * num。此时就是所谓的两个窗口卖同一张票问题的根源。处理这种竞争资源的问题，就得使用锁机制，别无他法子。
 * java中锁机制的代码实现比较简单，只需把共享代码块用synchronized(Object){}包起来即可.
 * 这样，在线程1执行到该代码时，该代码就会锁住，线程2，线程3等其他线程再执行到这里时，看到该代码已经上锁
 * 于是，就等待（该线程自己退居到阻塞线程队列中排队去），其他线程看到有人排队，就依次再后续排队就是了。
 * 直到线程1执行完后，打开锁退出该代码块。然后线程2再进去执行，也上锁。
 * 这个就跟火车上排队上厕所一个道理
 * 
 * 所以，线程的安全问题，是自己编程导致的，并不是某个系统的问题。
 * 开发人员要考虑周全，避免死锁的存在，应该有处理锁机制的代码。否则就是错误的代码
 * 
 * java任意类型的对象，都一个标志位，有0,1两种状态，初始状态为1。
 * 当一个进程执行到使用synchronized(object){}里包含的代码时，object就会置为0，直到代码块执行
 * 完，此时的object标志位才重新为1。
 * 当一个进程B遇到synchronized(object)之后，就会先判断object的标志位，如果是0，表示该代码有
 * 其他进程A正在执行，它自己就退居阻塞队列中，让出cpu资源。
 * 直到原子代码（同步块里的代码）执行完后，进程A就把object的标志位为1，自己离开了；此时进程B再进去
 * 又把object的标志位置为0，告诉后续进程我进程B正在执行这段原子代码，你们先等着吧。
 */

public class Demo10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		TicketWindow tw = new TicketWindow();
		Thread t1 = new Thread(tw);
		t1.start();
		t1.start();//第二次再start()时，会报异常
		*/
		
		//第二种方式，启动两个线程，分别start(),但是它们都用同一个窗口对象tw
		//没有问题，这是可以的。因为毕竟是两个线程
		//也只有这种方式，使用同步机制synchronized才有效
		TicketWindow tw = new TicketWindow();
		Thread t2 = new Thread(tw);
		Thread t3 = new Thread(tw);
		t2.start();
		t3.start();
		
		//第三种方式，实例化三个窗口类
		//这种方式实例化了三个对象，故使用三个线程也没有问题，
		//但是它的num成员属性也是各自的，不能共享，故此时的num属性可以设置成静态属性
		//让三个卖票窗口对象共享该静态属性
		/*TicketWindow tw1 = new TicketWindow();
		TicketWindow tw2 = new TicketWindow();
		TicketWindow tw3 = new TicketWindow();
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw2);
		Thread t3 = new Thread(tw3);
		t1.start();
		t2.start();
		t3.start();
		//但要注意，这种方式由于是三个窗口对象，故虽然synchronized(this)，但是实际是锁住了
		 * 各自的代码而已。所以没有效果。必须使用多线程都使用一个对象的方式来使用synchronized()同步机制。
		*/
	}

}
/**
 * 售票窗口类
 * @author Administrator
 *
 */
class TicketWindow implements Runnable
{
	//由于是多窗口对象的方式，都操作这个num成员属性，故设置成静态，已让三个对象共享。
	private  int num = 2000;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this){
			if(num > 0) {
				//输出线程名字
				System.out.println(Thread.currentThread().getName()+"正在卖第"+num+"张票");
				num--;
			} else {
				break;
			}
			}
		}
	}
}
