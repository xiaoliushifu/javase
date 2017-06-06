
public class Demo4

{
	public static void main(String []args)
	{
		//思路
		//第一只猫
		/*int cat1Age=3;
		String cat1Name="小白";
		String cat1Color="白色";

		int cat2Age=100;
		String cat2Name="小花";
		String cat2Color="花色";*/

		/*Cat cat1 = new Cat();
		/*cat1.age=3;
		cat1.name="小白";
		cat1.color="白色";

		Cat cat2;
		cat2=cat1;
		System.out.println(cat2.age);*/
		/*
		cat1.speak();
		cat1.jiSuan();
		cat1.jiSuan(100);

		cat1.add(20,30);

		int ret = cat1.add2(10,20);
		System.out.println(ret);*/

		Cat a = new Cat(1,"Hello");
		//不能重复定义a
		//int a = new Cat(3);

		int b = new Cat(3);


	}
}

class Cat
{
	int age;
	String name;
	String color;

	//构造方法
	//方法名和类名相同
	//没有返回值
	//new 时自动调用
	//每个类都有默认的构造方法
	
	//一个类可以定义多个构造方法
	//构造方法2
	public  Cat(int age)
	{
		System.out.println("我是2");
		age=age;
		//构造方法只能是void,默认就是void。返回类型写成int后，编译不通过会报错：找不到符号
//		return 3;
	}
	
	//构造方法1
	public Cat(int age,String name)
	{
				System.out.println("我是1");
		this.age=age;
	}

	//如果你不写构造方法，系统默认会创建一个没有实现的构造方法比如
	/* 默认构造方法：
	public Cat()
	{}
	*/

	//行为,java的方法，没有function关键字
	public void speak()
	{
		System.out.println("我是一个好人");
	}

	public void jiSuan()
	{
		int result=0;
		for(int i=0;i<=1000;i++) {
			result+=i;
		}
		//输出结果
		System.out.println("结果是"+result);
	}

	//java可以有同名的方法
	public void jiSuan(int n)
	{
		int result=0;
		for(int i=0;i<=n;i++) {
			result+=i;
		}
		System.out.println(result);
	}


	public void add(int num1,int num2)
	{
		int res = 0;
		res= num1+num2;
		System.out.println(res);
		
	}

	//计算两个数的和，且把结果返回给调用它的函数
	public int add2(int num1,int num2)
	{
		return num1+num2;
	}
}