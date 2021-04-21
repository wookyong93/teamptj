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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
 // 수정중 ㅠㅠ
	window.onload = function(){
		var nick = '<%=request.getParameter("nickname") %>';
		if(nick != 'null' && nick.length != 0){
			document.getElementById("nickname").value = nick;
		} 
	}
	<%-- 닉네임 변경시 중복확인 버튼 활성화--%>
	<!-- 강민경님 작성 복사 -->
	$(document).ready(function () {
		var nickname = document.getElementById("nickname").value;
		$("#nickname").on('input change', function(){
			if($(this).val()==nickname)
				$("#TestBtn").attr("disabled",true);
			else
				$("#TestBtn").attr("disabled",false);
		});
	})
	function mod() {
		var frm = document.view;
		var pwd = frm.pwd;
		var pwdchk = frm.pwdchk;
		var nickname = frm.nickname;
		//4/19 권우경 작성 닉네임 중복체크 안되있을시 수정 불가 
		var nicknameBtn = frm.nicknameBtn.disabled;
		
		
		if(nickname.value==""||nickname.length==0){
			alert("닉네임을 입력해주세요.");
			nickname.focus();
		}else if(nicknameBtn == false){
			//4/19 권우경 작성 닉네임 중복체크 안되있을시 수정 불가 
			alert('중복확인을 해주세요');	
		}
		else if(pwd.value==""||pwd.length==0){
			alert("비밀번호를 입력해주세요.");
			pwd.focus();
		}else if(pwdchk.value==""||pwdchk.length==0){
			alert("비밀번호 확인을 입력해주세요.");
			pwdchk.focus();
		}else if(pwd.value!=pwdchk.value){
			alert("비밀번호가 일치하지 않습니다.");
			pwd.focus();
		}else{
			alert("수정되었습니다.");
			frm.action="${contextPath}/admin/modMember.do?id="+id;
			frm.method="POST";
			frm.submit();
		}
		
	}
	
	<%--우경님 작성 copy / 수정--%>
	function nicknameCheck() {
		var nickname = document.getElementById("nickname").value;
		var id = document.getElementById("id").value;

		location.href='${contextPath}/admin/nameCheck.do?nickname='+nickname+'&id='+id;

		location.href="${contextPath}/admin/nameCheck.do?id=${loginID}&nickname="+nickname;

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
	       <td><input type="password" name="pwdchk"></td>
	    </tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name ="nickname" value="${member.nickname }"></td>
			<td>
				<input type="hidden" value="${member.nickname }">
				<input id="TestBtn" type="button" name="nicknameBtn" disabled="true" onclick="nicknameCheck()" value="중복확인">
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
			<td colspan="2"><input type="button" value="수정완료" onclick="mod()">
				<a href="${contextPath }/admin/listMember.do">
					<input type="button" value="회원목록">
				</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>