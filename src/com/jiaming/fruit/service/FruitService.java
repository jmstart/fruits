package com.jiaming.fruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.Fruit;
import com.jiaming.mapper.FruitMapper;
import com.jiaming.povos.PricePovo;

@Service
public class FruitService {

	@Autowired
	private FruitMapper fruitMapper;
	
	public List<Fruit> getHotFruits(){
		
		return fruitMapper.selectHotFruits();
	}

	public List<Fruit> getFruitsBySwitch(Fruit fruit) {
		// TODO Auto-generated method stub
		return fruitMapper.selectFruisBySwitch(fruit);
	}
	
	public List<Fruit> getFruitByPrice(PricePovo pricePovo){
		return fruitMapper.selectFruitsByPrise(pricePovo);
	}
	
	
	
	
	
}
