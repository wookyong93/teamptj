package com.spring.foodchain.member.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.member.VO.MemberVO;
import com.spring.foodchain.member.service.MemberService;
//작성자 권우경 21/04/12 
//로그인 페이지 호출 / 로그인 검사 / 회원가입페이지 호출 / 회원가입 처리
@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;

	@Override
	@RequestMapping(value="/login/login.do", method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="login/loginCheck.do", method=RequestMethod.POST)
	public ResponseEntity loginCheck(@ModelAttribute("member") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity resEnt=null; 
		HttpHeaders responseHeaders = new HttpHeaders();
		String message;
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
			boolean result = memberService.loginCheck(memberVO);
			if(result) {
				message="<script>alert('로그인 성공');location.href='"+request.getContextPath()+"/room/roomlistmain.do';</script>";
				session.setAttribute("loginID", memberVO.getId());
			}else {
				message="<script>alert('로그인 실패');location.href='"+request.getContextPath()+"/login/login.do';</script>";
			}
			resEnt = new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			return resEnt;
	}

	@Override
	@RequestMapping(value="/join/join.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView joinForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	//작성완료 test 정상 / 21/04/13 권우경
	@Override
	@RequestMapping(value="/member/idCheck.do" ,method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity idCheck(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message = null;
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
			int result = memberService.idCheck(id);
			if(result == 0) {
				message = "<script>alert('사용가능한 아이디 입니다');location.href='"+request.getContextPath()+"/join/join.do?id="+id+"';</script>";
			} else {
				message = "<script>alert('사용이 불가능한 아이디 입니다');location.href='"+request.getContextPath()+"/join/join.do';</script>";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEnt;
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method= RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("member") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(request.getParameter("birth"));
		ResponseEntity resEnt=null; 
		HttpHeaders responseHeaders = new HttpHeaders();
		String message;
		System.out.println(memberVO.getBirth());
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		request.getSession();
			boolean result = memberService.addMember(memberVO);
			if(result) {
				message="<script>alert('가입성공');location.href='"+request.getContextPath()+"/login/login.do';</script>";
			}else {
				message="<script>alert('가입실패');location.href='"+request.getContextPath()+"/login/login.do';</script>";
			}
			resEnt = new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			return resEnt;
	}

	@Override
	@RequestMapping(value="/member/nameCheck.do" ,method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity nameCheck(@RequestParam("nickname")String nickName, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity resEnt;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message = null;
		responseHeaders.add("Content-Type","text/html; charset=utf-8");
		String id = request.getParameter("id");
		try {
			int result = memberService.nicknameCheck(nickName);
			if(result==0) {
				message = "<script>alert('사용가능한 닉네임 입니다');location.href='"+request.getContextPath()+"/join/join.do?nickname="+nickName+"&id="+id+"';</script>";
			}else {
				message = "<script>alert('중복된 닉네임이 있습니다');location.href='"+request.getContextPath()+"/join/join.do?id="+id+"';</script>";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEnt;
	}

}
