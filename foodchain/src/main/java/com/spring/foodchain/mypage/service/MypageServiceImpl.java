package com.spring.foodchain.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.foodchain.mypage.DAO.MypageDAO;
import com.spring.foodchain.mypage.VO.MypageVO;

@Service("mypageService")
@Transactional
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public List<MypageVO> mypageView(String id) throws Exception {
		List<MypageVO> mypageView = mypageDAO.mypageView(id);
		return mypageView;
	}

	@Override
	public int modifyMypage(MypageVO mypageVO) {
		int result = mypageDAO.modifyMypage(mypageVO);	
		return result;
	}

}
