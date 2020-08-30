package com.jiaming.povos;

import java.math.BigDecimal;

import com.jiaming.entity.Fruit;
import com.jiaming.entity.Star;

public class StarFruitPovo {

	private Star star;
	private Fruit fruit;
	
	public BigDecimal getSubTotal() {
		
		BigDecimal price = new BigDecimal(fruit.getfPrice().toString());
		BigDecimal scount = new BigDecimal(star.getScount().toString());
		
		
		return price.multiply(scount);
	}
	
	
	
	
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	@Override
	public String toString() {
		return "StarFruitPovo [star=" + star + ", fruit=" + fruit + "]";
	}
	
	
}
