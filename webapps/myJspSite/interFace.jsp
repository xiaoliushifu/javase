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
		<form  name="form1" action="result.jsp">
		<label>��һ��������</label><input type="text" name="num1" /><br>
		<select name="opt">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select><br>
		<label>�ڶ���������</label><input type="text" name="num2" /><br>
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>
	</body>
</html>