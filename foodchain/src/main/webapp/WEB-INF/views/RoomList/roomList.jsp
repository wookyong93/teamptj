<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>방 목록</title>
</head>
<body>
<input type="button" value="방 만들기" onclick="location.href='${contextPath}/room/roomlistmain.do'">
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>상태</b></td>
      <td><b>방 번호</b></td>
      <td><b>방 제목</b></td>
      <td><b>인원</b></td>
      <td><b>방장</b></td>
   </tr>
   
 <c:forEach var="room" items="${roomList}" >     
   <tr align="center">
      <td>${room.state}</td>
      <td>${room.num}</td>
      <td>${room.title}</td>
      <td>${room.size}</td>
      <td>${room.master}</td>
   </tr>
  </c:forEach>   
</table>
</body>
</html>
