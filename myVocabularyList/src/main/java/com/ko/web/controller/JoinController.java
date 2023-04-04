package com.ko.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ko.web.entity.MembersDto;
import com.ko.web.service.MemberService;

@WebServlet("/join")
public class JoinController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String birthday = req.getParameter("birthday");
		String phone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		String email = req.getParameter("email")+"@"+req.getParameter("dotcom");
		
		Date regdate = new Date();
		
		
		MembersDto dto =  new MembersDto(id,pwd,name,gender,birthday,phone,regdate,email);
		
		MemberService joinsvc = new MemberService();
		
		try {
			int result = joinsvc.insert(dto);
			System.out.println(result);
			req.getRequestDispatcher("/WEB-INF/views/join.html").forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		
	}
	
}
