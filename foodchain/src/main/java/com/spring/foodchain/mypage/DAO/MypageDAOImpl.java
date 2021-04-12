package com.spring.foodchain.mypage.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.foodchain.mypage.VO.MypageVO;

@Repository("mypageDAO")
public class MypageDAOImpl implements MypageDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MypageVO> mypageView(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		List<MypageVO> mypageView = sqlSession.selectList("mapper.member.mypageView",id);
		return mypageView;
	}

	@Override
	public int modifyMypage(MypageVO mypageVO) throws DataAccessException {
		// TODO Auto-generated method stub
		int result = sqlSession.update("mapper.member.modifyMypage",mypageVO);
		return result;
	}
	
	
}
