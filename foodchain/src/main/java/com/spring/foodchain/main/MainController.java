package com.spring.foodchain.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainCotroller")
public class MainController {

@RequestMapping(value="/frontpage/*.do",method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	String viewName = (String)request.getAttribute("viewName");
	ModelAndView mav = new ModelAndView(viewName);
	return mav;
}
}
