package com.jiaming.povos;

import java.math.BigDecimal;

import com.jiaming.entity.Cart;
import com.jiaming.entity.Fruit;

public class CartFruitPovo {

	
	private Cart cart;
	
	private Fruit fruit;
	
	public BigDecimal getSubTotal() {
		
		BigDecimal count = new BigDecimal(cart.getCcount().toString());
		BigDecimal price = new BigDecimal(fruit.getfPrice().toString());
		
		return count.multiply(price);
	}
	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "CartFruitPovo [cart=" + cart + ", fruit=" + fruit + "]";
	}

	public CartFruitPovo(Cart cart, Fruit fruit) {
		super();
		this.cart = cart;
		this.fruit = fruit;
	}

	public CartFruitPovo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
