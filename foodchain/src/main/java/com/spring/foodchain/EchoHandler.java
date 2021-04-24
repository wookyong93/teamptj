package com.spring.foodchain;

import java.util.HashSet;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.spring.foodchain.member.VO.MemberVO;
import com.spring.foodchain.member.controller.MemberController;
import com.spring.foodchain.member.service.MemberService;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler{
	private HashSet<WebSocketSession> sessionList1 = new HashSet<WebSocketSession>();
	private HashSet<WebSocketSession> sessionList2 = new HashSet<WebSocketSession>();
	private HashSet<WebSocketSession> sessionList3 = new HashSet<WebSocketSession>();
	private HashSet<WebSocketSession> sessionList4 = new HashSet<WebSocketSession>();
	private HashSet<WebSocketSession> sessionList5 = new HashSet<WebSocketSession>();
	
	
	//닉네임받아올 클레스 (수정필요)
	private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	//닉네임 설정(수정필요)
	
	
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessionList1.add(session);
		logger.info("{}연결됨",session);
	}
	  @Override
	   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	      // TODO Auto-generated method stub
		  
	      logger.info("{}로 부터 {}받음",session.getId(), message.getPayload());
	      //모든 유저에게 메세지 출력 session.getId 자리에 닉네임 입력 예정
	      
	      
	      
	      String str = message.getPayload();
	      String[] chatSelect = str.split("`");
	      
	      
	      logger.info("{} : {}",chatSelect[0], chatSelect[1]);
	      
	      if(chatSelect[0].equals("all")) {
	         
	         sessionList1.add(session);
	         for(WebSocketSession sess : sessionList1) {   
	            sess.sendMessage(new TextMessage(chatSelect[1]));

	         }
	      } else if (chatSelect[0].equals("late")) {
	         sessionList1.remove(session);
	         sessionList2.add(session);
	         for(WebSocketSession sess : sessionList2) {
	            sess.sendMessage(new TextMessage(chatSelect[1]));

	         }
	      }else if (chatSelect[0].equals("sky")) {
	    	  	 sessionList1.remove(session);
		         sessionList2.remove(session);
		         sessionList3.add(session);
		         for(WebSocketSession sess : sessionList3) {
		            sess.sendMessage(new TextMessage(chatSelect[1]));

		         }
		  }else if (chatSelect[0].equals("field")) {
			     sessionList2.remove(session);
		         sessionList3.remove(session);
		         sessionList4.add(session);
		         for(WebSocketSession sess : sessionList4) {
		            sess.sendMessage(new TextMessage(chatSelect[1]));

		         }
		  }else if (chatSelect[0].equals("forest")) {
			  	 sessionList2.remove(session);
		         sessionList3.remove(session);
		         sessionList4.remove(session);
		         sessionList5.add(session);
		         for(WebSocketSession sess : sessionList5) {
		            sess.sendMessage(new TextMessage(chatSelect[1]));

		         }
		  }
	      
	   }
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		sessionList1.remove(session);
		HttpSession session_ = request.getSession();
		logger.info("{}연결 끊김",session_.getAttribute("id"));
		session_.removeAttribute("id");
	}
	
	
}
