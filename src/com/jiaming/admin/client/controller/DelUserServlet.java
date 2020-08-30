package com.jiaming.admin.client.controller;

import com.jiaming.admin.client.service.ClientService;
import com.jiaming.baseservlet.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends BaseServlet {
	
	@Autowired
	private ClientService clientService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		
		clientService.deleteUser(uid);
		
		response.sendRedirect(request.getContextPath()+"/FindClientServlet");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
