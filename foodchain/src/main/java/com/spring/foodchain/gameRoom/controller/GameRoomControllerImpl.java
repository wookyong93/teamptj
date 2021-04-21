package com.spring.foodchain.gameRoom.controller;

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
   @Override
   // 210421 강민경 작성
   @RequestMapping(value = "/room/gameplaypage.do", method= {RequestMethod.GET,RequestMethod.POST})
   public ModelAndView gameplaypage(HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      String viewName =(String)request.getAttribute("viewName");
      ModelAndView mav = new ModelAndView(viewName);
      return mav;
      
   }
   
   @Override
   public ModelAndView placeRule(@RequestParam("place")String place, HttpServletRequest request, HttpServletResponse response)throws Exception{
      
      return null;
      
   }
}