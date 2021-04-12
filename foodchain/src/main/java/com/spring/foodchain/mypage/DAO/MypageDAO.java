package com.spring.foodchain.mypage.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.mypage.VO.MypageVO;

public interface MypageDAO {
	public List<MypageVO> mypageView(String id) throws DataAccessException;
	
	public int modifyMypage(MypageVO mypageVO)throws DataAccessException;
}
