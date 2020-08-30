package com.jiaming.admin.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.Fruit;
import com.jiaming.entity.User;
import com.jiaming.mapper.FruitMapper;

@Service
public class GoodService {

	@Autowired
	private FruitMapper fruitMapper;

	public List<Fruit> findAllFruit() {
		// TODO Auto-generated method stub
		return fruitMapper.findAllFruit();
	}

	public Fruit findByFid(String fid) {
		// TODO Auto-generated method stub
		return fruitMapper.findByFid(Integer.parseInt(fid));
	}

	public void upadateFruit(Fruit fruit) {
		// TODO Auto-generated method stub
		fruitMapper.updateFruit(fruit);
	}

	public void deleteFruitFid(String fid) {
		// TODO Auto-generated method stub
		fruitMapper.deleteFid(Integer.parseInt(fid));
	}

	public List<Fruit> selectHotFruits() {
		// TODO Auto-generated method stub
		return fruitMapper.selectHotFruits();
	}

	public void addFruit(Fruit fruit) {
		// TODO Auto-generated method stub
		fruitMapper.addFruit(fruit);
	}

	
	
	
	
}
