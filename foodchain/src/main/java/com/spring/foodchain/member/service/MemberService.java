package com.spring.foodchain.member.service;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.member.VO.MemberVO;

public interface MemberService {
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException;

	public int idCheck(String id) throws DataAccessException;

	public boolean addMember(MemberVO memberVO)throws DataAccessException;

	public int nicknameCheck(String nickName)throws DataAccessException;
	
	public String memberVO(String id)throws DataAccessException;
}
