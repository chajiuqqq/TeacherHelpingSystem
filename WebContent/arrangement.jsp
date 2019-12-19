<%@page import="poj.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一周课程安排</title>

<script src="jquery-1.10.2.min.js"></script>
   

<style>
	.main_table{
		border-collapse:collapse;
		height:800px;
	}
	.main_table td{
		border:black solid 2px;
		min-width:20px;
		white-space:pre-line;
		text-align:center;
		width:100px;
		height:80px;
	}
	
	#div_available_teacher{
		width:200px;
		border:blue solid 1px;
		background-color:lightyellow;
		position:absolute;
		
	}
	

</style>

</head>
<body>
<%Teacher teacher=(Teacher)request.getSession().getAttribute("current_teacher");
	out.println(teacher.getName());
%>

<button id="message_btn">我的消息</button><br/>
<p id="message_table"></p>


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


<button id="btn_refresh">刷新</button>
<button id="btn_checkout">退出</button>
<script>
	$('#btn_checkout').click(function(){
		location.assign('checkout');
	});

</script>
<div>
	<table class="main_table">
 		<tr>
 			<td>周日</td>
 			<td>周一</td>
 			<td>周二</td>
 			<td>周三</td>
 			<td>周四</td>
 			<td>周五</td>
 			<td>周六</td>
 		</tr>	
		
		<tr>
			<td id="Sun_1"></td>
			<td id="Mon_1"></td>
			<td id="Tues_1"></td>
			<td id="Wed_1"></td>
			<td id="Thur_1"></td>
			<td id="Fri_1"></td>
			<td id="Sat_1"></td>
		</tr>
	
		<tr>
			<td id="Sun_2"></td>
			<td id="Mon_2"></td>
			<td id="Tues_2"></td>
			<td id="Wed_2"></td>
			<td id="Thur_2"></td>
			<td id="Fri_2"></td>
			<td id="Sat_2"></td>
		</tr>
		<tr>
			<td colspan="7">中午</td>
		</tr>
		
		
		
		<tr>
			<td id="Sun_3"></td>
			<td id="Mon_3"></td>
			<td id="Tues_3"></td>
			<td id="Wed_3"></td>
			<td id="Thur_3"></td>
			<td id="Fri_3"></td>
			<td id="Sat_3"></td>
		</tr>
		<tr>
			<td id="Sun_4"></td>
			<td id="Mon_4"></td>
			<td id="Tues_4"></td>
			<td id="Wed_4"></td>
			<td id="Thur_4"></td>
			<td id="Fri_4"></td>
			<td id="Sat_4"></td>
		</tr>
		<tr>
			<td id="Sun_5"></td>
			<td id="Mon_5"></td>
			<td id="Tues_5"></td>
			<td id="Wed_5"></td>
			<td id="Thur_5"></td>
			<td id="Fri_5"></td>
			<td id="Sat_5"></td>
		</tr>
		<tr>
			<td id="Sun_6"></td>
			<td id="Mon_6"></td>
			<td id="Tues_6"></td>
			<td id="Wed_6"></td>
			<td id="Thur_6"></td>
			<td id="Fri_6"></td>
			<td id="Sat_6"></td>
		</tr>
	
	</table>

<script>
	$(function(){
		$("#btn_refresh").click(function(){
			$.get(
					"arrangement",
					function(data){
						var ts_list=$.parseJSON(data);
						
						for(i in ts_list){
							var current_td=$("td[id="+ts_list[i].period+"]");
							current_td.css("background-color","skyblue");
							current_td.html("<div>"+ts_list[i].tName+"\n"+ts_list[i].sName+"\n"+ts_list[i].position+"\n"+ts_list[i].period+"</div>");
							current_td.attr("TS_id",ts_list[i].id);
							console.log(current_td.attr("TS_id"));
						}
					});
		})
	});


</script>

</div>

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








</body>
</html>