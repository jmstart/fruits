package com.jiaming.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.cart.service.CartService;
import com.jiaming.entity.Cart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/cart/AddCartServlet")
public class AddCartServlet extends BaseServlet {
	
	@Autowired
	private CartService cartService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = BeanHelper.getBean(request.getParameterMap(), Cart.class);
		
		cartService.addCart(cart);
		
		response.sendRedirect("GetCartFruitPovoByUidServlet?uid="+cart.getUid());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
