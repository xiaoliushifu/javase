public class Demo3
{
	public static void main(String arg[]) throws Exception
	{
		int lay=10;
		for(int i=1;i<=lay;i++) {

			//�ȴ�ո�
			//1--3  2--2   3--1   4--0
			for(int m=1;m<=lay-i;m++){
				System.out.print(" ");
			}

			for(int j=1;j<=2*i-1;j++){

				//��һ������һ��ȫ����*��
				if(i==1 || i==lay) {
					System.out.print("*");
				//�м�㣬ֻ���һ�������һ��*��
				} else if(j==1 || j==2*i-1) {
					System.out.print("*");
				//�����Ĵ�ո�
				} else {
					System.out.print(" ");
				}
				
			}
			//���һ������
			System.out.println();
			
		}
	}
}
/*
	�м��οյĽ���������ô���أ�
          *
		 * *
		*   *
	   *******
	   ���ǹ۲죬�������Ķ����������ģ��������ĵ׶�Ҳ�������ġ�
	   ���м�Ķ����οյģ����ԣ�����Ӧ���ڴ�ӡ*�ŵ��Ǹ�forѭ����������
*/