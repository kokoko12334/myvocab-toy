package com.ko.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VocabService {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/myvocab";
	String user = "test";
	String password = "1234";
	
	
	
	public List<String> getVocabsByid(String id) throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user,password);
		
		String sql = "SELECT vocab_name FROM vocab WHERE id = ? ";
		
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		List<String> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(rs.getString("vocab_name"));
		}
		
		rs.close();
		psmt.close();
		con.close();
		
		
		return list;
		
		
		
	}
	
	
	
	
	
	public int addVocab(String id, String vocabName) throws ClassNotFoundException, SQLException {
		//빈값 확인
		if(vocabName.equals("")) {
			return -2;
		}
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user,password);
		
		String sql = "INSERT INTO vocab VALUES(?,?)";
		
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, id);
		psmt.setString(2, vocabName);
		
		
		// 중복 여부 확인
		List<String> list =  getVocabsByid(id);
		for(String n: list) {
			if(n.equals(vocabName)) {
				return -1;
			}
		}
		
		
		int result = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return result;
	}
	
	public int deleteVocab(String id, String vocabName) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user,password);
		
		String sql = "DELETE FROM vocab WHERE id = ? AND vocab_name = ?";
		
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, id);
		psmt.setString(2, vocabName);
		
		
		int result = psmt.executeUpdate();
		
		
		psmt.close();
		con.close();
		
		
		return result;
		
		
		
	}
	
	
	
	
}
