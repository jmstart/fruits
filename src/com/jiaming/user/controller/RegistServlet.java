package com.jiaming.user.controller;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.User;
import com.jiaming.povos.RegistMsgPovo;
import com.jiaming.user.service.UserService;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/user/RegistServlet")
public class RegistServlet extends BaseServlet implements Servlet {
	
	@Autowired
	private UserService userService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User  user   =  BeanHelper.getBean(request.getParameterMap(), User.class);
		RegistMsgPovo   povo  =  userService.regist(user);
		if(povo.isRes()) {
			request.setAttribute("code", "suc");
			request.setAttribute("msg", "ע��ɹ��ˣ�");
			
		}else {
			request.setAttribute("code", "err");
			if(!povo.isEmail_status() && !povo.isTel_status()) {
				request.setAttribute("msg", "Tel��Email������");
				
			}else if(!povo.isEmail_status()) {
				request.setAttribute("msg", "Email�Ѵ���");
			}else if(!povo.isTel_status()) {
				request.setAttribute("msg", "Tel �Ѵ���");
			}else if(!povo.isInsert_status()) {
				request.setAttribute("msg", "�����ԡ�����");
			}
			
		}
		//ת��  Ĭ�� �Դ� ��������   ������·����
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
