package com.spring.foodchain.mypage.service;

import java.util.List;

import com.spring.foodchain.member.VO.MemberVO;

public interface MypageService {

	public List<MemberVO> mypageView(String id) throws Exception;

	int modifyMypage(MemberVO memberVO) throws Exception;

}
