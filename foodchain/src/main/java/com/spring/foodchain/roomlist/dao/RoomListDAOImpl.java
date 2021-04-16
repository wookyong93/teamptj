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
		System.out.println(roomlistVO.getTitle());
		int result = sqlsession.insert("mapper.room.addRoom",roomlistVO);
		return result;
	}	
//	<방 안에 남은 인원이 0명일경우 자동으로 삭제>
//	@Override
//	public int deleteRoom()throws DataAccessException{
//		
//	}
	
	
//	@Override
//		public int roominfo(RoomListVO roomlistVO) throws DataAccessException {
//		int result = sqlsession.selectOne("mapper.room.roominfo");
//		return result;
//	}

}
