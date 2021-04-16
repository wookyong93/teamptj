package com.spring.foodchain.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.foodchain.admin.dao.AdminDAO;
import com.spring.foodchain.member.VO.MemberVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO aDAO;
	
	@Override
	public List listMembers() {
		return aDAO.listMembers();
		
	}

	@Override
	public boolean addMembers(MemberVO memberVO) {
		return aDAO.addMembers(memberVO);
	}

	@Override
	public int modMembers(MemberVO memberVO) {
		return aDAO.modMembers(memberVO);
	}

	@Override
	public int delMembers(String id) {
		return aDAO.delMembers(id);
	}

//	@Override
//	public MemberVO viewMembers(String id) {
//		return aDAO.viewMembers(id);
//	}

}
