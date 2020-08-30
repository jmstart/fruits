package com.jiaming.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.Cart;
import com.jiaming.mapper.CartMapper;
import com.jiaming.povos.CartFruitPovo;

@Service
public class CartService {

	@Autowired
	private CartMapper cartMapper;
	
	public List<Cart> getCartByUid(String uid){
		
		return cartMapper.selectCartByUid(uid);
	}
	
	public List<CartFruitPovo> getCartFruitPovosByUid(String uid){
		return cartMapper.selectCartFruitPovoByUid(uid);
	}
	
	public void removeCartByCid(String cid) {
		
		cartMapper.deleteByPrimaryKey(cid);
	}

	public boolean changeCartByCidForCcount(String cid, int value) {
		// TODO Auto-generated method stub
		return cartMapper.updateCartByCidForCcount(cid,value);
	}

	public void addCart(Cart cart) {

		Cart preCart = cartMapper.selectCartByUidAndFid(cart);
		
		if (preCart == null) {
			
			cartMapper.insert(cart);
		}else {
			
			preCart.setCcount(preCart.getCcount()+cart.getCcount());
			cartMapper.updateByPrimaryKey(preCart);
		}
	}
	
}
