package com.spring.foodchain.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.foodchain.member.VO.MemberVO;
import com.spring.foodchain.mypage.DAO.MypageDAO;

@Service("mypageService")
@Transactional
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public List<MemberVO> mypageView(String id) throws Exception {
		List<MemberVO> mypageView = mypageDAO.mypageView(id);
		return mypageView;
	}

	@Override
	public int modifyMypage(MemberVO memberVO) {
		int result = mypageDAO.modifyMypage(memberVO);	
		return result;
	}

}
