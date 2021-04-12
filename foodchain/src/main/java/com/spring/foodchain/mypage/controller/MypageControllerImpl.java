package com.spring.foodchain.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.mypage.VO.MypageVO;
import com.spring.foodchain.mypage.service.MypageService;

public class MypageControllerImpl implements MypageController{
	@Autowired
	private MypageService mypageService;
	@Override
	@RequestMapping(value="/mypage/mypageView.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mypageView(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<MypageVO> mypageView = mypageService.mypageView(id);
		mav.addObject("mypageView",mypageView);
		return mav;
	}

	@Override
	@RequestMapping(value="/mypage/modifyMypage.do", method=RequestMethod.POST)
	public ModelAndView modifyAddress(MypageVO mypageVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("redirect:main/mainPage.do");
		int result =0;
		result = mypageService.modifyMypage(mypageVO);
		return mav;
	}

}
