package com.spring.foodchain.roomlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.foodchain.roomlist.dao.RoomListDAO;

@Service("roomlistService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoomListServiceImpl implements RoomListService {
	@Autowired
	private RoomListDAO roomlistDAO;

	@Override
	public List roomsList() throws DataAccessException {
		List roomsList = null;
		roomsList = roomlistDAO.selectAllRoomsList();
		return roomsList;
	}
}
