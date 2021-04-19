package com.spring.foodchain.animal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.foodchain.animal.service.AnimalService;

@Controller("animalController")
public class AnimalControllerImpl implements AnimalController {
	@Autowired
	private AnimalService animalS;
	
	@Override
	public ResponseEntity rankComparison(@RequestParam("animal") String animal, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public ResponseEntity sky_ok(@RequestParam("sky_ok") int sky_ok, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
