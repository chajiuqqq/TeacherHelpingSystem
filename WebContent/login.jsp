<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
 
    <meta name="viewport"content="width=device-width, user-scalable=no, 
        initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>  
    <!--上述代码是为了实现PC端自适应屏幕-->
    <!--px要改为em，最好用%-->
    <style>
    
     table#medium{
         background-color:white;
         text-align:center;
         width:400px;
         height:300px;
         margin:15% auto;
     }
     #checkbox{
         float:left;
         margin-left:15%;
     }
     #forget{
         float:right;
         margin-right:11%;
        color:royalblue;
     }
     #small{
         font-size:smaller;
     }
     
     #password{
         margin:0 auto;
     }
     #username{
         margin:0 auto;
     }
     body{
     	background-image:url(cat.jpg);
     	padding-bottom:10em;
     }
    
    </style>
</head>
<body >

    
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
	
	<div id="back">
        <table id="medium">
            <tr>
                <td style="font-size:larger;text-align:center;font-weight:bolder">欢迎登录代课系统</td>
            </tr>
            <tr>
                <td id="small">
                    <span >还没有账户？快点击</span>
                    <a href="register.jsp" target="_self"><span class="btn btn-link" style="color:darkorange">注册</span></a>
	
                    <span>一个吧！</span>
                </td>
            </tr>

            <tr>
                <td><input id="username" type="text" class="form-control" placeholder="账号" style="width:70%"></td>
            </tr>

            <tr>
                <td> <input id="password" type="password" class="form-control" placeholder="密码" style="width:70%"></td>
            </tr>
            
            <tr>
                <td >
                    <span id="checkbox">
                        <input id="Checkbox1" type="checkbox" />记住我
                    </span>
                    <span class="btn btn-link" id="forget">忘记密码？</span>
                </td>
            </tr>
            
            <tr>
                <td id="denglu">
                    <button id="btn_login" type="button" class="btn btn-warning" style="width:70%">登录</button>
                </td>
            </tr>
        </table>

    </div>


</body>
</html>
<nav class="navbar navbar-default navbar-fixed-bottom">
<div style="text-align:center;font-size:larger"><span class="glyphicon glyphicon-copyright-mark" ></span>
 周莹 蔡佳晨 版权所有
</div>
    <div style="text-align:center;color:indianred;font-size:larger"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span></div>
</nav>