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

import com.spring.foodchain.member.VO.MemberVO;
import com.spring.foodchain.roomlist.service.RoomListService;

@Controller("roomlistController")
public class RoomListControllerImpl implements RoomListController{
	@Autowired
	private RoomListService roomlistSrv;
	@Override
	@RequestMapping(value="/roomlist/roomlistmain.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomlistmain(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		mav.addObject("roomList",roomlist);
		return mav;
	}
