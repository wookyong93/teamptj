package com.spring.foodchain.admin.service;

import java.util.List;

import com.spring.foodchain.member.VO.MemberVO;

public interface AdminService {
	public List listMembers();
	public boolean addMembers(MemberVO memberVO);
	public int modMembers(MemberVO memberVO);
	public int delMembers(String id);
	public MemberVO viewMembers(String id);
	public int idCheck(String id);
	public int nicknameCheck(String nickName);
}
