public class Test
{
	public static void main(String args[])
	{
//		int a=3;
//		int b=4;

		//���������ñ��ǰ��˼���һ��
		InputStreamReader isr =new InputStreamReader(System.in);

		//������������������ȡ����������Ҫ�ȷŵ�������
		BufferedReader     br = new BufferedReader(isr);

		//������ʾ
		System.out.println("������һ������");
		//����һ������
		String a1 = br.readLine();

		System.out.println("�������������");
		String a2 = br.readLine();

		//��������ֶ����ַ�������Ҫǿ��ת����float����  String-->Float
		float a = Float.parseFloat(a1);
		float b = Float.parseFloat(a2);

		if (a==b) {
			System.out.println("���");
		} else if (a>b) {
			System.out.println("a����b");
		} else {
			System.out.println("aС��b");
		}
	}
}