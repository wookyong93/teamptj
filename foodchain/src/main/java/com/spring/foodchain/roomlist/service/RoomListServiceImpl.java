package com.spring.foodchain.roomlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.spring.foodchain.roomlist.dao.RoomListDAO;

public class RoomListServiceImpl {
	@Autowired
	private RoomListDAO roomListDAO;

	@Override
	public List roomsList() throws DataAccessException {
		List roomsList = null;
		roomsList = RoomListDAO.selectAllRoomsList();
		return roomsList;
	}
}
