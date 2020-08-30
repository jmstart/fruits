package com.jiaming.ajax.demo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaming.baseservlet.BaseServlet;

/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/ajax/AjaxDemoServlet")
public class AjaxDemoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Random random = new Random();
		
		int nextInt = random.nextInt(100);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username +"..."+password);
		
		response.getWriter().write(nextInt);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
