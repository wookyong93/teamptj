<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<style>
   body{
   	  background-color:d3d3d3;
   }
   #title {
      width:60%;
      margin: 0 auto;

   }
   #main {
      margin:0 auto ;
   }
   a{
      color:black;
   }
   a:link {
      color:black;
   }
   a:visited {
      color:black;
      font-weight:bold;
   }
   input[type=button]{
   	background-color:#CCFFCC;
   	width:100px;
   	height:40px;
   }
</style>
</head>
<body>
   <table id="title">
      <tr>
         <td><img src="${contextPath}/resources/image/logo.jpg" width="100px">
         <td ><h1><br>먹이사슬 게임</h1></td>
      </tr>
   </table>
      
      <table id="main" align="center" width="100%">
         <tr align="center">
            <td>
                <img src="${contextPath}/resources/image/rule.png" width="700" height="400">
             </td>
          </tr>
          <tr align="center">
             <td><a href="${contextPath}/frontpage/main1.do">[1]</a>
             <a href="${contextPath}/frontpage/main2.do">[2]</a></td>
          </tr>
          <tr align="center">
             <td>
                <input type="button" value="로그인" onclick="location.href='${contextPath}/login/login.do'">
                <input type="button" value="회원가입" onclick="location.href='${contextPath}/join/join.do'">
             </td>
          </tr>
      </table>
    
</body>
</html>