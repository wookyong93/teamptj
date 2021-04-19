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
	
	// 권우경님 작성
	@Override
	public boolean addMembers(MemberVO memberVO) {
		boolean result = false;
		int num = sqlSession.insert("mapper.member.addMember",memberVO);
		if(num == 1) {
			result = true;
		}
		return result;
	}

	@Override
	public int delMembers(String id) {
		int result = sqlSession.delete("mapper.member.delMember",id);
		return result;
	}

//	@Override
//	public MemberVO viewMembers(String id) {
//		MemberVO memberVO = sqlSession.selectOne("mapper.member.viewMember",id);
//		return memberVO;
//	}

}
