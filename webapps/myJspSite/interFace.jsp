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
		
<%
	//��������
	int result,num1,num2;
	//��ʼ������
	result=num1=num2=0;
	
	String s_num1 = request.getParameter("num1");
	String s_num2 = request.getParameter("num2");
	String opt = request.getParameter("opt");
	
	String add,min,pow,div;
	add=min=pow=div="";
	//�ж���û�в������ݹ���ʱ����ʹ��null�жϣ���Ϊs_num1�п����ǿ�ָ��
	if(s_num1 != null) {
		
		//ת������ String====>int
		num1 = Integer.parseInt(s_num1);
		num2 = Integer.parseInt(s_num2);
		
		if(opt.equals("+")){
			result = num1 + num2;
			add="selected";
		}else if(opt.equals("-")){
			result = num1 - num2;
			min="selected";
		}else if(opt.equals("*")){
			result = num1 * num2;
			pow="selected";
		}else{
			result = num1 / num2;
			div="selected";
		}
	}
%>
<h3>�򵥵��������������</h3>
		<hr/>
		<!-- formԪ�ر���action����Ϊ�գ���Ĭ���ύ����ǰ��url -->
		<form  name="form1" action="">
		<label>��һ��������</label><input type="text" size=10 name="num1" value="<%= num1%>"/><br>
		<select name="opt">
			<option value="+" <%=add %> >+</option>
			<option value="-" <%=min %> >-</option>
			<option value="*" <%=pow %> >*</option>
			<option value="/" <%=div %> >/</option>
		</select><br>
		<label>�ڶ���������</label><input type="text" size=10 name="num2" value="<%= num2%>" /><br>
		<!-- onclick�е�return���ǰ�check()�����ķ��أ��ٴη��ص�dom�ﾳ��-->
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>



	<h3>������Ϊ<%= result %></h3>
	</body>
</html>