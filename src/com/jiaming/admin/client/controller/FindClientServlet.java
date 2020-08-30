package com.jiaming.admin.client.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.admin.client.service.ClientService;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.User;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/FindClientServlet")
public class FindClientServlet extends BaseServlet {

    @Autowired
	private ClientService clientService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> list = clientService.findAll();
		
//		System.out.println(list);
		
		request.getSession().setAttribute("client", list);	
		
		
		request.getRequestDispatcher("/BSindex1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
