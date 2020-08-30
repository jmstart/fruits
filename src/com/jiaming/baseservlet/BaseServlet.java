package com.jiaming.baseservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(loadOnStartup = 1)
public class BaseServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		WebApplicationContextUtils.
		getRequiredWebApplicationContext(this.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);

	}
}
