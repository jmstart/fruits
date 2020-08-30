package com.jiaming.star.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.star.service.StarService;

/**
 * Servlet implementation class ChangeStarByScountServlet
 */
@WebServlet("/star/ChangeStarBySidForScountServlet")
public class ChangeStarBySidForScountServlet extends BaseServlet {
	@Autowired
	private   StarService  starService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  sid =  request.getParameter("sid");
		int   value = Integer.parseInt(request.getParameter("value")) ;
		
		boolean  res = starService.changeStarBySidForScount(sid,value);
		
		response.getWriter().print(res);
		
		
	}

}