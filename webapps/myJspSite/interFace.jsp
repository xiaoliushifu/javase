<!-- ����һ��JSPʵ�ֵļ�����Сʵ�� -->
<%@ page contentType="text/html;charset=gb2312" %>
<html>
	<head>
<script type="text/javascript">
function check(){
	//��֤��
	if (form1.num1.value=='') {
		window.alert("num1����Ϊ��");
		return false;
	}
	//��֤������
	
	//���������֣�������С����
	//if(isNaN(form1.num1.value)){
	
	//����������
	if(Math.round(form1.num1.value) != form1.num1.value){
		window.alert("num1����������");
		return false;
	}
}
</script>
</head>
	<body>
		<h3>�򵥵��������������</h3>
		<hr/>
		<form  name="form1" action="interFace.jsp">
		<label>��һ��������</label><input type="text" name="num1" /><br>
		<select name="opt">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select><br>
		<label>�ڶ���������</label><input type="text" name="num2" /><br>
		<!-- onclick�е�return���ǰ�check()�����ķ��أ��ٴη��ص�dom�ﾳ��-->
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>
<%
	//�ж���û�в������ݹ���
	String s_num1 = request.getParameter("num1");
	//����ʹ��null�жϣ���Ϊs_num1�п����ǿ�ָ��
	if(s_num1 != null) {
		//���յ�һ������
		//String s_num1 = request.getParameter("num1");
		//���յڶ�������
		String s_num2 = request.getParameter("num2");
		
		//ת������ String====>int
		int num1 = Integer.parseInt(s_num1);
		int num2 = Integer.parseInt(s_num2);
		//��ʼ���������
		int result =0;
		//���ղ�������
		String opt = request.getParameter("opt");
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
		out.println("<h3>������Ϊ"+result+"</h3>");
	}
%>
	</body>
</html>