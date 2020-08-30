package com.jiaming.fruit.controller;

import com.gg.beanhelper.BeanHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.Fruit;
import com.jiaming.fruit.service.FruitService;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class SelectFruitsBySwitchServlet
 */
@WebServlet("/fruit/SelectFruitsBySwitchServlet")
public class SelectFruitsBySwitchServlet extends BaseServlet implements Servlet {

	@Autowired
	private FruitService fruitService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestPageNum = request.getParameter("pageNum");
		if (requestPageNum == null || requestPageNum.equals("")) {
			requestPageNum = "1";
		}
		
		int pageNum = Integer.parseInt(requestPageNum);
		Fruit fruit = BeanHelper.getBean(request.getParameterMap(), Fruit.class);
		PageHelper.startPage(pageNum, 3);
		
		String url = request.getRequestURI();
		url += "?xxx=xxx";
		Map<String, String[]> map = request.getParameterMap();
		Set<String> params = map.keySet();
		Iterator<String> iter = params.iterator();
		while (iter.hasNext()) {
			String param = (String) iter.next();
			String value = map.get(param)[0];
//			if (param.equals("fName")) {
//				value = new String(value.getBytes("iso8859-1"),"utf-8");
//			}
			if (!param.equals("pageNum")) {
				url += "&"+param+"="+value;
			}
		}
		request.getSession().setAttribute("url", url);
		
		List<Fruit> fruits = fruitService.getFruitsBySwitch(fruit);
		PageInfo<Fruit> info = new PageInfo<Fruit>(fruits);
		
		request.getSession().setAttribute("info", info);
		response.sendRedirect("/fruits/sel.jsp");
		
	
	}



}
