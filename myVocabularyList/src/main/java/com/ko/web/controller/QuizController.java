package com.ko.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ko.web.service.WordsService;


@WebServlet("/quiz")
public class QuizController extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String vocabName = req.getParameter("name");
		HttpSession session = req.getSession(false);
		
		session.setAttribute("vocabName", vocabName); // 단어장 이름도 저장
		
		WordsService svc = new WordsService();
		
		
		try {
			
			List<List<String>> list = svc.getwords(id, vocabName);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/myvocabulary/quiz.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
