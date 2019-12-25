<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>

<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
 
    <meta name="viewport"content="width=device-width, user-scalable=no, 
        initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>  
    <!--上述代码是为了实现PC端自适应屏幕-->
    <!--px要改为em，最好用%-->
     <style>
		body{
			background-image:url(ts_bg2.jpg);
			padding-bottom:10em;
			background-repeat:no-repeat;
	        background-size:100% 100%;
	        -moz-background-size:100% 100%;
		}
		
		
		#teacher_img{
		
			width:50px;
		
		}
		.li_timg{
			padding-top:10px;
			margin-left:700px;
		}
		#below{
			position:absolute;
			right:200px;
			display:none;
			
		}
		
		.distance{
         margin-left:40px;
         margin-top:10px;
     	}
     	.main_div{
     		width:50%;
     		margin:0 auto;
     	}
     	.title_div{
     		width:100%;
     	}
     	.main_table{
     		width:100%;
     	}
		
		
	
	
	
    </style>
    <script>
   
    function move(){
    var d = document.getElementById("below");
    d.style.display="block";
}
    function move2(){
    var d = document.getElementById("below");
    d.style.display="none";
}
    </script>
</head>
<body>
    <div id="top">
        <ul class="nav nav-tabs">
			  <li role="presentation" class="distance"><a href="index.jsp">首页</a></li>
			  <li role="presentation" class="distance"><a href="mySubject.jsp">我的课表</a></li>
			  <li role="presentation" class="distance" data-toggle="modal" data-target="#myModal"><a href="#">新的消息<span class="badge">3</span></a>
			  <li role="presentation" class="li_timg">
					  <img id="teacher_img" src="teacher2.jpg" class="img-circle" onmousemove="move()" onmouseout="move2()">
			  </li>
      	</ul>
        <div id="below"  onmousemove="move()" onmouseout="move2()">
           <a href="myCenter.jsp" ><button type="button" class="btn btn-default" >个人中心</button></a>
        </div>
    </div>
    
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-top:50px;width:850px">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  
     
    
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
	        <div class="modal-content">
		          <div class="modal-header">
			            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			            <h4 class="modal-title">请求</h4>
		          </div>
	        </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>


<div class="title_div">
	<h2>个人中心</h2>
	<hr style="border-top:5px solid slategrey;margin-top:1px;"/>

</div>

<div class="main_div">
	<form>
		<table class="main_table">
			<tr>
				<td>
					姓名：<input type="text" id="name" name="name" value="${current_teacher.name}" class="form-control">
				</td>
			</tr>
			
			<tr>
				<td>
					用户名：<input type="text" id="username" name="username" value="${current_teacher.username}" class="form-control">
				</td>
			</tr>
			<tr>
				<td>
					密码：<input type="text"  id="password" name="password" value="${current_teacher.password}" class="form-control">
				</td>
			</tr>
			<tr>
				<td>
					工号：<input type="text" id="tno"  name="tno" value="${current_teacher.tno}" class="form-control input_tno" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td>
					<button id="btn_submit" class="form-control">提交更改</button>
				</td>
			</tr>
		
		</table>
	</form>

</div>

<script type="text/javascript">
	$(function(){
		
		
		$('#btn_submit').click(function(){
			var val={"name":$('#name').val(),"username":$('#username').val(),"password":$('#password').val(),"tno":$('#tno').val()}
			$.post(
				"updateTeacher",
				val
			);
			alert('修改成功!');
			location.reload();
		
		});
		
		
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