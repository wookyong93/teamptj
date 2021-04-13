package com.spring.foodchain.roomlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface RoomListController {

	ModelAndView roomlist(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
