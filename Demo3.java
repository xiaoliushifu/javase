public class Demo3
{
	public static void main(String arg[]) throws Exception
	{
		//��ȥ������--���Ĳ�
		int lay=4;
		for(int i=1;i<=lay;i++) {

			//�ȴ�ո�
			//1--3  2--2   3--1   4--0
			for(int m=1;m<=lay-i;m++){
				System.out.print(" ");
			}

			//ÿһ�������ٸ�*��
			//��һ�д�ӡ1��*;
			//�ڶ��д�ӡ3��*;
			// 3---5    4---7
			for(int j=1;j<=2*i-1;j++){
				System.out.print("*");
			}
			//���һ������
			System.out.println();
			
		}
	}
}