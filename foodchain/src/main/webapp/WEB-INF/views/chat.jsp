<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

</head>
<body>
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/>
	<input type="button" id="late" value="강"/>
	<input type="button" id="sky" value="하늘"/>
	<input type="button" id="field" value="들"/>
	<input type="button" id="forest" value="숲"/>
	<textarea id="messageArea"></textarea>
</body>
<script type="text/javascript">
   var select = 'all`';
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
      $("#messageArea").append(data + "\r\n");
   }
   // 서버와 연결을 끊었을 때
   function onClose(evt) {
      $("#messageArea").append("연결 끊김\r\n");

   }
   
   $("#late").click(function(){
      select = 'late`';
      sock.send(select + "aaa님이 강에 입장하셨습니다.");
   })
   
   $("#sky").click(function(){
      $("#messageArea").append("하늘로 이동\r\n");
      select = 'sky`';
      sock.send(select + "aaa님이 강에 입장하셨습니다.");
   })
   
   $("#field").click(function(){
      $("#messageArea").append("들로 이동\r\n");
      select = 'field`';
      sock.send(select + "aaa님이 강에 입장하셨습니다.");
   }) 
   $("#forest").click(function(){
	      $("#messageArea").append("숲으로 이동\r\n");
	      select = 'forest`';
	 sock.send(select + "aaa님이 강에 입장하셨습니다.");
	})
   
</script>
</html>