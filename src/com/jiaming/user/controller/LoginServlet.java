package com.jiaming.user.controller;

import com.gg.beanhelper.BeanHelper;
import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.cart.service.CartService;
import com.jiaming.entity.Cart;
import com.jiaming.entity.User;
import com.jiaming.povos.RegistMsgPovo;
import com.jiaming.user.service.UserService;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/LoginServlet")
public class LoginServlet extends BaseServlet implements Servlet {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  tel_email =  request.getParameter("tel_email");
		String   password =   request.getParameter("password");
		User  user  =  new User();
		user.setPassword(password);
		if(tel_email.contains("@")) {
			
			user.setEmail(tel_email);
		}else {
			user.setTel(tel_email);
		}
		User u  = userService.login(user);
		if(u==null){
			request.setAttribute("code", "err");
			request.setAttribute("msg", "EMAIL\\TELªÚ√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return  ; 
		}
		request.getSession().setAttribute("user", u);
		
		List<Cart> carts = cartService.getCartByUid(u.getUid());
		
		request.getSession().setAttribute("carts", carts);
		
		
		response.sendRedirect("/fruits/index.jsp");
	}


}
