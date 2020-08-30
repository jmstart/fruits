package com.jiaming.admin.goods.controller;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.admin.goods.service.GoodService;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Fruit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class UpdateFruitServlet
 */
@WebServlet("/updateFruitServlet")
public class UpdateFruitServlet extends BaseServlet {
	
	@Autowired
	private GoodService goodService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Fruit fruit = BeanHelper.getBean(request.getParameterMap(),Fruit.class );
		
		goodService.upadateFruit(fruit);
		
		response.sendRedirect(request.getContextPath()+"/FindFruitServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
