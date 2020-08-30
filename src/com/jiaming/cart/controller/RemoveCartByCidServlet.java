package com.jiaming.cart.controller;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.cart.service.CartService;
import com.jiaming.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class RemoveCartByCidServlet
 */
@WebServlet("/cart/RemoveCartByCidServlet")
public class RemoveCartByCidServlet extends BaseServlet {
	@Autowired
	private CartService cartService;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String cid = req.getParameter("cid");
			cartService.removeCartByCid(cid);
			
			User user = (User) req.getSession().getAttribute("user");
			
			String uid = user.getUid();
			
			resp.sendRedirect("/fruits/cart/GetCartFruitPovoByUidServlet?uid="+uid);
			
		}
	
	

}
