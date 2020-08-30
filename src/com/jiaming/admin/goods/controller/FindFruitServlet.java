package com.jiaming.admin.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.admin.goods.service.GoodService;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Fruit;
import com.jiaming.entity.User;

/**
 * Servlet implementation class FindFruitServlet
 */
@WebServlet("/FindFruitServlet")
public class FindFruitServlet extends BaseServlet {
	
	@Autowired
	private GoodService goodService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Fruit> list = goodService.findAllFruit();
		
//		System.out.println(list);
		
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
