package com.spring.foodchain.roomlist.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RoomListService {
	public List roomsList() throws DataAccessException;
}
