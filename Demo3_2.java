public class Demo3_2
{
	//创建静态类变量
	static int i=1;

	//该静态区域块，只会执行一次,且在执行
	//构造方法之前执行。 
	//该static何时被执行呢？是不是因为第一次new对象而执行这个区域的代码呢？
	//不是的。不信的话，我们把main函数置为空，
	//static区仍然会执行。
	//一句话，static区域会执行，是因为该类被装载到栈内存时，就会执行。

	static
	{
		System.out.println("static");
		i++;
	}


	public Demo3_2()
	{
				System.out.println("new");
		i++;
	}
	public static void main(String arg[])
	{
		
	/*	Demo3_2 t1=new Demo3_2();
		System.out.println(t1.i);

		Demo3_2 t2=new Demo3_2();
		System.out.println(t2.i);
	*/

	}
}
