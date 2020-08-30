package com.jiaming.admin.goods.controller;

import com.jiaming.admin.goods.service.GoodService;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Fruit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class HotFruitServlet
 */
@WebServlet("/hotFruitServlet")
public class HotFruitServlet extends BaseServlet {
	
	@Autowired
	private GoodService goodService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Fruit> list = goodService.selectHotFruits();
		
		request.getSession().setAttribute("goods", list);	
		
		request.getRequestDispatcher("/BSindex4.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
