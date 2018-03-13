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
		
<%
	//声明三个
	int result,num1,num2;
	//初始化三个
	result=num1=num2=0;
	
	String s_num1 = request.getParameter("num1");
	String s_num2 = request.getParameter("num2");
	String opt = request.getParameter("opt");
	
	String add,min,pow,div;
	add=min=pow=div="";
	//判断有没有参数传递过来时必须使用null判断，因为s_num1有可能是空指针
	if(s_num1 != null) {
		
		//转换类型 String====>int
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
<h3>简单的四则运算计算器</h3>
		<hr/>
		<!-- form元素保持action属性为空，则默认提交到当前的url -->
		<form  name="form1" action="">
		<label>第一个操作数</label><input type="text" size=10 name="num1" value="<%= num1%>"/><br>
		<select name="opt">
			<option value="+" <%=add %> >+</option>
			<option value="-" <%=min %> >-</option>
			<option value="*" <%=pow %> >*</option>
			<option value="/" <%=div %> >/</option>
		</select><br>
		<label>第二个操作数</label><input type="text" size=10 name="num2" value="<%= num2%>" /><br>
		<!-- onclick中的return，是把check()函数的返回，再次返回到dom语境中-->
		<input type="submit" value="sub" onclick="return check();" />
		</form>
		<hr/>



	<h3>计算结果为<%= result %></h3>
	</body>
</html>