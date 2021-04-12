package com.spring.foodchain.member.service;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.member.VO.MemberVO;

public interface MemberService {
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException;
}
