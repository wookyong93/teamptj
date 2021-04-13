package com.spring.foodchain.roomlist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.spring.foodchain.roomlist.vo.RoomListVO;

public class RoomListDAOImpl {
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List selectAllRoomsList() throws DataAccessException {
		List<RoomListVO> roomsList = null;
		roomsList = sqlsession.selectList("mapper.room.selectAllRoomsList");
		return roomsList;
	}
}
