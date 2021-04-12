package com.spring.foodchain.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value="/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List memList = aservice.listMembers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("memList", memList);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/addMembers.do", method=RequestMethod.POST)
	public ModelAndView addMembers(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = aservice.addMembers(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/delMembers.do", method=RequestMethod.GET)
	public ModelAndView delMembers(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = aservice.delMembers(id);
		ModelAndView mav = new ModelAndView("redirect:/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/modMember.do", method=RequestMethod.POST)
	public ModelAndView modMembers(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = aservice.modMembers(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/listMembers.do");
		mav.addObject("message","수정이 완료되었습니다.");
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
