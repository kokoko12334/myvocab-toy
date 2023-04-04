package com.ko.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false); // 기존에 세션이 존재하면 그 객체 반환, 없으면 null
		
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		
		
		session.removeAttribute(id);
		
		resp.sendRedirect("/home.jsp");
		
	}
}
