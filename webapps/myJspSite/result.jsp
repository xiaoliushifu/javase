<!-- ���ǽ���ҳ���ύ�����ݣ����㲢��ʾ��� -->
<%@ page contentType="text/html;charset=gb2312" %>
<html>
<body>
<h2>��������
	
<% 
	//���յ�һ������
	String s_num1 = request.getParameter("num1");
	//���յڶ�������
	String s_num2 = request.getParameter("num2");
	
	//ת������ String====>int
	int num1 = Integer.parseInt(s_num1);
	int num2 = Integer.parseInt(s_num2);
	//��ʼ���������
	int result =0;
	//���ղ�������
	String opt = request.getParameter("opt");
	/*switch(opt) {
		case:"+"
			result = num1 + num2;
			break;
		case:"-"
			result = num1 - num2;
			break;
		case:"*"
			result = num1 * num2;
			break;
		case:"/"
			result = num1 / num2;
	}
	*/
	if(opt.equals("+")){
		result = num1 + num2;
	}else if(opt.equals("-")){
		result = num1 - num2;
	}else if(opt.equals("*")){
		result = num1 * num2;
	}else{
		result = num1 / num2;
	}
	//���㲢������	
	out.println(result);
%>
</h2>
</body>
</html>