package com.spring.foodchain.roomlist.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.foodchain.roomlist.vo.RoomListVO;

public interface RoomListDAO {
	public List selectAllRoomsList() throws DataAccessException;
	public int insertRoom(RoomListVO roomlistVO) throws DataAccessException;
//	public int roominfo(RoomListVO roomlistVO) throws DataAccessException;
}
