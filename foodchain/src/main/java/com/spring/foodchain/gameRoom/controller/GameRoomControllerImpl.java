package com.spring.foodchain.gameRoom.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.gameRoom.service.GameRoomService;
import com.spring.foodchain.roomlist.controller.RoomListController;


@Repository
@Controller("gameRoomController")
public class GameRoomControllerImpl implements GameRoomController{
   @Autowired
   private GameRoomService gameRoomService;
   @Autowired
   private RoomListController roomListController;
   private HashMap<Integer, HashMap> gameMember = new HashMap<Integer, HashMap>();
   private HashMap<Integer, HashMap> location = new HashMap<Integer, HashMap>();
   private String[] roleChar = new String[]{ "사자", "악어", "독수리", "하이에나", "뱀", "카멜레온", "사슴", "수달", "토끼", "청둥오리","까마귀", "악어새", "쥐"};
   private String time = null;
   private HashSet<String> lateLocation = new HashSet<String>();
   private HashSet<String> skyLocation = new HashSet<String>();
   private HashSet<String> forestLocation = new HashSet<String>();
   private HashSet<String> fieldLocation = new HashSet<String>();
   @Override
   // 210421 강민경 작성
   @RequestMapping(value = "/room/gameplaypage.do", method= {RequestMethod.GET,RequestMethod.POST})
   public ModelAndView gameplaypage(HttpServletRequest request, HttpServletResponse response)
         throws Exception {
	  HttpSession session = request.getSession(false);
	  String loginID = request.getParameter("id");
	  Integer roomNum = Integer.parseInt(request.getParameter("roomNum"));
	  	  
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  
	  if (gameMember.get(roomNum) == null) {
		  time = format.format(System.currentTimeMillis());
	  }
	  
	  String field = request.getParameter("field");
	  String nickName = request.getParameter("nickName");
	  String nowChar = request.getParameter("roleChar");
	  String c = randChar(roomNum, loginID);

	  String viewName =(String)request.getAttribute("viewName");
      ModelAndView mav = new ModelAndView(viewName);
      
	  if(field != null) {
		  if(field.equals("late")) {
			  System.out.println("강 입장");
			  lateLocation.add(nickName);
			  
			  skyLocation.remove(nickName);
			  forestLocation.remove(nickName);
			  fieldLocation.remove(nickName);
			  
			  session.setAttribute("location", "강");
			  session.setAttribute("list", lateLocation);	
		  } else if (field.equals("sky")){
			  System.out.println("하늘 입장");
			  skyLocation.add(nickName);
			  
			  lateLocation.remove(nickName);
			  forestLocation.remove(nickName);
			  fieldLocation.remove(nickName);
			  
			  session.setAttribute("location", "하늘");
			  session.setAttribute("list", skyLocation);
		  } else if (field.equals("forest")) {
			  System.out.println("숲 입장");
			  forestLocation.add(nickName);
			  
			  skyLocation.remove(nickName);
			  lateLocation.remove(nickName);
			  fieldLocation.remove(nickName);
			  
			  session.setAttribute("location", "숲");
			  session.setAttribute("list", forestLocation);
		  } else if (field.equals("field")) {
			  System.out.println("들 입장");
			  fieldLocation.add(nickName);
			  
			  skyLocation.remove(nickName);
			  forestLocation.remove(nickName);
			  lateLocation.remove(nickName);
			  
			  session.setAttribute("location", "들");
			  session.setAttribute("list", fieldLocation);
		  }
	  }
      
      mav.addObject("time", time);
      mav.addObject("roleChar", c);
      
      return mav;
   }
   
   @Override
   public ModelAndView placeRule(HttpServletRequest request, HttpServletResponse response)throws Exception{
      
      return null;
      
   }
   
   public String randChar(int roomNum, String loginID) {
	  HashMap<String, String> gameChar = gameMember.get(roomNum);
	  if(gameChar == null) {
		  gameChar = new HashMap<String, String>();
	  }
	  Random rand = new Random();
	  String c = null;
	  if (gameChar.size() != 13) {
		 who:while(true) {
			  int result = rand.nextInt(13);
			  c = roleChar[result];
			  
			  if(gameChar.get(c) == null) {
				  for(String t : roleChar) {
					  
					  String test = gameChar.get(t);
				  
					  if(test != null) {
						  if(test.equals(loginID)) {
							  
							  c = t;
							  break who;
						  }
					  } 
				  }
				  gameChar.put(c, loginID);
				  break;
			  }
			  
		  }
	  }
	  gameMember.put(roomNum, gameChar);
	  return c;
   }
   
   @Override
	public HashMap getRoomRole(int roomNum) {
		// TODO Auto-generated method stub
		HashMap<String, String> gameChar = gameMember.get(roomNum);
		return gameChar;
	}
}