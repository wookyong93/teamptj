package com.spring.foodchain.place.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.place.service.PlaceService;

// 210420 강민경 작성중
@Controller("placeController")
public class PlaceControllerImpl implements PlaceController{
	@Autowired
	private PlaceService placeService;
	@Override
	public ModelAndView placeRule(@RequestParam("place")String place, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		return null;
		
	}
}
