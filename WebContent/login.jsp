<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<script src="jquery-1.10.2.min.js"></script>
   
<script>
	$(function(){
		$('#btn_login').click(function(){
			
				var username=$('#username').val();
				var password=$('#password').val();
				$.post(
					"deal_login",
					  {"username":username,"password":password},
					  function(data){
						  var result=$.parseJSON(data).result;
						  if(result){
							  alert("登录成功！");
							  location.assign("arrangement.jsp");
						  }else{
							  alert("登录失败！用户名不正确或者密码错误");
						  }
					  }
				);
			
			
		});
	});

</script>
<div align="center">
	
	用户名:<input type="text" id="username"><br/>
	密码:<input type="password" id="password"><br/>
	<button id="btn_login">登入</button>
	<a href="register.jsp" target="_self"><button id="btn_register">注册</button></a>
	

</div>

</body>
</html>