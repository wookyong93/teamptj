package com.spring.foodchain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.foodchain.member.DAO.MemberDAO;
import com.spring.foodchain.member.VO.MemberVO;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return memberDAO.loginCheck(memberVO);
	}

}
