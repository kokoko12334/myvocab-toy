package com.ko.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ko.web.service.VocabService;

@WebServlet("/addvocab")
public class AddVocabController extends HttpServlet {

	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		String id = (String)session.getAttribute("id");
		String vocabName = req.getParameter("vocabName");
		
		
		
		VocabService vocabSvc = new VocabService();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		try {
			
			int result = vocabSvc.addVocab(id, vocabName);
			
			if(result == -1) {
				out.println("<script>");
				out.println("alert('단어장 이름이 이미 있습니다.');");
				out.println("history.back()");
				out.println("</script>"); 
			}else if(result == -2) {
				out.println("<script>");
				out.println("alert('생성할 단어장 이름을 입력해주세요.');");
				out.println("history.back()");
				out.println("</script>");
			}else {
				System.out.println(result);
				resp.sendRedirect("/login");
				
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
