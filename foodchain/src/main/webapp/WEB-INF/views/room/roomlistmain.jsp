<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" import="java.util.*"   %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
	
	String loginID = (String)session.getAttribute("loginID");
	if(loginID ==null){
		loginID = request.getParameter("id");
		session.setAttribute("loginID", loginID);
	}
	
    String nickName = (String)session.getAttribute("nickName");
 	HashSet<String> joinMember = new HashSet<String>();
	joinMember.add(nickName);
 	session.setAttribute("joinMember", joinMember);
%>    

<!-- 방 이동시 마이페이지 id 안보내지는 오류 수정 - 이소정 -->
<html>
<head>
<meta charset="UTF-8">
<title>방 목록</title>
<style>
body{
	width:80%;
	margin:auto;
	background-color: #d3d3d3;
	}
.text_center{
	text-align: center;
}
.logo{
	float:left;
	}
.btn1{
	border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; margin: 5px; 
   }
.btn2{
	border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; float: right; margin: 5px; 
   }
.table1{
	margin-top: 25px; position: relative;
}
</style>
</head>
<body>
	<header>
		<div>
			<img class="logo" src="${contextPath}/resources/image/logo.jpg" width="100" height="100" >
			<h1 class="text_center">먹이사슬 게임</h1>
		</div>
	</header>
	
	<div>
		<input type="button" value="방 만들기" class="btn1" onclick="location.href='${contextPath}/room/createroom.do?id=<%=loginID%>'">
		<input type="button" value="마이페이지" class="btn2" onclick="location.href='${contextPath}/mypage/mypageView.do?id=<%=loginID%>'">
		<input type="button" value="로그아웃" class="btn2" onclick="location.href='${contextPath}/login/login.do'">
	</div>

<table border="1"  align="center" width="80%">
    <tr align="center"   bgcolor="#CCFFCC">
      <td style="width: 15%;"><b>상태</b></td>
      <td style="width: 10%;"><b>방 번호</b></td>
      <td><b>방 제목</b></td>
      <td style="width: 15%;"><b>인원</b></td>
      <td style="width: 15%;"><b>방장</b></td>
   </tr>

 <c:forEach var="room" items="${roomList}" >     
   <tr align="center">
      <td>대기중</td>
      <td>${room.roomNum}</td>
      <td><a href="${contextPath}/room/gamewaitpage.do?roomNum=${room.roomNum}&&title=${room.title}&&chief_id=${room.chief_id}&&id=${loginID}">${room.title}</a></td>
      <td>${joinCount}/13</td>
      <td>${room.chief_id}</td>
   </tr>
  </c:forEach>   
</table>
</body>
</html>
