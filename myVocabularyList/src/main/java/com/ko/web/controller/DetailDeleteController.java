package com.ko.web.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ko.web.entity.WordsDto;
import com.ko.web.service.WordsService;


@WebServlet("/deleteword")
public class DetailDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
	
		String id = (String) session.getAttribute("id");
		String vocabName = (String) session.getAttribute("vocabName");
		String english = req.getParameter("english");
		String korean = req.getParameter("korean");
		int index = Integer.parseInt(req.getParameter("idx"));
		
		WordsDto dto = new WordsDto(id, vocabName, english, korean);
		
		
		WordsService wordsSvc = new WordsService();
		
		
		try {
			int result = wordsSvc.deleteWord(dto);
			String encodeName = URLEncoder.encode(vocabName, "UTF-8");
			resp.sendRedirect("/detail?id="+ id + "&name=" + encodeName);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
}
