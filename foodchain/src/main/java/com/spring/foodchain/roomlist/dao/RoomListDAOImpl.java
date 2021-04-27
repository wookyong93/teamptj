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
	
	@Override
	public int insertRoom(RoomListVO roomlistVO) throws DataAccessException {
		
		int roomno = sqlsession.selectOne("mapper.room.countroom");
		roomlistVO.setRoomNum(roomno);
		int	result = sqlsession.insert("mapper.room.addRoom",roomlistVO);

		System.out.println(roomlistVO.getRoomNum());
		return result;
	}

	@Override
	public int delRoom(Integer room) throws DataAccessException{
		System.out.println("방삭제");
		int result = sqlsession.delete("mapper.room.delRoom",room);
		return result;
	}	
	
}
