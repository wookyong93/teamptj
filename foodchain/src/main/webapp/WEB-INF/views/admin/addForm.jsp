<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)회원추가</title>
<!-- 21/04/12 이소정 작성 -->
<style>
   a{ color:black; }
   a:link { color:black; text-decoration:none; }
   a:visited { color:black; text-decoration:none; }
   a:hover{ color:blue; text-decoration:underline; }
   
   	table {
   		text-align:center;
   		margin:auto;
   		border-collapse:collapse;
	}
	td,tr {
		border:1px solid;
	}
	.select {
		border-radius: 0.5em;
	}
</style>
<script>
	$(document).ready(function(){
		setDateBox();
	});
	
	function setDateBox(){
		var date = new Date();
		var year = "";
		var com_year = date.getFullYear();
		
		
		// 올해 기준으로 -50년부터 +1년씩 보여줌
		$("#year").append("<option value=''>년도</option>");
		for(var y=(com_year - 50); y <= (com_year + 1); y++){
			$("#year").append("<option value='"+y+"'>"+y+" 년"+"</option>");
		}
		
		// 1월 ~ 12월
		var month;
		$("#month").append("<option value=''>월</option>");
		for(var i=1;i<=12;i++){
			$("#month").append("<option value='"+i+"'>"+i+" 월"+"</option>");
		}
		
		var day;
		$("#day").append("<option value=''>일</option>");
		for(var i=1;i<=31;i++){
			$("#day").append("<option value='"+i+"'>"+i+" 일"+"</option>");
		}
	}
</script>
</head>
<body>
<form method="post" action="${contextPath }/modMember.do">
	<table width="80%">
		<tr>
			<td>아이디</td>
			<td><input type="text" name='id' ></td>
			<td><input type="button" value="중복확인"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name='password'></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name='nickname'></td>
			<td><input type="button" value="중복확인"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<select name="year" id='year' title="년도" class="select"></select>
				<select name="month" id='month' title="월" class="select"></select>
				<select name="day" id='day' title="일" class="select"></select>
			</td>
		</tr>
	</table>
<input type="submit" value="가입완료">
<input type="reset" value="다시입력">
<a href="${contextPath }/admin/listMember.do"><input type="button" value="회원목록"></a>
</form>
</body>
</html>