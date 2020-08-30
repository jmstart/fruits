package com.jiaming.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.cart.service.CartService;

/**
 * Servlet implementation class ChangeByCidForCountServlet
 */
@WebServlet("/cart/ChangeCartByCidForCcountServlet")
public class ChangeCartByCidForCcountServlet extends BaseServlet {

	@Autowired
	private CartService cartService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cid = request.getParameter("cid");
		int value = Integer.parseInt(request.getParameter("value"));

		boolean res = cartService.changeCartByCidForCcount(cid, value);

		response.getWriter().print(res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
