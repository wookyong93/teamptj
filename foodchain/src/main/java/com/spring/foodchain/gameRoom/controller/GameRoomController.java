package com.spring.foodchain.gameRoom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface GameRoomController {

   public ModelAndView placeRule(@RequestParam("place") String place, HttpServletRequest request, HttpServletResponse response) throws Exception;

   public ModelAndView gameplaypage(HttpServletRequest request, HttpServletResponse response) throws Exception;

}