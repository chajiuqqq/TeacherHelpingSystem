<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

    <meta name="viewport"content="width=device-width, user-scalable=no, 
        initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>  
    <!--上述代码是为了实现PC端自适应屏幕-->
    <!--px要改为em，最好用%-->
    <style>
     #medium{
         background-color:white;
         text-align:center;
         width:600px;
         height:520px;
         margin:15% auto;
     }
     .left{
         width:40%;
         text-align:right;
         padding-right:5px;
     }
     .right{
         width:60%;
         text-align:left;
         padding-left:5px;
     }
     .distance{
         padding-top:10px;
     }
     .small_font{
         font-size:x-small;
         text-align:center;
     }
    body{
	    background-image:url(cat.jpg);
	    padding-bottom:10em;
    }
    </style>
</head>


<body >
  <div id="medium">
      <div style="font-size:x-large;font-weight:bolder;color:slategrey;text-align:left;padding-top:15px;padding-left:20px">账户注册</div>
      <hr style="border-top:5px double slategrey;margin-top:1px;width:96%"/>
      
      <form action="">
      <table style="width:350px;margin:5px auto">
          
          <tr class="distance">
              <td class="left">账号：<br />
                  <br />
              </td>
              <td  class="right"><input id="username" type="text" class="form-control" placeholder="请输入用户名" style="width:100%"><br />
              </td>
          </tr>
         
          <tr class="distance">
              <td class="left">密码：<br />
                  <br />
              </td>
              <td class="right"><input id="password1" type="password" class="form-control" placeholder="请输入6-20位字母或数字" style="width:100%"><br />
              </td>
          </tr>
          <tr class="distance">
              <td class="left">确认密码：<br />
                  <br />
              </td>
              <td class="right"><input id="password2" type="password" class="form-control" placeholder="请输入6-20位字母或数字" style="width:100%"><br />
           
          </tr>
          
          <tr class="distance">
              <td class="left">工号：<br />
                  <br />
              </td>
              <td class="right"><input id="tno" type="text" class="form-control" placeholder="请输入您在该校的工号" style="width:100%"><br />
              </td>
          </tr>
          
          <tr class="distance">
              <td class="left">手机号：<br />
                  <br />
              </td>
              <td class="right"><input id="phoneNumber" type="text" class="form-control" placeholder="请输入手机号" style="width:100%"><br />
              </td>
          </tr>
          
          <tr class="distance">
              <td class="left">常用邮箱：<br />
                  <br />
              </td>
              <td class="right"><input id="email" type="text" class="form-control" placeholder="请输入常用邮箱" style="width:100%"><br />
              </td>
          </tr>
          
          <tr>
              <td colspan="2" class="small_font"> 
	              <input id="checkbox_treaty" type="checkbox" />
	              <span style="color:darkgray">我已阅读并同意</span>
	              <span style="color:orange">《上海师范大学代课系统协议》<br/><br/></span>
	              
              </td> 
          </tr>
          
          <tr>
              <td colspan="2" style="text-align:center">
             	 	<button id="btn_submit_register" class="btn btn-primary" style="width:50%">立即注册</button>
              </td>
          </tr>
          <tr>
              <td colspan="2" class="small_font" >
                  	<span><br/>已有账户？</span>
              		<span id="link_to_login" class="btn btn-link" style="color:orange;font-size:x-small;margin-left:1em">立即登录</span>
              </td>
          </tr>
      </table>
      </form>
  </div>
  
  <script type="text/javascript">
  	$('input[type!=checkbox]').after("<td></td>");
  	$('input[type!=checkbox]').bind('blur',function(){
  		var curr=$(this);
  		if(curr.val().length==0){
  			curr.next().html("<span style='color:red'>输入为空<span>");
  		}
  	});
  	
  	$('#password2').bind('keyup',function(){
  		var p1=$('#password1').val();
  		var p2=$(this).val();
  		if(p1!=p2)
  			$(this).next().html("<span style='color:red'>两次密码不一致！<span>");
  		else
  			$(this).next().html("");
  		
  	});
  	
  	$('#tno,#phoneNumber').bind('keyup',function(){
  		var tno=$(this).val();
  		if(Number.isNaN(Number(tno)))
  			$(this).next().html("<span style='color:red'>需要为数字！<span>");
  		else
  			$(this).next().html("");
  		
  	});
  	$('#btn_submit_register').attr('disabled','disabled');
  	$('#checkbox_treaty').click(function(){ 
		var ischeck=$(this).attr("checked"); 
		if(ischeck==undefined){ 
		 $('#btn_submit_register').attr('disabled','disabled');
		
		}else{ 
			//
			$('#btn_submit_register').attr('disabled','');
		}
	}); 
  
  </script>
    
</body>

</html>
<nav class="navbar navbar-default navbar-fixed-bottom">
<div style="text-align:center;font-size:larger"><span class="glyphicon glyphicon-copyright-mark" ></span>
 周莹 蔡佳晨 版权所有
</div>
    <div style="text-align:center;color:indianred;font-size:larger"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span></div>
</nav>