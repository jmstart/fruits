package com.jiaming.admin.client.controller;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.admin.client.service.ClientService;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends BaseServlet {
	
	
	@Autowired
	private ClientService clientService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = BeanHelper.getBean(request.getParameterMap(), User.class);
		
		clientService.updateUser(user);
		
		response.sendRedirect(request.getContextPath()+"/FindClientServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
