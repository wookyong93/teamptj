package com.spring.foodchain.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.foodchain.animal.dao.AnimalDAO;
import com.spring.foodchain.animal.dao.AnimalDAOImpl;
import com.spring.foodchain.animal.vo.RoleVO;

@Service("animalService")
//서비스 지정 및 animalService 클래스 상속 처리
public class AnimalServiceImpl implements AnimalService{
	@Autowired
	private AnimalDAO animalDAO;
	
	@Override
	public int rankComparison(String animal) {
		return animalDAO.rankComparison(animal);
	}
	
	@Override
	public boolean skyOk(String animal) {
		// TODO Auto-generated method stub
		return animalDAO.skyOk(animal);
	}
	
}
