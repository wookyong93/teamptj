package com.spring.foodchain.member.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.foodchain.member.VO.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
		boolean result = Boolean.parseBoolean((String)sqlSession.selectOne("mapper.member.loginCheck",memberVO));
		System.out.println(result);
		return result;
	}
	@Override
	public int idCheck(String id) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.member.idCheck",id);
		return result;
	}
	@Override
	public boolean addMember(MemberVO memberVO) throws DataAccessException {
		boolean result =false;
		int num = sqlSession.insert("mapper.member.addMember",memberVO);
		if(num == 1) {
			result = true;
		}
		
		return result;
	}
	@Override
	public int nicknameCheck(String nickName) throws DataAccessException {
		// TODO Auto-generated method stub
		int result = sqlSession.selectOne("mapper.member.nicknameCheck", nickName);
		return result;
	}
	@Override
	public MemberVO membervo(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		MemberVO memberVO = sqlSession.selectOne("mapper.member.viewMember",id);
		return memberVO;
	}

}
