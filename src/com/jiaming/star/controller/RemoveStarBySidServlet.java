package com.jiaming.star.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiaming.baseservlet.BaseServlet;
import com.jiaming.entity.User;
import com.jiaming.star.service.StarService;

/**
 * Servlet implementation class RemoveStarBySidServlet
 */
@WebServlet("/star/RemoveStarBySidServlet")
public class RemoveStarBySidServlet extends BaseServlet {

	@Autowired
	private StarService starService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");

		starService.removeStarBySid(sid);

		User user = (User) request.getSession().getAttribute("user");
		String uid = user.getUid();
		response.sendRedirect("GetStarsByUidServlet?uid=" + uid);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
