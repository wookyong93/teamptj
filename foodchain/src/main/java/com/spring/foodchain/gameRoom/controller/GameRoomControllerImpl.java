package com.spring.foodchain.gameRoom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.gameRoom.service.GameRoomService;


@Controller("gameRoomController")
public class GameRoomControllerImpl implements GameRoomController{
	@Autowired
	private GameRoomService gameRoomService;
	@Override
	public ModelAndView placeRule(@RequestParam("place")String place, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		return null;
		
	}
}
