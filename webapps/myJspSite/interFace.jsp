<!-- 这是一个JSP实现的计算器小实例 -->
<%@ page contentType="text/html;charset=gb2312" %>
<html>
	<head>
<script type="text/javascript">
function check(){
	//验证空
	if (form1.num1.value=='') {
		window.alert("num1不能为空");
		return false;
	}
	//验证非数字
	
	//必须是数字（可以是小数）
	//if(isNaN(form1.num1.value)){
	
	//必须是整数
	if(Math.round(form1.num1.value) != form1.num1.value){
		window.alert("num1必须是整数");
		return false;
	}
}
</script>
</head>
	<body>
		<h3>简单的四则运算计算器</h3>
		<hr/>
		<form  name="form1" action="result.jsp">
		<label>第一个操作数</label><input type="text" name="num1" /><br>
		<select name="opt">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select><br>
		<label>第二个操作数</label><input type="text" name="num2" /><br>
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>
	</body>
</html>