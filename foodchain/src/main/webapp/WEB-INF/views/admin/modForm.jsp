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
<!-- 다시 수정해보기 -->
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
	
</style>

</head>
<body>
<form method="post" name = "frm" action="${contextPath }/admin/modMember.do">
	<table width="80%">
		<tr>
			<td>아이디</td>
			<td><input type="text" value="${member.id }" disabled="disabled">
			<input type="hidden" name="id" value="${member.id }"></td>
			<input type="button" value="중복확인">
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name ="pwd" value="${member.pwd }"></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name ="nickname" value="${member.nickname }"></td>
			<input type="button" value="중복확인">
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" value="${member.birth }" disabled="disabled">
			<input type="hidden" name="birth" value="${member.birth }"></td>
		</tr>
	</table>
<input type="submit" value="수정">
<a href="${contextPath }/admin/listMember.do"><input type="button" value="회원목록"></a>
</form>
</body>
</html>