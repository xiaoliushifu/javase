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
		<form  name="form1" action="interFace.jsp">
		<label>第一个操作数</label><input type="text" name="num1" /><br>
		<select name="opt">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select><br>
		<label>第二个操作数</label><input type="text" name="num2" /><br>
		<!-- onclick中的return，是把check()函数的返回，再次返回到dom语境中-->
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>
<%
	//判断有没有参数传递过来
	String s_num1 = request.getParameter("num1");
	//必须使用null判断，因为s_num1有可能是空指针
	if(s_num1 != null) {
		//接收第一个参数
		//String s_num1 = request.getParameter("num1");
		//接收第二个参数
		String s_num2 = request.getParameter("num2");
		
		//转换类型 String====>int
		int num1 = Integer.parseInt(s_num1);
		int num2 = Integer.parseInt(s_num2);
		//初始化结果对象
		int result =0;
		//接收操作符号
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
		//计算并输出结果	
		out.println("<h3>计算结果为"+result+"</h3>");
	}
%>
	</body>
</html>