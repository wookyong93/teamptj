package com.spring.foodchain.mypage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.member.VO.MemberVO;

public interface MypageService {

	public List<MemberVO> mypageView(String id) throws Exception;

	public int modifyMypage(MemberVO memberVO) throws Exception;

	public int nicknameCheck(String nickName)throws DataAccessException;

}
