package com.spring.foodchain.animal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface AnimalController {
	public ResponseEntity rankComparison(@RequestParam("animal") String animal, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity sky_ok(@RequestParam ("sky_ok") int sky_ok, HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
