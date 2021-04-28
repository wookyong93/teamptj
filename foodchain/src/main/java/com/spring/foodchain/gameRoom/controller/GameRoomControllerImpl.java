package com.spring.foodchain.gameRoom.controller;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.gameRoom.service.GameRoomService;

@Repository
@Controller("gameRoomController")
public class GameRoomControllerImpl implements GameRoomController{
   @Autowired
   private GameRoomService gameRoomService;
   private HashMap<Integer, HashMap> gameMember = new HashMap<Integer, HashMap>();
   // 고정된 동물 값
   private String[] roleChar = new String[]{ "사자", "악어", "독수리", "하이에나", "뱀", "카멜레온", "사슴", "수달", "토끼", "청둥오리","까마귀", "악어새", "쥐"};
   
   @Override
   // 210421 강민경 작성 /랜덤 동물 배정
   @RequestMapping(value = "/room/gameplaypage.do", method= {RequestMethod.GET,RequestMethod.POST})
   public ModelAndView gameplaypage(HttpServletRequest request, HttpServletResponse response)
         throws Exception {
	   //로그인 아이디
     String loginID = request.getParameter("id");
     System.out.println(loginID);
     // 방번호 
     Integer roomNum = Integer.parseInt(request.getParameter("roomNum"));
     
     // gameChar 는 각 방의 전체 캐릭터 집합 
     // gameMember 는 전체 방의 번호로 호출 하면 그 방의 전체 캐릭터를 가진 map 이 나옴
     // 그게 gameChar
     HashMap<String, String> gameChar = gameMember.get(roomNum);
     
     // gameChar가 없다는건 지금 시작해서 없을 때 
     if(gameChar == null) {
    	 // map 객체 생성 한것
        gameChar = new HashMap<String, String>();
     }
     
     // 랜덤 만들기
     Random rand = new Random();
     String c = null;
     if (gameChar.size() != 13) {
        who:while(true) {
        	// 랜덤값 받고
           int result = rand.nextInt(13);
           // 랜덤값을 인덱스로 roleChar에서 선택
           c = roleChar[result];
           
           // 만일 이미 배정 된 역할이면 다시 반복하고 
           if(gameChar.get(c) == null) {//없을 때는
        	   // 캐릭터가 같지 않다고 하더라도 같은 아이디가 계속 다른 값을 받으면 안되니까
        	  for(String t : roleChar) {
        		  String test = gameChar.get(t);
        		  
        		  if(test != null) {
	        		  if(test.equals(loginID)) {
	        			  System.out.println(c);
	        			  c = t;
	        			  break who;
	        		  }
        		  }
        	  }
        	   // 동물 이름으로 검색하면 아이디가 나옴 그리고 반복 중지
              gameChar.put(c, loginID);
              break;
           } 
        }
     }
     //그 방의 번호에 해당하는 그방 전체 동물 저장
     gameMember.put(roomNum, gameChar);
     
      String viewName =(String)request.getAttribute("viewName");
      ModelAndView mav = new ModelAndView(viewName);
      // 여기로 와서 캐릭터를 배정 받은 사람은 roleChar 라는 이름으로 역할 전달
      mav.addObject("roleChar", c);
      return mav;
      
   }
   
   @Override
   public ModelAndView placeRule(@RequestParam("place")String place, HttpServletRequest request, HttpServletResponse response)throws Exception{
      
      return null;
      
   }
}