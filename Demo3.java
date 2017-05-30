public class Demo3
{
	public static void main(String arg[]) throws Exception
	{
		//死去火来发--打四层
		int lay=4;
		for(int i=1;i<=lay;i++) {

			//先打空格
			//1--3  2--2   3--1   4--0
			for(int m=1;m<=lay-i;m++){
				System.out.print(" ");
			}

			//每一层里打多少个*号
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//打出一个换行
			System.out.println();
			
		}
	}
}