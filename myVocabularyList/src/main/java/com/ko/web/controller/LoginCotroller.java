package com.ko.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ko.web.entity.MembersDto;
import com.ko.web.service.MemberService;

@WebServlet("/login")
public class LoginCotroller extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberService svc = new MemberService();
		
		try {
			
			MembersDto dto = svc.getInfoByid(id);
			
			if (dto != null) {
				String pwd_check = dto.getPwd();
			
				if (pwd.equals(pwd_check)) {
					System.out.println("로그인 성공");
					HttpSession session = req.getSession();
					session.setAttribute("id", id);
					req.getRequestDispatcher("/WEB-INF/views/myvocabulary/mynotes.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("/home.jsp"); //비밀번호 불일치시
					}
			
			}else {
				resp.sendRedirect("/home.jsp"); // 아이디가 존재하지 않을 시
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
