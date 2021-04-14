package com.spring.foodchain.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.admin.service.AdminServiceImpl;
import com.spring.foodchain.member.VO.MemberVO;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {
	@Autowired
	private AdminServiceImpl aservice;
	
	@Override
	@RequestMapping(value="/listMember.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List memList = aservice.listMembers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("memList", memList);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/addMember.do", method=RequestMethod.POST)
	public ResponseEntity addMembers(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponseEntity resEnt=null; 
		HttpHeaders responseHeaders = new HttpHeaders();
		String message;
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		request.getSession();
			boolean result = aservice.addMembers(memberVO);
			if(result) {
				message="<script>alert('가입성공');location.href='"+request.getContextPath()+"/login/login.do';</script>";
			}else {
				message="<script>alert('가입실패');location.href='"+request.getContextPath()+"/login/login.do';</script>";
			}
			resEnt = new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			return resEnt;
	}

	@Override
	@RequestMapping(value="/delMember.do", method=RequestMethod.GET)
	public ModelAndView delMembers(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = aservice.delMembers(id);
		ModelAndView mav = new ModelAndView("redirect:/admin/listMember.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/modMember.do", method=RequestMethod.POST)
	public ModelAndView modMembers(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getBirth());
		aservice.modMembers(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/admin/listMember.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		MemberVO member = aservice.viewMembers(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member",member);
		return mav;
	}

	@Override
	@RequestMapping(value="/addForm.do", method=RequestMethod.GET)
	public ModelAndView addform(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	

}
