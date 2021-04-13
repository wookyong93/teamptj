package com.spring.foodchain.mypage.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.foodchain.member.VO.MemberVO;

@Repository("mypageDAO")
public class MypageDAOImpl implements MypageDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MemberVO> mypageView(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		List<MemberVO> mypageView = sqlSession.selectList("mapper.member.viewMember",id);
		return mypageView;
	}

	@Override
	public int modifyMypage(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		int result = sqlSession.update("mapper.member.modifyMypage",memberVO);
		return result;
	}
	
	
}
