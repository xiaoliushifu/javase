
public class Demo4

{
	public static void main(String []args)
	{
		//˼·
		//��һֻè
		/*int cat1Age=3;
		String cat1Name="С��";
		String cat1Color="��ɫ";

		int cat2Age=100;
		String cat2Name="С��";
		String cat2Color="��ɫ";*/

		/*Cat cat1 = new Cat();
		/*cat1.age=3;
		cat1.name="С��";
		cat1.color="��ɫ";

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
		//�����ظ�����a
		//int a = new Cat(3);

		int b = new Cat(3);


	}
}

class Cat
{
	int age;
	String name;
	String color;

	//���췽��
	//��������������ͬ
	//û�з���ֵ
	//new ʱ�Զ�����
	//ÿ���඼��Ĭ�ϵĹ��췽��
	
	//һ������Զ��������췽��
	//���췽��2
	public  Cat(int age)
	{
		System.out.println("����2");
		age=age;
		//���췽��ֻ����void,Ĭ�Ͼ���void����������д��int�󣬱��벻ͨ���ᱨ���Ҳ�������
//		return 3;
	}
	
	//���췽��1
	public Cat(int age,String name)
	{
				System.out.println("����1");
		this.age=age;
	}

	//����㲻д���췽����ϵͳĬ�ϻᴴ��һ��û��ʵ�ֵĹ��췽������
	/* Ĭ�Ϲ��췽����
	public Cat()
	{}
	*/

	//��Ϊ,java�ķ�����û��function�ؼ���
	public void speak()
	{
		System.out.println("����һ������");
	}

	public void jiSuan()
	{
		int result=0;
		for(int i=0;i<=1000;i++) {
			result+=i;
		}
		//������
		System.out.println("�����"+result);
	}

	//java������ͬ���ķ���
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

	//�����������ĺͣ��Ұѽ�����ظ��������ĺ���
	public int add2(int num1,int num2)
	{
		return num1+num2;
	}
}