<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
   String loginID = request.getParameter("id");
   session.setAttribute("loginID", loginID);
   String roleChar = request.getParameter("roleChar");
   session.setAttribute("roleChar", roleChar);
   String roomNum = request.getParameter("roomNum");
   session.setAttribute("roomNum", roomNum);
%>
<!-- 재헌님 작성/ 210421 강민경 수정 중 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 생성</title>
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

.place{
   float: right;
}
form{
position:absolute;
left:27%;
top:27%;
}

</style>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
    var roleAttack = null;
    var gameDate = new Date('${time}');
    var gameSec = gameDate.getSeconds();
    var nowDate = new Date();
    var nowSec = nowDate.getSeconds();
    var startSec = nowSec < gameSec ? 60 - ((nowSec+60)-gameSec) : 60 - (nowSec - gameSec);
    	
	setInterval(function(){
		$("#reload").load(window.location.href + " #reload");
 		
 		if(startSec%10 == 0){
 			readySendMessage("SYSTEM`SYSTEM : 이동까지 " + startSec + " 초 남았습니다.");
		}
		startSec = startSec - 1;
		if(startSec== -10){
			var roleChar = '${roleChar}';
			startSec = 30;
			$("#late").removeAttr("disabled");
			if(roleChar == '독수리' || roleChar == '청둥오리' || roleChar == '까마귀' || roleChar == '악어새'){
				$("#sky").removeAttr("disabled");
			}
			$("#forest").removeAttr("disabled");
			$("#field").removeAttr("disabled");
		} 
	},1000);
	$(function(){
		var roleChar = '${roleChar}';
		
		if(roleChar == '독수리' || roleChar == '청둥오리' || roleChar == '까마귀' || roleChar == '악어새'){
			$("#sky").removeAttr("disabled");
		}
	});
   function popup(){
      var url = "${contextPath}/room/popup.do";
      var name = "popup pop";
      var option = "width = 750, height = 450, left=1250, location = no"
      window.open(url,name,option);   
   }
   function selectChar(roleAtt){
	   roleAttack = roleAtt;
   }
   function attack(){
	   var roomNum =  '${roomNum}';
	   var roleChar = '${roleChar}';
	   var title = '${title }';
		$.ajax ({
			url:'${contextPath}/animal/attack.do',
			data:{ roomNum : roomNum, roleChar: roleChar ,  title : title, roleAttack:roleAttack },
			type:'post',
			success:function(result,status){
 				if(result==0) {
					alert('공격 성공 !!');
				} else if(result==1){
					alert('공격 실패T^T');
				} else if(result==2){
					alert('공격 실패 .. 뱀에게 죽임을 당했습니다');
				} 
			}
		});
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



   <input type="button" value="마이페이지" class="btn2" onclick="location.href='${contextPath}/mypage/mypageView.do?id=${loginID}'">
   <input type="button" value="로그아웃" class="btn2" onclick="location.href='${contextPath}/login/login.do'">

   <div id="reload">
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
   <li>${joinCount }/13</li>
   <li>게임시작</li>
   </ul>
   
   <table class="tab1">   
      <tr style="background-color: white;">
         <td width="200"><p align="center">접속자</td>
       </tr>
       <c:forEach var="join_Id" items="${joinId }">
       	<tr class="tab2">
        	 <td width="200"><p align="center">${join_Id }</p></td>
      	</tr>
      </c:forEach>
   </table>
   <table>
   	<tr>
   		<th>
   			${location }
   		</th>
   		<c:forEach var = "member" items="${list }">
   			<td  onclick="selectChar('${member}')">${member }</td>
   		</c:forEach>
   	</tr>
   </table>
   </div>
   ${roleChar }
   
   <form>
    <textarea id="messageArea" style="width:500px; resize: none; height: 380px; display: block;"readonly="readonly"></textarea>
	<input type="text" id="message" style="background-color: white; width: 380px; height:30px; margin: 0px;">
	<input type="button" id="sendBtn" value="채팅" style="border-color:#CCFFCC; background-color: #CCFFCC; width: 120px; height: 40px;">
	<br>
   
   
   <input type="button" value="설명" class="btn1" onclick="location.href='javascript:popup()'"> <br><br>
   <input type="button" value="공격" class="btn1" onclick="attack()">&nbsp;&nbsp;
   <input type="button" value="엿보기" class="btn1">
   <div class="place">
   <input type="button" value=" 강 " class="btn1" id="late" name="river">&nbsp;&nbsp;
   <input type="button" value=" 들 " class="btn1" id="field" name="field"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="button" value="나가기" class="btn1" onclick="location.href='${contextPath}/room/roomlistmain.do?roomNum=${roomNum }'"><br><br>
   <input type="button" value="하늘" class="btn1" id="sky" name="sky" disabled="disabled">&nbsp;&nbsp;
   <input type="button" value=" 숲 " class="btn1" id="forest" name="forest">
   
   </div>
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
       
      sock.send(select + nick + " : " + $("#message").val());
   }
   
   function readySendMessage(str) {
       
	   sock.send(str);
	}
   // 서버로부터 메시지를 받았을 때 
   function onMessage(msg) {
      var data = msg.data;
      $("#messageArea").append(data + "\r\n");
   }
   // 서버와 연결을 끊었을 때
   function onClose(evt) {
      $("#messageArea").append("연결 끊김\r\n");

   } 
   
   $("#late").click(function(){
	   $("#messageArea").append("강으로 이동\r\n");
      select = 'late`';
      sock.send(select +  nick + "님이 강에 입장하셨습니다.");
      moveField("late");
   })
   $("#sky").click(function(){
      $("#messageArea").append("하늘로 이동\r\n");
      select = 'sky`';
      sock.send(select + nick +"님이 강에 입장하셨습니다.");
      moveField("sky");
   })
   $("#field").click(function(){
      $("#messageArea").append("들로 이동\r\n");
      select = 'field`';
      sock.send(select +  nick +"님이 강에 입장하셨습니다.");
      moveField("field");
   }) 
   $("#forest").click(function(){
	  $("#messageArea").append("숲으로 이동\r\n");
	  select = 'forest`';
	  sock.send(select + nick +"님이 강에 입장하셨습니다.");
	  moveField("forest");
   })
   
   function moveField(moveF){
	   
	   var roomNum = '${roomNum }';
	   var roleChar = '${roleChar }';
	 $.ajax ({
	   url:'${contextPath}/room/gameplaypage.do',
		data:{ roomNum : roomNum, roleChar: roleChar , nickName : nick, field : moveF },
		type:'post',
		success:function(result,status){
			$("#late").attr("disabled", true);
			$("#sky").attr("disabled", true);
			$("#forest").attr("disabled", true);
			$("#field").attr("disabled", true);
		}
	 });
   }
</script>
</html>