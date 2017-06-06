public class Demo3_1
{
	public static void main(String []args)
	{
		Dog dog1=new Dog(2,"大黄");
		Person p1=new Person(dog1,23,"郭德纲");
		p1.showInfo();
		p1.dog.showInfo();
		Person p2=new Person(dog1,24,"刘谦");
		p2.showInfo();
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
	public Dog(int age,String name)
	{
		this.age=age;
		this.name=name;
	}

	public void showInfo()
	{
		System.out.println("狗名是"+this.name);
	}
}