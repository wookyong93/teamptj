package com.spring.foodchain.admin.dao;

import java.util.List;

import com.spring.foodchain.member.VO.MemberVO;

public interface AdminDAO {

	public List listMembers();
	public int modMembers(MemberVO memberVO);
	public boolean addMembers(MemberVO memberVO);
	public int delMembers(String id);
	public MemberVO viewMembers(String id);
	public int idCheck(String id);
	public int nicknameCheck(String nickName);

}
