<%@page import="DAO.SubjectDAO"%>
<%@page import="poj.Subject"%>
<%@page import="poj.Teacher"%>
<%@page import="DAO.TeacherDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制台</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

	<style>
		body{
			background-image:url(admin_bg.png);
		}
		#select_div{
			width:500px;
			padding:20px;
			margin:0 auto;
			
		}
		table{
			text-align:center;
			width:400px;
			
		}
		#div_checkout{
			position:absolute;
			right:20px;
			top:10px;
		}
		
	</style>
</head>
<body>
<%
	List<Teacher> teachers=TeacherDAO.getTeachers();
	request.setAttribute("teachers", teachers);
	
	List<Subject> subjects=SubjectDAO.getSubjects();
	request.setAttribute("subjects", subjects);
	
%>
<div id="div_checkout">
	<button id="btn_checkout" class="btn btn-danger" onclick="location.assign('login.jsp')">退出</button>
</div>

<div id="select_div">
<table >
	<tr>
		<td><h3>添加教学课程安排</h3></td>
	</tr>
	<tr>
		<td>
			<select id="select_teacher" class="form-control">
				<option>请选择老师</option>
				<c:forEach items="${teachers}" var="teacher" varStatus="st">
					<option value="${ teacher.tno}">${teacher.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="select_subject" class="form-control">
				<option>请选择学科</option>
				<c:forEach items="${subjects}" var="subject" varStatus="st">
					<option value="${ subject.id}">${subject.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<select id="select_time" class="form-control">
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="select_place" class="form-control">
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
	<button id="btn_submit" class="btn btn-warning">提交</button>
		</td>
	</tr>
</table>	
</div>


<script>
	$(function(){
		$('#select_subject,#select_teacher').change(function(){
			$('#select_time').empty();
			$('#select_time').append("<option>请选择时间</option>");
			$('#select_place').empty();
			$('#select_place').append("<option>请选择地点</option>");
			var tid=$('#select_teacher').val();
			$.get(
				"getavailabletime?tid="+tid,
				function(data){
					var times=$.parseJSON(data);
					for(i in times){
						var opt="<option value='"+ i +"'>"+ times[i] +"</option>";
						$('#select_time').append(opt);
					}
				}
			);
			
		});
		
		$('#select_time').change(function(){
			$('#select_place').empty();
			$('#select_place').append("<option>请选择地点</option>");
			var timeid=$(this).val();
			$.get(
				"getavailableplace?timeid="+timeid,
				function(data){
					var places=$.parseJSON(data);
					for(i in places){
						var opt="<option value='"+ i +"'>"+ places[i] +"</option>";
						$('#select_place').append(opt);
					}
				}
			);
			
		});
	});

</script>


<script>

	$(function(){
		function check(x){
			if(Number.isNaN(Number(x)))
				return false;
			else
				return true;
		}
		$('#btn_submit').click(function(){
			var tid=$('#select_teacher').val();
			var sid=$('#select_subject').val();
			var timeid=$('#select_time').val();
			var placeid=$('#select_place').val();
			if(!check(tid+sid+timeid+placeid)){
				alert("信息选择有误!");
				return;
			}else{
				console.log("tid: "+tid+"sid: "+sid+"timeid: "+timeid+"placeid: "+placeid);
				$.get(
					"dealaddTS",
					{"tid":tid,"sid":sid,"timeid":timeid,"placeid":placeid}
				);
				alert("提交成功!");
			}
		});
	});





</script>
</body>
</html>