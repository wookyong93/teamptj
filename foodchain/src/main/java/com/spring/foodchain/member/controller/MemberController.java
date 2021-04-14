package com.spring.foodchain.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.member.VO.MemberVO;

public interface MemberController {
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ResponseEntity loginCheck(@ModelAttribute("member") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView joinForm(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ResponseEntity idCheck(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ResponseEntity addMember(@ModelAttribute("member") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity nameCheck(@RequestParam("nickname") String nickName,HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
