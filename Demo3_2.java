public class Demo3_2
{
	//������̬�����
	static int i=1;

	//�þ�̬����飬ֻ��ִ��һ��,����ִ��
	//���췽��֮ǰִ�С� 
	//��static��ʱ��ִ���أ��ǲ�����Ϊ��һ��new�����ִ���������Ĵ����أ�
	//���ǵġ����ŵĻ������ǰ�main������Ϊ�գ�
	//static����Ȼ��ִ�С�
	//һ�仰��static�����ִ�У�����Ϊ���౻װ�ص�ջ�ڴ�ʱ���ͻ�ִ�С�

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

	//����һ��ѧ��
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
	
	//������ѧ�ѣ�ʹ���෽������̬����)
	//java�У����������̬������ԭ�������෽������̬������ȥ����

	public static int getTotalFee()
	{
			//��̬�����У����ܷ��ʷǾ�̬����������Ϊ�Ǿ�̬�������Ƕ�������������ж���
			//����̬��������Ҫ�ж���Ϳ������������ʡ���ôһ��ʹ���������ʾ�̬�������Ǿ��п�����û�ж���ʵ��
			//��ǰ���·���age����Ǿ�̬�����ˣ�age����û�������Ķ�������ô���£��ǰɣ�
			//������ʾ�У�
			/*
			Demo3_2.java:67: �޷��Ӿ�̬�����������÷Ǿ�̬ ���� age
                        age++;
			*/
			//age++;
		return totalFee;
	}
}
/*
	����static�ؼ��ֵľ�����������߾�̬����
	���������Ҫ����Ϳɷ���
	ʵ����������Ҫʵ����������ܷ���

	�෽�������࣬ÿ��ʵ������
	ʵ����������ÿ������ĸ���
*/