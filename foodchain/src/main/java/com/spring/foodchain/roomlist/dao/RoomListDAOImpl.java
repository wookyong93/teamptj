package com.spring.foodchain.roomlist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.foodchain.roomlist.vo.RoomListVO;

@Repository("roomlistDAO")
public class RoomListDAOImpl implements RoomListDAO {
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List selectAllRoomsList() throws DataAccessException {
		List<RoomListVO> roomsList = null;
		roomsList = sqlsession.selectList("mapper.room.selectAllRoomsList");
		return roomsList;
	}
}
