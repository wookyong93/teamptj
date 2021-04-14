package com.spring.foodchain.mypage.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.member.VO.MemberVO;
import com.spring.foodchain.mypage.service.MypageService;

//강민경 작성 
//마이페이지 보기 / 정보수정

@Controller("mypageController")
public class MypageControllerImpl implements MypageController{
	@Autowired
	private MypageService mypageService;
	@Override
	@RequestMapping(value="/mypage/mypageView.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mypageView(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav =null;
		HttpSession session = request.getSession();
	
		if (session != null) {
			String loginID = (String) session.getAttribute("loginID");
			String viewName = (String)request.getAttribute("viewName");
			mav = new ModelAndView(viewName);
			List<MemberVO> mypageView = mypageService.mypageView(loginID);
			
			mav.addObject("mypageView",mypageView);
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/mypage/modifyMypage.do", method=RequestMethod.POST)
	public ModelAndView modifyMypage(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		if(loginID ==null){
			loginID = request.getParameter("id");
			session.setAttribute("loginID", loginID);
		}
		ModelAndView mav = new ModelAndView("redirect:/room/roomlistmain.do?id="+loginID);
		int result = mypageService.modifyMypage(memberVO);
		return mav;
	}
	
	//우경님 작성 카피
	@Override
	@RequestMapping(value="/mypage/nicknameCheck.do" ,method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity nameCheck(@RequestParam("nickname")String nickName, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity resEnt;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message = null;
		responseHeaders.add("Content-Type","text/html; charset=utf-8");
		String id = request.getParameter("id");
	
		try {
			int result = mypageService.nicknameCheck(nickName);
			if(result==0) {
				message = "<script>alert('사용가능한 닉네임 입니다');location.href='"+request.getContextPath()+"/mypage/mypageView.do?nickname="+nickName+"&id="+id+"';</script>";
			}else {
				message = "<script>alert('중복된 닉네임이 있습니다');location.href='"+request.getContextPath()+"/mypage/mypageView.do?id="+id+"';</script>";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEnt;
	}

}
