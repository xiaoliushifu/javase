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
