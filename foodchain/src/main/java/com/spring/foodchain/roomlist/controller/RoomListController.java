package com.spring.foodchain.roomlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

import com.spring.controller.service.AddressService;
import com.spring.controller.vo.AddressVO;

@Controller
public class AddressControllerImpl implements AddressController{
	@Autowired
	private AddressService service;
	@Override
	@RequestMapping(value="/address/list.do", method=RequestMethod.GET)
	public ModelAndView listAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = getViewName(request);
		List addressList = service.listAddress();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("addressList", addressList);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/address/*Form.do", method=RequestMethod.GET)
	public ModelAndView formAddress(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		String viewName = getViewName(request);
		AddressVO address = service.viewAddress(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("address", address);
		return mav;
	}

	@Override
	@RequestMapping(value="/address/mod.do", method=RequestMethod.POST)
	public ModelAndView modAddress(@ModelAttribute("address") AddressVO address, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int result = service.modAddress(address);
		
		ModelAndView mav = new ModelAndView("redirect:/address/viewForm.do?id="+address.getId());
		mav.addObject("message", "수정이 완료되었습니다.");
		return mav;
	}

	@Override
	@RequestMapping(value="/address/add.do", method=RequestMethod.POST)
	public ModelAndView addAddress(@ModelAttribute("address") AddressVO address,
			 HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		int result = service.addAddress(address);
		ModelAndView mav = new ModelAndView("redirect:/address/list.do");
		//ModelAndView mav = new ModelAndView("/address/list");
		return mav;
	}

	@Override
	@RequestMapping(value="/address/delete.do", method=RequestMethod.GET)
	public ModelAndView delAddress(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int result = service.delAddress(id);
		
		ModelAndView mav = new ModelAndView("redirect:/address/list.do");
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
		}
		return fileName;
	}

	@Override
	@RequestMapping(value="/address/addForm.do", method=RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}	
}
