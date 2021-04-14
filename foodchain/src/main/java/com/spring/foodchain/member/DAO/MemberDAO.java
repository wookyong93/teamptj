package com.spring.foodchain.member.DAO;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.member.VO.MemberVO;

public interface MemberDAO {
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException;

	public int idCheck(String id) throws DataAccessException;

	public boolean addMember(MemberVO memberVO)throws DataAccessException;

	public int nicknameCheck(String nickName) throws DataAccessException;
}
