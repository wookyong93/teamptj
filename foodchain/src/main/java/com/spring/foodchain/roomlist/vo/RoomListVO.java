package com.spring.foodchain.roomlist.vo;

import org.springframework.stereotype.Component;

@Component("roomListVO")
public class RoomListVO {
	private String state;
	private int num;
	private String title;
	private String rsize;
	private String master;

	public RoomListVO() {
		
	}

	public RoomListVO(String state, int num, String title, String rsize, String master) {
		this.state = state;
		this.num = num;
		this.title = title;
		this.rsize = rsize;
		this.master = master;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRsize() {
		return rsize;
	}

	public void setRsize(String rsize) {
		this.rsize = rsize;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}


	
}