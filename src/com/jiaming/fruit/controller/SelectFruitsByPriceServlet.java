package com.jiaming.fruit.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.baseservlet.BaseServlet;
import com.gg.beanhelper.BeanHelper;
import com.jiaming.entity.Fruit;
import com.jiaming.fruit.service.FruitService;
import com.jiaming.povos.PricePovo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@WebServlet("/fruit/SelectFruitsByPriceServlet")
public class SelectFruitsByPriceServlet extends BaseServlet {
	@Autowired
	private FruitService fruitService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PricePovo povo = BeanHelper.getBean(request.getParameterMap(), PricePovo.class);
		String requestPageNum = request.getParameter("pageNum");
		if (requestPageNum == null || requestPageNum.equals("")) {

			requestPageNum = "1";
		}
		int pageNum = Integer.parseInt(requestPageNum);

		PageHelper.startPage(pageNum, 3);
		List<Fruit> fruits = fruitService.getFruitByPrice(povo);
		PageInfo<Fruit> info = new PageInfo<Fruit>(fruits);
		request.getSession().setAttribute("info", info);

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

		response.sendRedirect("/fruits/sel.jsp");

	}

}
