package com.spring.foodchain.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.member.VO.MemberVO;

public interface MemberController {
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ModelAndView loginCheck(@ModelAttribute("member") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
