<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
request.setCharacterEncoding("utf-8");
String loginID = request.getParameter("id");
session.setAttribute("loginID", loginID);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)회원수정</title>
<!-- 21/04/12 이소정 작성 -->
<style>
   body{
      background-color:#d3d3d3;
   }
   input[type=button],input[type=submit]{
   	background-color:#CCFFCC;
   	width:100px;
   	height:40px;
   }
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
		border:1px solid white;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	window.onload = function(){
		var nick = '<%=request.getParameter("nickname") %>';
		if(nick != 'null' && nick.length != 0){
			document.getElementById("nickname").value = nick;
		} 
	}
	<%-- 닉네임 변경시 중복확인 버튼 활성화--%>
	<%-- 강민경님 작성 복사 --%>
	$(document).ready(function () {
		var nickname = document.getElementById("nickname").value;
		$("#nickname").on('input change', function(){
			if($(this).val()==nickname)
				$("#TestBtn").attr("disabled",true);
			else
				$("#TestBtn").attr("disabled",false);
		});
	})

<%--회원수정 진행 /권우경 작성 , 이소정 수정--%>
function fn_insert(){
	var frm = document.frm;
	var pwd = frm.pwd;
	var pwdchk = document.getElementById("pwdchk").value;
	var nickname = frm.nickname;
	//4/19 권우경 작성 닉네임 중복체크 안되있을시 수정 불가 
	var nicknameBtn = frm.nicknameBtn.disabled;
	
	
	if(nickname.value==""||nickname.length==0){
		alert('닉네임을 입력하세요');
		pwdchk.focus();
	} else if(nicknameBtn == false){
		//4/19 권우경 작성 닉네임 중복체크 안되있을시 수정 불가 
		alert('중복체크 해주세요');	
	} else if(pwd.value=="" || pwd.length==0){
		alert('비밀번호를 입력하세요');
		pwd.focus();
	} else if(pwdchk.value=="" || pwdchk.length==0){
		alert('비밀번호 확인을 입력하세요');
		pwdchk.focus();
	} else if(pwdchk.value != pwd.value){
		alert('비밀번호가 일치하지 않습니다.');
		pwd.value="";
		pwdchk.value="";
		pwd.focus();
	} else {
		alert('수정되었습니다.');
		frm.method="post";
		frm.action="${contextPath }/admin/modMember.do?id="+id;
		frm.submit();
		}
	
	<%--닉네임 중복체크 /권우경 작성--%>
	function fn_nameCheck(){
		var nickname = document.getElementById("nickname").value;
		var id = document.getElementById("id").value;


		location.href='${contextPath}/admin/nicknameCheck.do?nickname='+nickname+'&id='+id;

		location.href="${contextPath}/admin/nicknameCheck.do?id=${loginID}&nickname="+nickname;

	}
	
}
</script>
</head>
<body>
<form method="post" name = "frm">
	<table width="60%">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" value="${member.id }" disabled="disabled">
				<input type="hidden" name="id" value="${member.id }">
			</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name ="pwd"></td>
		</tr>
		<tr>
	       <td>패스워드확인</td>
	       <td><input type="password" id="pwdchk"></td>
	    </tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name ="nickname" value="${member.nickname }"></td>
			<td>
				<input type="hidden" value="${member.nickname }">
				<input id="TestBtn" type="button" name="nicknameBtn" disabled="true" onclick="fn_nameCheck()" value="중복확인">
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="date" value="${member.birth }" disabled="disabled">
				<input type="hidden" name="birth" value="${member.birth }">
			</td>
		</tr>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정완료" onclick="fn_insert()">
				<a href="${contextPath }/admin/listMember.do">
					<input type="button" value="회원목록">
				</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>