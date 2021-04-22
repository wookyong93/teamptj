package com.spring.foodchain.roomlist.vo;

import org.springframework.stereotype.Component;

@Component("roomlistVO")
public class RoomListVO {
	private String title;
	private int roomNum;
	private String chief_id;
	private long userCount;
	
	public RoomListVO() {
		
	}

	public RoomListVO(String title, int roomNum, String chief_id) {
		this.title = title;
		this.roomNum = roomNum;
		this.chief_id = chief_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getChief_id() {
		return chief_id;
	}

	public void setChief_id(String chief_id) {
		this.chief_id = chief_id;
	}

	public long getUserCount() {
		return userCount;
	}

	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}

	
}