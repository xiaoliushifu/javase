

//����ĳЩ��
import java.io.*;
public class Demo2
{
	public static void main(String arg[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		switch(a)
		{
			//���벻ͨ��������ԭ����Ҫ���ͣ��ҵ������͡�
			//switch���a�����ͣ���case����߼����ʽ������ǲ����͡����Ͳ�һ�¡�
			  //Ҳ����˵��switch������������ͣ�Ҫ��case �����������һ�²ſ��ԡ�
			case a<=100 && a>=90:

				System.out.println("����");
				break;
			case a<=89 && a>=80:
				System.out.println("����");
				break;
			case a<=79 && a>=60:
				System.out.println("����");
				break;
			default:
				System.out.println("���а������ӣ�ҪŬ��ѽ��");
		}
	}
}