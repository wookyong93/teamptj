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

import com.spring.foodchain.roomlist.service.RoomListService;
import com.spring.foodchain.roomlist.vo.RoomListVO;

@Controller("roomlistController")
public class RoomListControllerImpl implements RoomListController{
	@Autowired
	private RoomListService roomlistSrv;
	@Autowired
	private RoomListVO roomlistVO;
	
	@Override
	@RequestMapping(value="/room/roomlistmain.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomlist(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = getViewName(request);
		List roomList = roomlistSrv.roomsList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("roomList",roomList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/room/addroom.do" ,method = RequestMethod.POST)
	public ModelAndView addRoom(@ModelAttribute("room") RoomListVO room,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("add ½ÇÇà");
		System.out.println(room.getTitle());
		int result = 0;
		result = roomlistSrv.addRoom(room);
		System.out.println(room.getChief_id()+room.getRoomNum()+room.getTitle());
		ModelAndView mav = new ModelAndView("redirect:/room/roomlistmain.do");
		return mav;
	}
	
	@RequestMapping(value = "/room/createroom.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) {
		// TODO Auto-generated method stub
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

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

	}
