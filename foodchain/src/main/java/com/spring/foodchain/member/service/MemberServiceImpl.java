package com.spring.foodchain.member.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.foodchain.member.VO.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Override
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

}
