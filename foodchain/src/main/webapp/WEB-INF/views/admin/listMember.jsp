<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)회원목록</title>
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
	
</style>
</head>
<body>
<table width="80%">
	<tr>
		<td width="20%">아이디</td>
		<td width="20%">비밀번호</td>
		<td width="30%">가입일자</td>
		<td width="10%">수정</td>
		<td width="10%">삭제</td>
	</tr>
	<c:forEach var="mem" items="${memList}">
		<tr>
			<td><a href="${contextPath}/admin/viewForm.do?id=${mem.id}">${mem.id }</a></td>
			<td>${mem.pwd }</td>
			<td>${mem.joinDate }</td>
			<td><a href="${contextPath }/admin/modForm.do?id=${mem.id }">수정</a></td>
			<td><a href="${contextPath }/admin/delMember.do?id=${mem.id }">삭제</a></td>
		</tr>
	</c:forEach>
</table>

<a href="${contextPath }/admin/addForm.do"><input type="button" value="회원추가"></a>
</body>
</html>