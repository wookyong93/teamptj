package com.spring.foodchain.place.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface PlaceController {

	public ModelAndView placeRule(@RequestParam("place") String place, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
