package com.spring.foodchain.roomlist.vo;

import org.springframework.stereotype.Component;

@Component
public class RoomListVO {
	private String state;
	private int num;
	private String title;
	private String size;
	private String master;

	public RoomListVO() {
		
	}

	public RoomListVO(String state, int num, String title, String size, String master) {
		this.state = state;
		this.num = num;
		this.title = title;
		this.size = size;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
	
	
	
}