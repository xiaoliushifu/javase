public class Demo3_1
{
	public static void main(String []args)
	{
		/*Dog dog1=new Dog(2,"���");
		Person p1=new Person(dog1,23,"���¸�");
		p1.showInfo();
		p1.dog.showInfo();
		Person p2=new Person(dog1,24,"��ǫ");
		p2.showInfo();*/

		Dog d1=new Dog(2,"AA");
		d1.joinGame();

		Dog d2=new Dog(3,"BB");
		d2.joinGame();

		//d1.total����d2.total����Dog.total������������
		System.out.println("��"+Dog.total+"��");
	}
}

class Person
{
	int age;
	String name;
	Dog dog;  //��������

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
		System.out.println("������"+this.name);
	}
}

class Dog
{
	int age;
	String name;
	//���Ա����
	static int total;//��̬����
	public Dog(int age,String name)
	{
		this.age=age;
		this.name=name;
	}

	public void showInfo()
	{
		System.out.println("������"+this.name);
	}

	public void joinGame()
	{
		//��̬��Ա����
		total++;
		System.out.println("��һ��С������");
	}
}