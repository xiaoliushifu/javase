

public class Demo2
{
	public static void main(String arg[])
	{
		char c='a';

		switch(c)
		{
			case 'a':
				System.out.println("��������һ�����Ӵ�����"); //ע�⣬�������˫���ţ������Żᱨ��Ӵ
				int a=1; int b=4;
				int d=a+b;
				System.out.println(d);
				break;//����switch
			case 'b':
				System.out.println("�������ڶ������ӵ�С��");
				break;
			case 'c':
				System.out.println("������������������ѩɽ");
				break;
			default:
				System.out.println("��֪����");
		}
	}
}