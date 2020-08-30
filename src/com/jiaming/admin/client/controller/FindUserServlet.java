package com.jiaming.admin.client.controller;

import java.io.IOException;
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
 * Servlet implementation class findUserServlet
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends BaseServlet {
	
	@Autowired
	private ClientService clientService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String uid = request.getParameter("uid");
		  
		  User user = clientService.findByUid(uid);
		  
//		  System.out.println(user);
		  
		  //���û�������
		  request.getSession().setAttribute("buser", user);
		  
		  //��ת���޸�ҳ��
		  response.sendRedirect(request.getContextPath()+"/BSindex3.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
