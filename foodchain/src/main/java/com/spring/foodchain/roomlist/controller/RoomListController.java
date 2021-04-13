package com.spring.foodchain.roomlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.roomlist.vo.RoomListVO;

public interface RoomListController {

	ModelAndView roomlist(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView addRoom(@ModelAttribute("info") RoomListVO room, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
