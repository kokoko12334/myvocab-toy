package com.ko.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ko.web.entity.WordsDto;
import com.ko.web.service.WordsService;
import com.mysql.cj.xdevapi.JsonParser;


@WebServlet("/score")
public class ScoreController extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String id = (String)session.getAttribute("id");
		String vocabName = (String)session.getAttribute("vocabName");
		
		
		String scoreString = req.getParameter("score");
		String scoreDbString = req.getParameter("db_score");
		
	
		JSONParser parser = new JSONParser();
		WordsDto dto = new WordsDto();
		dto.setId(id);
		dto.setVocabName(vocabName);
		WordsService svc = new WordsService();
		try {
			JSONObject score = (JSONObject)parser.parse(scoreString);
			JSONObject scoreDb = (JSONObject)parser.parse(scoreDbString);
			
			
			Iterator<String> keyIter = score.keySet().iterator();
			while(keyIter.hasNext()) {
				String key = keyIter.next();
				
				String scoreQuiz = String.valueOf(score.get(key));
				
				String str = String.valueOf(scoreDb.get(key));
				
				
				String[] strArr = str.split("\\.");
				
				
				int son = Integer.parseInt(strArr[0]);
				int mother = Integer.parseInt(strArr[1]);
				son += Integer.parseInt(scoreQuiz);
				mother += 1;
				
				
				String result = Integer.toString(son)+ "." + Integer.toString(mother);
				dto.setEnglish(key);
				dto.setScore(result);
				
				
				int r = svc.updateScore(dto);
				System.out.println(r);
			}
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	
	
	}
	
	
}