package com.spring.foodchain.animal.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.animal.service.AnimalService;
import com.spring.foodchain.animal.vo.RoleVO;

@Controller("animalController")
public class AnimalControllerImpl implements AnimalController {
	@Autowired
	private AnimalService animalService; 
	
	// 동물끼리 rank 비교
	@Override
	public ModelAndView rankComparison(@RequestParam("animal") String animal, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		int role = animalService.rankComparison(animal);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("animal",animal);
		return mav;
	}
	
	// 하늘 진입 가능 여부 
	@Override
	public ResponseEntity skyOk(@RequestParam("animal") String animal, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message;
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		request.getSession();
			boolean result = animalService.skyOk(animal);
			
			if(result) {
				message="<script>alert('하늘 진입 가능');location.href='"+request.getContextPath()+"/room/gameroom.do';</script>";
			}else {
				message="<script>alert('하늘 진입 불가');location.href='"+request.getContextPath()+"/room/gameroom.do';</script>";
			}
			resEnt = new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			return resEnt;
	}
	

}
