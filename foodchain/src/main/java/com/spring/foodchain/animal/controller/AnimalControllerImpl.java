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
	public ResponseEntity rankComparison(@RequestParam("animal") String animal, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponseEntity resEnt;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message = null;
		responseHeaders.add("Content-Type","text/html; charset=utf-8");
		String id = request.getParameter("id");
		try {
			int result = animalService.rankComparison(animal);
			if(result==0) {
				message = "<script>alert('공격 성공 !!');location.href='"+request.getContextPath()+"/room/gameroompage';</script>";
			} else if(result==1){
				message = "<script>alert('공격 실패T^T');location.href='"+request.getContextPath()+"/room/gameroompage';</script>";
			} else if(result==2){
				message = "<script>alert('공격 실패 .. 뱀에게 죽임을 당했습니다');location.href='"+request.getContextPath()+"/room/gameroompage';</script>";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEnt;
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
