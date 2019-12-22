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
     .distance{
         margin-left:40px;
         margin-top:10px;
     }
     #distance{
         margin-left:40px;
         margin-top:10px;
     }
     div#table{
         display:inline-block;
         margin-top:30px;
         width:80%;
         margin-left:10%;
     }
     table{
        text-align:center;
         font-size:larger;
         font-weight:bolder;
     }
     td{
	         text-align:center;
	         
	         min-width:20px;
			white-space:pre-line;
			text-align:center;
			width:100px;
			height:80px;
     }.
     .h{
         height:70px;
     }
     
	#div_available_teacher{
		width:200px;
		border:blue solid 1px;
		background-color:lightyellow;
		position:absolute;
		
	}
	.btns_top{
		float:right;
	}
	
	#teacher_img{
		float:right;
		width:50px;
		margin-right:10px;
		margin-top:5px
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
<body style="background-image:url(main4.jpg);padding-bottom:10em;">
    <div id="top">
        <ul class="nav nav-tabs">
			  <li role="presentation" class="distance"><a href="Main.html">首页</a></li>
			  <li role="presentation" class="active" id="distance"><a href="#">我的课表</a></li>
			  <li role="presentation" class="distance"><a href="History.html">历史代课记录</a></li>
			  <li role="presentation" class="distance" data-toggle="modal" data-target="#myModal">
			  		<a href="#"  id="message_btn" >新的消息<span class="badge">3</span></a>
			  </li>
			  <li role="presentation" style="margin-top:2px;margin-right:70px;margin-left:770px">
		  			<img id="teacher_img" src="teacher2.jpg" class="img-circle" onmousemove="move()" onmouseout="move2()">
  			   </li>
        </ul>
        <div id="below" style="margin-right:70px;margin-left:1290px;display:none;margin-top:0px;position:absolute" onmousemove="move()" onmouseout="move2()">
            <button type="button" class="btn btn-default" >个人中心</button>
        </div>
    </div>
  
  
<div class="btns_top">
	<button id="btn_refresh" class="btn btn-primary">刷新</button>
	<button id="btn_checkout" class="btn btn-default">退出</button>
</div>
<script>
	$('#btn_checkout').click(function(){
		location.assign('checkout');
	});

</script>


<script>
	$(function(){
		$.get(
				"getmessage",
				function(data){
					var messages=$.parseJSON(data);
					var str="<table>";
					str+="<tr><td>申请人</td>";
					str+="<td>课程名称</td>";
					str+="<td>上课时间</td>";
					str+="<td>上课地点</td></tr>";
					console.log(messages);
					for(i in messages){
						//console.log(i+" "+messages[i]);
						str+="<tr>";
						str+="<td>"+ messages[i].tName+"</td>";
						str+="<td>"+ messages[i].sName+"</td>";
						str+="<td>"+ messages[i].period+"</td>";
						str+="<td>"+ messages[i].position+"</td>";
						str+="<td><button message_id='"+ i +"' ans='true'>同意</button></td>";
						str+="<td><button message_id='"+ i +"' ans='false'>拒绝</button></td>";
						str+="</tr>";
					}
					str+="</tr></table>";
					$('#message_table').append(str);
				}
			);
		
		$('#message_table').hide();
		$('#message_btn').click(function(){
			$('#message_table').slideToggle(500);
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
<br/>
 <!--7行7列-->
    <div id="table" >
     <table class="table table-striped table-bordered table-hover  table-condensed">
         <tr class="h" style="background-color:#D2691E">
             <td>节次/周次</td>
             <td>星期日</td>
             <td>星期一</td>
             <td>星期二</td>
             <td>星期三</td>
             <td>星期四</td>
             <td>星期五</td>
             <td>星期六</td>
         </tr>
         <tr>
         	<td>第一节课</td>
			<td id="Sun_1"></td>
			<td id="Mon_1"></td>
			<td id="Tues_1"></td>
			<td id="Wed_1"></td>
			<td id="Thur_1"></td>
			<td id="Fri_1"></td>
			<td id="Sat_1"></td>
		</tr>
	
		<tr>
			<td>第二节课</td>
			<td id="Sun_2"></td>
			<td id="Mon_2"></td>
			<td id="Tues_2"></td>
			<td id="Wed_2"></td>
			<td id="Thur_2"></td>
			<td id="Fri_2"></td>
			<td id="Sat_2"></td>
		</tr>
		<tr>
			<td colspan="8">中午</td>
		</tr>
		
		<tr>
			<td>第三节课</td>
			<td id="Sun_3"></td>
			<td id="Mon_3"></td>
			<td id="Tues_3"></td>
			<td id="Wed_3"></td>
			<td id="Thur_3"></td>
			<td id="Fri_3"></td>
			<td id="Sat_3"></td>
		</tr>
		<tr>
			<td>第四节课</td>
			<td id="Sun_4"></td>
			<td id="Mon_4"></td>
			<td id="Tues_4"></td>
			<td id="Wed_4"></td>
			<td id="Thur_4"></td>
			<td id="Fri_4"></td>
			<td id="Sat_4"></td>
		</tr>
		<tr>
			<td>第五节课</td>
			<td id="Sun_5"></td>
			<td id="Mon_5"></td>
			<td id="Tues_5"></td>
			<td id="Wed_5"></td>
			<td id="Thur_5"></td>
			<td id="Fri_5"></td>
			<td id="Sat_5"></td>
		</tr>
		<tr>
			<td>第六节课</td>
			<td id="Sun_6"></td>
			<td id="Mon_6"></td>
			<td id="Tues_6"></td>
			<td id="Wed_6"></td>
			<td id="Thur_6"></td>
			<td id="Fri_6"></td>
			<td id="Sat_6"></td>
		</tr>
     </table>
    </div>


<script>
	$(function(){
		$("#btn_refresh").click(function(){
			$.get(
					"arrangement",
					function(data){
						var ts_list=$.parseJSON(data);
						
						for(i in ts_list){
							var current_td=$("td[id="+ts_list[i].period+"]");
							current_td.css("background-color","yellow");
							current_td.html("<div>"+ts_list[i].tName+"\n"+ts_list[i].sName+"\n"+ts_list[i].position+"\n"+ts_list[i].period+"</div>");
							current_td.attr("TS_id",ts_list[i].id);
							console.log(current_td.attr("TS_id"));
						}
					});
		})
	});


</script>


<div id="div_available_teacher">
<table id="table_available_teacher">


</table>
</div>
<script>
	$(function(){
		
		$('td').click(function(){
			var current=$(this);
			var ts_id=current.attr("TS_id");
			$("#table_available_teacher").empty();
			$("#div_available_teacher").slideUp(500);
			$.get(
				"getAvailableTeacher",
				{"TS_id":ts_id},
				function(data){
					var x=current.offset().left;
					var y=current.offset().top;
					
					var width=current.outerWidth();
					var height=current.outerHeight();
					
					var teachers=$.parseJSON(data);
					console.log(teachers);
					if(teachers.length!=0){
						for(i in teachers){
							var str="<tr><td>"+teachers[i].name+"</td>";
							str+="<td><button tno='"+teachers[i].tno+"' current_ts='"+ts_id+"'>请求代课</button></td></tr>"
							$("#table_available_teacher").append(str);
							
						}
					}else{
						$("#table_available_teacher").append("<strong>无</strong>");
					}

					$("#div_available_teacher").css({"top":y,"left":x+width});
					$("#div_available_teacher").slideDown(500);
				}
			);
			

		});
		
		$('#table_available_teacher').delegate("button", "click",function(){
			var thiseven=$(this);
			console.log(typeof(thiseven)+" "+thiseven.attr('tno'));
			var tno=thiseven.attr("tno");
			var current_ts=thiseven.attr("current_ts");
			$.post(
				"submitRequest",
				{"tno":tno,"current_ts":current_ts},
				function(data){

					//$('button[tno='+ tno +']').attr("disabled","disabled");
					alert('申请成功！'+tno);
				}
			);
		});
		
		$('#div_available_teacher').mouseleave(function(){
			$("#table_available_teacher").empty();
			$("#div_available_teacher").slideUp(500);
		});
		
		
		
		
	});
</script>










     <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog">
        <div class="modal-content">
	          <div class="modal-header">
		            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
		            <h4 class="modal-title">请求</h4>
	          </div>
	          <div class="modal-body">
		          <p id="message_table"></p>
	          </div>
	          
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
</div>


<div style="height:200px"></div>

</body>

</html>
<nav class="navbar navbar-default navbar-fixed-bottom">
<div style="text-align:center;font-size:larger"><span class="glyphicon glyphicon-copyright-mark" ></span>
 周莹 蔡佳晨 版权所有
</div>
    <div style="text-align:center;color:indianred;font-size:larger"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span></div>
</nav>