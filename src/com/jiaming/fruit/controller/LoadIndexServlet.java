package com.jiaming.fruit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.category.service.CategoryService;
import com.jiaming.entity.Category;
import com.jiaming.entity.Fruit;
import com.jiaming.fruit.service.FruitService;

@WebServlet("/fruit/LoadIndexServlet")
public class LoadIndexServlet extends BaseServlet{
	@Autowired
	private FruitService fruitService;
	
	@Autowired
	private CategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  page =  request.getParameter("page");
		Integer   pageNum =Integer.parseInt(request.getParameter("pageNum"))  ;
		PageHelper.startPage(pageNum, 3);
		
		List<Fruit> fruits = fruitService.getHotFruits();
		PageInfo<Fruit> hotinfo = new PageInfo<Fruit>(fruits);
		request.getSession().setAttribute("hotinfo", hotinfo);
		
		List<Category> categorys = categoryService.showAllCategorys();
		request.getSession().setAttribute("categorys", categorys);
		
		response.sendRedirect("/fruits/"+page);
		
	}

}
