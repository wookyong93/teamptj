package com.spring.foodchain.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.mypage.VO.MypageVO;



public interface MypageController {
	public ModelAndView mypageView(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyAddress(@ModelAttribute("pwd") MypageVO mypageVO,HttpServletRequest request,HttpServletResponse response) throws Exception;
}
