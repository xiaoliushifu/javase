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

	/*static
	{
		System.out.println("static");
		i++;
	}*/


	/*public Demo3_2()
	{
		System.out.println("new");
		i++;
	}*/
	public static void main(String arg[])
	{
		
	/*	Demo3_2 t1=new Demo3_2();
		System.out.println(t1.i);

		Demo3_2 t2=new Demo3_2();
		System.out.println(t2.i);
	*/

	//创建一个学生
	Stu stu1 = new Stu(29,"aa",340);

	Stu stu2 = new Stu(38,"bb",240);
	System.out.println(stu1.getTotalFee());

	}
}

class Stu
{
	int age;
	String name;
	int fee;
	static int totalFee;

	public Stu(int age,String name,int fee)
	{
		this.age=age;
		this.name=name;
		totalFee+=fee;
	}
	
	//返回总学费，使用类方法（静态方法)
	//java中，类变量（静态变量）原则上用类方法（静态方法）去访问

	public static int getTotalFee()
	{
			//静态方法中，不能访问非静态变量。是因为非静态变量就是对象变量，必须有对象。
			//而静态方法不需要有对象就可以用类来访问。那么一旦使用类来访问静态方法，那就有可能在没有对象实例
			//的前提下访问age这个非静态变量了，age属性没有所属的对象算怎么回事，是吧？
			//报错提示有：
			/*
			Demo3_2.java:67: 无法从静态上下文中引用非静态 变量 age
                        age++;
			*/
			//age++;
		return totalFee;
	}
}
/*
	加上static关键字的就是类变量或者静态变量
	类变量不需要对象就可访问
	实例变量，需要实例化对象才能访问

	类方法属于类，每个实例共享
	实例方法属于每个对象的个体
*/