package com.spring.foodchain.mypage.service;

import java.util.List;

import com.spring.foodchain.mypage.VO.MypageVO;

public interface MypageService {

	public List<MypageVO> mypageView(String id) throws Exception;

	int modifyMypage(MypageVO mypageVO) throws Exception;

}
