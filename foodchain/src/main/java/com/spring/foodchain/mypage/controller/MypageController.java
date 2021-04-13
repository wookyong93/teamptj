package com.spring.foodchain.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.member.VO.MemberVO;



public interface MypageController {
	public ModelAndView mypageView(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyMypage(@ModelAttribute("mypage") MemberVO memberVO,HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ResponseEntity nameCheck(@RequestParam("nickname") String nickName,HttpServletRequest request,HttpServletResponse response) throws Exception;
}
