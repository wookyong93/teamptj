package com.spring.foodchain.mypage.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("mypageVO")
public class MypageVO {
	private String id;
	private String pwd;
	private Date joinDate;
	public MypageVO() {
		
	}
	
	public MypageVO(String id, String pwd, Date joinDate) {
		this.id=id;
		this.pwd=pwd;
		this.joinDate=joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
