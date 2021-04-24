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
		System.out.println(memberDAO.loginCheck(memberVO));
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getPwd());
		return memberDAO.loginCheck(memberVO);
	}

	@Override
	public int idCheck(String id) throws DataAccessException {
		int result =memberDAO.idCheck(id); 
		return result;
	}

	@Override
	public boolean addMember(MemberVO memberVO) throws DataAccessException {
		
		return memberDAO.addMember(memberVO);
	}

	@Override
	public int nicknameCheck(String nickName) throws DataAccessException {
		// TODO Auto-generated method stub
		int result =memberDAO.nicknameCheck(nickName);
		return result;
	}

	@Override
	public String memberVO(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		MemberVO memberVO = memberDAO.membervo(id);
		String nick = memberVO.getNickname();
		return nick;
	}

}
