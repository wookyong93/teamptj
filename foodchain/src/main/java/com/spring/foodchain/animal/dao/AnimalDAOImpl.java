package com.spring.foodchain.animal.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("animalDAO")
public class AnimalDAOImpl implements AnimalDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int rankComparison(String animal) {
		int result = sqlSession.update("mapper.role.rank_comparison",animal);
		return result;
	}

	@Override
	public boolean skyOk(String animal) {
		boolean result = false;
		int num = sqlSession.selectOne("mapper.role.sky_okCheck",animal);
		if(num==2) {
			result = true;
		} else {
			return false;
		}
		return result;
	}

}
