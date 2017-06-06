public class Demo3_1
{
	public static void main(String []args)
	{
		/*Dog dog1=new Dog(2,"大黄");
		Person p1=new Person(dog1,23,"郭德纲");
		p1.showInfo();
		p1.dog.showInfo();
		Person p2=new Person(dog1,24,"刘谦");
		p2.showInfo();*/

		Dog d1=new Dog(2,"AA");
		d1.joinGame();

		Dog d2=new Dog(3,"BB");
		d2.joinGame();

		//d1.total或者d2.total或者Dog.total都能正常访问
		System.out.println("有"+Dog.total+"个");
	}
}

class Person
{
	int age;
	String name;
	Dog dog;  //引用类型

	public Person(int age)
	{
		this.age=age;
	}

	public Person(Dog dog,int age,String name)
	{
		this.age=age;
		this.name=name;
		this.dog=dog;
	}

	public void showInfo()
	{
		System.out.println("人名是"+this.name);
	}
}

class Dog
{
	int age;
	String name;
	//类成员变量
	static int total;//静态变量
	public Dog(int age,String name)
	{
		this.age=age;
		this.name=name;
	}

	public void showInfo()
	{
		System.out.println("狗名是"+this.name);
	}

	public void joinGame()
	{
		//静态成员变量
		total++;
		System.out.println("有一个小狗来了");
	}
}