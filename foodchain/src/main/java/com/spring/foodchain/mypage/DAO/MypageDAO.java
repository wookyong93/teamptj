package com.spring.foodchain.mypage.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.member.VO.MemberVO;

public interface MypageDAO {
	public List<MemberVO> mypageView(String id) throws DataAccessException;
	
	public int modifyMypage(MemberVO memberVO)throws DataAccessException;

	public int nicknameCheck(String nickName) throws DataAccessException;
}
