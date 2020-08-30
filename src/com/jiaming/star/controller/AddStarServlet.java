package com.jiaming.star.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Star;
import com.jiaming.entity.User;
import com.jiaming.star.service.StarService;

/**
 * Servlet implementation class AddStarServlet
 */
@WebServlet("/star/AddStarServlet")
public class AddStarServlet extends BaseServlet {
	
	@Autowired
	private StarService starService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Star star = BeanHelper.getBean(request.getParameterMap(), Star.class);
		
		Star star = new Star();
		int fid =Integer.parseInt(request.getParameter("fid"));
		int scount = Integer.parseInt(request.getParameter("scount"));
		String uid = ((User) request.getSession().getAttribute("user")).getUid();
		
		star.setUid(uid);
		star.setFid(fid);
		star.setScount(scount);
		
		starService.addStar(star);
		
		response.sendRedirect("GetStarsByUidServlet?uid="+uid);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
