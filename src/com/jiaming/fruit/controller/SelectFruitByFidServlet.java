package com.jiaming.fruit.controller;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Fruit;
import com.jiaming.entity.Star;
import com.jiaming.entity.User;
import com.jiaming.fruit.service.FruitService;
import com.jiaming.star.service.StarService;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class SelectFruitByFidServlet
 */
@WebServlet("/fruit/SelectFruitByFidServlet")
public class SelectFruitByFidServlet extends BaseServlet implements Servlet {
	@Autowired
	private FruitService fruitService;
	
	@Autowired
	private StarService starService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fruit fruit = BeanHelper.getBean(request.getParameterMap(), Fruit.class);
		List<Fruit> list = fruitService.getFruitsBySwitch(fruit);
		
		User user = ((User) request.getSession().getAttribute("user"));
		if (user == null) {
			
			
			response.sendRedirect("/fruits/login.jsp");
			return ;
		}
		
		
		String uid = user.getUid();
		
		String fid = request.getParameter("fId");
		
		if (list.get(0) != null) {
			
			Star star = starService.selectStarByUidAndFid(uid,fid);
			request.getSession().setAttribute("star", star);
			
			
			request.getSession().setAttribute("fruit", list.get(0));
			response.sendRedirect("/fruits/fruit_info.jsp");
			
			return ;
			
		}
	
		response.sendRedirect("/fruits/index.jsp");
	}

	
	
}
