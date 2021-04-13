package com.spring.foodchain.roomlist.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RoomListDAO {
	public List selectAllRoomsList() throws DataAccessException;
}
