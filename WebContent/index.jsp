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
        div.item img{
    width:100%;
   }
  div#carousel-example-generic{
    width:80%;
    margin:0 auto;
  }
     .distance{
         margin-left:40px;
         margin-top:10px
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
	body{
		background-image:url(main4.jpg);
		padding-bottom:10em;
		background-repeat:no-repeat;
        background-size:100% 100%;
        -moz-background-size:100% 100%;
	}
	.tip_div{
		text-align:center;
		font-size:larger;
		font-weight:bolder;
		
	}
	.tip{
		background-color:#E6E6FA;
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
			  <li role="presentation" class="active distance"><a href="#">首页</a></li>
			  <li role="presentation" class="distance"><a href="mySubject.jsp">我的课表</a></li>
			  <li role="presentation" class="distance" data-toggle="modal" data-target="#myModal"><a href="#" id="myMessage">新的消息<span class="badge">3</span></a>
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

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="school1.jpg" >
    </div>
    <div class="item">
            <img src="school3.jpg" >
    </div>
    <div class="item">
            <img src="school4.jpg" >
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>

  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

  </a>

</div>
    
    <br />
    <div class="text-primary tip_div" >
	    <span class="tip">
	    	<span >代课系统是便利老师的一个非常好的系统， 希望各位老师可以登录此平台，互惠互利</span>
	    	<span class="glyphicon glyphicon-education "></span> 
	    	<span class="glyphicon glyphicon-education "></span>
	    	<span class="glyphicon glyphicon-education "></span>
	    </span>
    </div>
     



     <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog">
        <div class="modal-content">
	          <div class="modal-header">
		            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
		            <h4 class="modal-title">请求</h4>
	          </div>
	          <div class="modal-body">
		          <div id="message_table"></div>
	          </div>
	          
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
</div>



<script>
	$(function(){
		$('#myMessage').click(function(){
			$('#message_table').empty();
			$.get(
					"getmessage",
					function(data){
						var messages=$.parseJSON(data);
						var str="<table class='table table-striped table-bordered table-hover  table-condensed'>";
						str+="<tr><td>申请人</td>";
						str+="<td>课程名称</td>";
						str+="<td>上课时间</td>";
						str+="<td>上课地点</td>";
						str+="<td colspan='2'>操作</td></tr>";
						console.log(messages);
						for(i in messages){
							//console.log(i+" "+messages[i]);
							str+="<tr>";
							str+="<td>"+ messages[i].tName+"</td>";
							str+="<td>"+ messages[i].sName+"</td>";
							str+="<td>"+ messages[i].period+"</td>";
							str+="<td>"+ messages[i].position+"</td>";
							str+="<td><button message_id='"+ i +"' ans='true' class='btn btn-info'>同意</button></td>";
							str+="<td><button message_id='"+ i +"' ans='false' class='btn btn-default'>拒绝</button></td>";
							str+="</tr>";
						}
						str+="</tr></table>";
						$('#message_table').append(str);
					}
				);
			
			
		});
		
		
		
		$('#message_table').delegate('button',"click",function(){
			var message_id=$(this).attr('message_id');
			
			var ans=$(this).attr('ans');
			console.log("ans: "+ans);
			$.get(
				"dealmessage",
				{"message_id":message_id,"ans":ans}
			);

			$('button[message_id='+message_id+']').attr('disabled','disabled');
			alert('操作成功!');
			
			if(ans=='true'){
				$('#btn_refresh').trigger('click');
			}
		});
	});

</script>
<div style="height:200px"></div>



</body>

</html>
<nav class="navbar navbar-default navbar-fixed-bottom">
<div style="text-align:center;font-size:larger"><span class="glyphicon glyphicon-copyright-mark" ></span>
 周莹 蔡佳晨 版权所有
</div>
    <div style="text-align:center;color:indianred;font-size:larger"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span></div>
</nav>