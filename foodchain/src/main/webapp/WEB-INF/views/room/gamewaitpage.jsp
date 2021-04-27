<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="loginId" value="${loginId}"/>
<%
   request.setCharacterEncoding("UTF-8");
   String loginID = request.getParameter("id");
   session.setAttribute("loginID", loginID);
   
   String title = request.getParameter("title");
   session.setAttribute("title", title);
   
   String roomNum = request.getParameter("roomNum");
   session.setAttribute("roomNum", roomNum);
   
   String chief_id = request.getParameter("chief_id");
   session.setAttribute("chief_id", chief_id);
   
      String nickName = (String)session.getAttribute("nickName");
   HashSet<String> joinMember = new HashSet<String>();
   joinMember.add(nickName);
   session.setAttribute("joinMember", joinMember);
%>
<<<<<<< HEAD

=======
	
<!-- 방 이동시 마이페이지 id 안보내지는 오류 수정 - 이소정 -->
>>>>>>> branch 'master' of https://github.com/wookyong93/teamptj
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 생성</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<style>
   .text_center{
     text-align:center;
   }
body{
   width:80%;
   margin:auto;
   background-color: #d3d3d3;
   }
.logo{
   float:left;
   }
.btn1{
   border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; width:100px; height:40px;
   }
.btn2{
   border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; float: right; margin: 5px; display: block; width:100px; height:40px;
   }
.tab1{
   border:1px solid white;
   position:absolute;
   top:28%;
   left:8%;
   display: block;
}

.tab2{
   border-bottom: 1px solid black;
}

.ul1{
position:absolute;
font-size:18px;
font-weight:bold;
top:20%;
left:50%;
list-style-type: none;
margin: -25px 35px 35px -195px;
padding: 5px;
background-color: white;
text-align:center;
display: block;
}
.ul2{
position:absolute;
font-size:15px;
top:20%;
left:50%;
list-style-type: none;
margin: 5px 35px 35px -195px;
padding: 5px;
background-color: white;
text-align:center;
display: block;
}
li{   
   width:75px;
   left:50%;
   float:left;
   border-right:1px solid black;
   padding: 0 10px 0 10px;
}
li:last-child {
   border-right: none;
}
form{
position:absolute;
left:27%;
top:27%;
}
</style>

<script type="text/javascript">
   function popup(){
      var url = "${contextPath}/room/popup.do";
      var name = "popup pop";
      var option = "width = 750, height = 450, left=1250, location = no"
      window.open(url,name,option);   
   }
</script>
</head>
<body>

<header>
   <div>
   <img class="logo" src="${contextPath}/resources/image/logo.jpg" width="100" height="100" >
   <h1 class="text_center">먹이사슬 게임</h1>
   </div>
</header>




   <input type="button" value="마이페이지" class="btn2" onclick="location.href='${contextPath}/mypage/mypageView.do?id=<%=loginID%>'">
   <input type="button" value="로그아웃" class="btn2" onclick="location.href='${contextPath}/login/login.do'">

   <ul class="ul1">
   <li>번호</li>
   <li>방제목</li>
   <li>방장</li>
   <li>인원수</li>
   <li>게임상태</li>
   </ul>
   <ul class="ul2">
   <li>${roomNum }</li>
   <li>${title }</li>
   <li>${chief_id }</li>
   <li>2/13</li>
   <li>대기중</li>
   </ul>
   
   <table class="tab1">   
      <tr style="background-color: white;">
         <td width="200"><p align="center">접속자</td>
       </tr>
       <c:forEach var="chief_id" items="${joinMember}">
          <tr class="tab2">
            <td width="200"><p align="center"><c:out value="${chief_id }"></c:out></td>
         </tr>
      </c:forEach>
   </table>
   
   
   <form>
   <textarea id="messageArea" style="width:500px; resize: none; height: 380px; display: block;"readonly="readonly"></textarea>
   <input type="text" id="message" style="background-color: white; width: 380px; height:30px; margin: 0px;">
   <input type="button" id="sendBtn" value="채팅" style="border-color:#CCFFCC; background-color: #CCFFCC; width: 120px; height: 40px;">
   <br>
   <input type="button" value="준비/시작" class="btn1" id="commitchk" onclick="location.href='${contextPath}/room/gameplaypage.do'">
   <input type="button" value="나가기" class="btn1" onclick="location.href='${contextPath}/room/roomlistmain.do?id=<%=loginID%>'">
   <input type="button" value="설명" class="btn1" onclick="location.href='javascript:popup()'">
   
   </form>
	<ul class="ul1">
	<li>번호</li>
	<li>방제목</li>
	<li>방장</li>
	<li>인원수</li>
	<li>게임상태</li>
	</ul>
	<ul class="ul2">
	<li>${roomNum }</li>
	<li>${title }</li>
	<li>${chief_id }</li>
	<li>2/13</li>
	<li>대기중</li>
	</ul>
	
	<table class="tab1">	
		<tr style="background-color: white;">
	      <td width="200"><p align="center">접속자</td>
	    </tr>
	    
	    <tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr> 
	</table>
	
	<form>
	<textarea id="messageArea" style="width:500px; resize: none; height: 380px; display: block;"readonly="readonly"></textarea>
	<input type="text" id="message" style="background-color: white; width: 380px; height:30px; margin: 0px;">
	<input type="button" id="sendBtn" value="채팅" style="border-color:#CCFFCC; background-color: #CCFFCC; width: 120px; height: 40px;">
	<br>
	<input type="button" value="준비/시작" class="btn1" id="commitchk" onclick="location.href='${contextPath}/room/gameplaypage.do'">
	<input type="button" value="나가기" class="btn1" onclick="location.href='${contextPath}/room/roomlistmain.do?id=<%=loginID%>'">
	<input type="button" value="설명" class="btn1" onclick="location.href='javascript:popup()'">
	
	</form>
	
</body>
<script type="text/javascript">
   var select = 'all`';
   var nick = "${nickName}";
   $("#sendBtn").click(function() {
      allSendMessage();
      $('#message').val('')
   });

   let sock = new SockJS("http://localhost:8090/foodchain/echo");
   //서버에 연결할 자신의 url 주소 작성 
   sock.onmessage = onMessage;
   sock.onclose = onClose;
   // 메시지 전송
   function allSendMessage() {
       
      sock.send(select + $("#message").val());
   }
   // 서버로부터 메시지를 받았을 때 
   function onMessage(msg) {
      var data = msg.data;
      $("#messageArea").append(nick+" : "+data + "\r\n");
   }
   // 서버와 연결을 끊었을 때
   function onClose(evt) {
      $("#messageArea").append("연결 끊김\r\n");

   } 
   
   $("#late").click(function(){
      select = 'late`';
      sock.send(select +  nick + "님이 강에 입장하셨습니다.");
   })
   
   $("#sky").click(function(){
      $("#messageArea").append("하늘로 이동\r\n");
      select = 'sky`';
      sock.send(select + nick +"님이 강에 입장하셨습니다.");
   })
   
   $("#field").click(function(){
      $("#messageArea").append("들로 이동\r\n");
      select = 'field`';
      sock.send(select +  nick +"님이 강에 입장하셨습니다.");
   }) 
   $("#forest").click(function(){
         $("#messageArea").append("숲으로 이동\r\n");
         select = 'forest`';
    sock.send(select + nick +"님이 강에 입장하셨습니다.");
   })
   
</script>
</html>