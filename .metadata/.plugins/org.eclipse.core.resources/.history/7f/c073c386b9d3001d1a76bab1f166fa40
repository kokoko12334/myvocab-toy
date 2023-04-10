package com.ko.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ko.web.entity.MembersDto;

public class MemberService {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/myvocab";
	String user = "test";
	String password = "1234";
	
	public int insert(MembersDto dto) throws ClassNotFoundException, SQLException {
		
		
		String id = dto.getId();
		String pwd =  dto.getPwd();
		String name =  dto.getName();
		String gender = dto.getGender();
		String birthday = dto.getBirthday();
		String phone = dto.getPhone();
		Date regdate = dto.getRegdate();
		String email = dto.getEmail();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(regdate);
        java.sql.Date sql_regdate = java.sql.Date.valueOf(formattedDate);
		
        String sql = "INSERT INTO members VALUES(?,?,?,?,?,?,?,?)";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user,password);
		
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, id);
		psmt.setString(2, pwd);
		psmt.setString(3, name);
		psmt.setString(4, gender);
		psmt.setString(5, birthday);
		psmt.setString(6, phone);
		psmt.setDate(7, sql_regdate);
		psmt.setString(8, email);
		
		int result = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return result;
		
	}
	
	public MembersDto getInfoByid(String id) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user,password);
		
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, id);
		
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
		
		String pwd =  rs.getString("pwd");
		String name =  rs.getString("name");
		String gender = rs.getString("gender");
		String birthday = rs.getString("birthday");
		String phone = rs.getString("phone");
		Date regdate = rs.getDate("regdate");
		String email = rs.getString("email");
		
		MembersDto dto = new MembersDto(id,pwd,name,gender,birthday,phone,regdate,email);
		
		
		return dto;
		}else
			return null;
	}
	
}
