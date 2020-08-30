package com.jiaming.star.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.povos.StarFruitPovo;
import com.jiaming.star.service.StarService;

/**
 * Servlet implementation class GetStarsByUidServlet
 */
@WebServlet("/star/GetStarsByUidServlet")
public class GetStarsByUidServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
	private StarService starService;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		
		List<StarFruitPovo> povos = starService.getStarsByUid(uid);
		
		request.getSession().setAttribute("starpovos", povos);
		
		response.sendRedirect("/fruits/showstar.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
