package com.jiaming.cart.controller;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.cart.service.CartService;
import com.jiaming.povos.CartFruitPovo;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class GetCartFruitPovoByUidServlet
 */
@WebServlet("/cart/GetCartFruitPovoByUidServlet")
public class GetCartFruitPovoByUidServlet extends BaseServlet implements Servlet {
	@Autowired
	private CartService cartService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String uid = request.getParameter("uid");
	     List<CartFruitPovo> povos = cartService.getCartFruitPovosByUid(uid);
	     request.getSession().setAttribute("povos", povos);
	     response.sendRedirect("/fruits/showcart.jsp");
	}


}
