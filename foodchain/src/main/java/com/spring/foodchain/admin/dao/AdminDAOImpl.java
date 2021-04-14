package com.spring.foodchain.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.foodchain.member.VO.MemberVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List listMembers() {
		List<MemberVO> memList = sqlSession.selectList("mapper.member.listMember");
		return memList;
	}

	@Override
	public int modMembers(MemberVO memberVO) {
		int result = sqlSession.update("mapper.member.modMember",memberVO);
		return result;
	}
	@Override
	public int addMembers(MemberVO memberVO) {
		int result = sqlSession.insert("mapper.member.addMember",memberVO);
		return result;
	}

	@Override
	public int delMembers(String id) {
		int result = sqlSession.delete("mapper.member.delMember");
		return result;
	}

	@Override
	public MemberVO viewMembers(String id) {
		MemberVO memberVO = sqlSession.selectOne("mapper.member.viewMember",id);
		return memberVO;
	}

}
