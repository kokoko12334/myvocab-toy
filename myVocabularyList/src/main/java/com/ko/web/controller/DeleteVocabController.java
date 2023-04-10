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

import com.ko.web.entity.WordsDto;
import com.ko.web.service.VocabService;
import com.ko.web.service.WordsService;

@WebServlet("/deleteVocab")
public class DeleteVocabController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String vocabName = req.getParameter("name");
		int index = Integer.parseInt(req.getParameter("idx"));
		HttpSession session = req.getSession(false);
		
		try {
			
			// 해당 단어장의 단어 삭제
			
			WordsDto dto = new WordsDto();
			dto.setId(id);
			dto.setVocabName(vocabName);
			String english;
			String korean;
			
			WordsService wordsSvc = new WordsService();
			List<List<String>> wordsList =  wordsSvc.getwords(id, vocabName);
			
			int result;
			for(List<String> i: wordsList) {
				english = i.get(0);
				korean = i.get(1);
				dto.setEnglish(english);
				dto.setKorean(korean);
				
				result = wordsSvc.deleteWord(dto);
			}
			
			
			//단어장 삭제
			VocabService vocabSvc = new VocabService();
			result = vocabSvc.deleteVocab(id, vocabName);
			resp.sendRedirect("/login");
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
}