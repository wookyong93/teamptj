<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
<script>
<%-- 닉네임수정 버튼 비활성화 -> 닉네임 중복확인 버튼 활성화
	 이소정 작성 --%>
function modNick(){
	var modNick = document.getElementById("modNick");
	modNick.removeAttribute("disabled");
	document.getElementById("modNick").setAttribute("type","hidden");
	document.getElementById("modName").setAttribute("type","button");
}


<%-- 권우경님 작성 복사 --%>
window.onload = function(){
	var id = '<%=request.getParameter("id")%>';
	var nickname='<%=request.getParameter("nickname")%>';
	if(nickname!='null'){
		document.getElementById("hname").value="1";
	}
}
<%--닉네임 중복체크 /권우경 작성--%>
function fn_nameCheck(){
	var nickname = document.getElementById("nickname").value;
	var id = document.getElementById("id").value;
	location.href="${contextPath}/member/nameCheck.do?nickname="+nickname+"&id="+id;
}

<%--회원수정 진행 /권우경 작성--%>
function fn_insert(){
	var frm = document.frm;
	var pwd = frm.pwd;
	var pwdchk = document.getElementById("pwdchk");
	var nickname = frm.nickname;
	var birth =document.getElementById('birth').value;
	var hname = document.getElementById('hname').value;
	if(nickname.value==""){
		alert('닉네임을 입력하세요');
		pwdchk.focus();
	}
	else if(nickname.value != "" && hname=="0"){
		alert('닉네임 중복체크를 해주세요');	
	}
	else if(pwd.value==""){
		alert('비밀번호를 입력하세요');
		pwd.focus();
	}else if(pwdchk.value==""){
		alert('비밀번호 확인을 입력하세요');
		pwdchk.focus();
	}else if(pwdchk.value != pwd.value){
		alert('비밀번호가 서로 다릅니다.');
		pwd.value="";
		pwdchk.value="";
		pwd.focus();
	}else{
		frm.method="post";
		frm.action="${contextPath }/admin/modMember.do?id="+id;
		frm.submit();
		}
	}
</script>
</head>
<body>
<form method="post" name = "frm" action="${contextPath }/admin/modMember.do">
	<table width="60%">
		<tr>
			<td>아이디</td>
			<td><input type="text" value="${member.id }" disabled="disabled">
			<input type="hidden" name="id" value="${member.id }"></td>
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
				<input type="button" name="modNick" onclick="fn_nameCheck()" value="닉네임수정">
				<input type="hidden" name="modName" value="중복확인">
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" value="${member.birth }" disabled="disabled">
			<input type="hidden" name="birth" value="${member.birth }"></td>
		</tr>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정완료">
				<a href="${contextPath }/admin/listMember.do">
					<input type="button" value="회원목록">
				</a>
			</td>
		</tr>
	</table>
		<input type="hidden" value="0" id="hname"/>
</form>
</body>
</html>