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
<%-- id 값 처리 --%>
window.onload = function(){
var birth =document.getElementById('birth').value;
console.log(birth);
	var id = '<%=request.getParameter("id")%>';
	var nickname='<%=request.getParameter("nickname")%>';
	if(id != 'null' && nickname !='null'){
		document.getElementById("id").value = id;
		document.getElementById("nickname").value = nickname;
		document.getElementById("hid").value="1";
		document.getElementById("hname").value="1";
	}else if(id != 'null'&& nickname=='null'){
		document.getElementById("id").value = id;
		document.getElementById("hid").value="1";
	}else if(id == 'null' && nickname != 'null'){
		document.getElementById("nickname").value = nickname;
		document.getElementById("hname").value="1";
	}
}
<%--id 중복체크 /권우경 작성--%>
function fn_idCheck(){
	var id = document.getElementById("id").value;
	location.href="${contextPath}/member/idCheck.do?id="+id;
}
<%--닉네임 중복체크 /권우경 작성--%>
function fn_nameCheck(){
	var nickname = document.getElementById("nickname").value;
	var id = document.getElementById("id").value;
	location.href="${contextPath}/member/nameCheck.do?nickname="+nickname+"&id="+id;
}

<%--회원가입 진행 /권우경 작성--%>
function fn_insert(){
	var frm = document.frm;
	var id = frm.id;
	var pwd = frm.pwd;
	var pwdchk = document.getElementById("pwdchk");
	var nickname = frm.nickname;
	var birth =document.getElementById('birth').value;
	var hid = document.getElementById('hid').value;
	var hname = document.getElementById('hname').value;
	if(id.value == ""){
		alert('아이디를 입력하세요');
		id.focus();
	}
	else if(id.value!="" && hid == "0"){
		alert('id 중복체크를 해주세요');
	}
	else if(nickname.value==""){
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
	}
	else if(birth==""){
		alert('생년월일을 입력해주세요');
	}else{
		frm.method="post";
		frm.action="${contextPath}/admin/addMember.do";
		frm.submit();
		}
	}
</script>
</head>
<body>
<form method="post" name="frm" action="${contextPath }/admin/addMember.do">
	<table width="80%">
		<tr>
			<td>아이디</td>
			<td width="200"><input type="text" name='id' id='id' ></td>
			<td><input class="btn1" type="button" value="중복체크" id="idck" onclick="fn_idCheck()" />
		</tr>
		 <tr>
	      <td><p align="left">패스워드</td>
	      <td><input type="password" name="pwd" id='pwd'></td>
	    </tr>
	    <tr>
	       <td><p align="left">패스워드확인</td>
	       <td><p><input type="password" id="pwdchk"></td>
	    </tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name='nickname' id='nickname'></td>
			<td><input type="button" class="btn1" value="중복확인" id="nnck" onclick="fn_nameCheck()"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" name="birth" id='birth'></td>
		</tr>
	</table>
		<input type="hidden" value="0" id="hid"/>
		<input type="hidden" value="0" id="hname"/>
<input type="submit" value="가입완료">
<input type="reset" value="다시입력">
<a href="${contextPath }/admin/listMember.do"><input type="button" value="회원목록"></a>
</form>
</body>
</html>