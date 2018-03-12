<!-- 这是接收页面提交的数据，计算并显示结果 -->
<%@ page contentType="text/html;charset=gb2312" %>
<html>
<body>
<h2>计算结果是
	
<% 
	//接收第一个参数
	String s_num1 = request.getParameter("num1");
	//接收第二个参数
	String s_num2 = request.getParameter("num2");
	
	//转换类型 String====>int
	int num1 = Integer.parseInt(s_num1);
	int num2 = Integer.parseInt(s_num2);
	//初始化结果对象
	int result =0;
	//接收操作符号
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
	//计算并输出结果	
	out.println(result);
%>
</h2>
</body>
</html>