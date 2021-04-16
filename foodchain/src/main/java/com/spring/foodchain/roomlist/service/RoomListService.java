package com.spring.foodchain.roomlist.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.roomlist.vo.RoomListVO;

public interface RoomListService {
	public List roomsList() throws DataAccessException;
	public int addRoom(RoomListVO room) throws DataAccessException;
}
