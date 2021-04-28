package com.spring.foodchain.roomlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.foodchain.roomlist.dao.RoomListDAO;
import com.spring.foodchain.roomlist.vo.RoomListVO;

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
	
	@Override
	public int addRoom(RoomListVO room) throws DataAccessException{
		System.out.println(room.getRoomNum());
		return roomlistDAO.insertRoom(room);
	}

	@Override
	public int delRoom(Integer room) throws DataAccessException{
		return roomlistDAO.delRoom(room);
	}
	
	
}
