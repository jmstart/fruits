package com.jiaming.admin.goods.controller;

import com.jiaming.admin.goods.service.GoodService;
import com.jiaming.baseservlet.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class DelFruitServlet
 */
@WebServlet("/delFruitServlet")
public class DelFruitServlet extends BaseServlet {
	

	@Autowired
	private GoodService goodService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fid = request.getParameter("fid");
		
		goodService.deleteFruitFid(fid);
		
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
