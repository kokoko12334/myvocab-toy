<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영어단어장 홈화면</title>
</head>

<body>

	<div>
		<form action = "/login" method = "post" >
			<input type = "text" name = "id" placeholder = "아이디">
			<input type = "password" name = "pwd" placeholder = "비밀번호">
			<input type = "submit" value = "로그인">
			
		</form>
	</div>

	<div>
		<button type="button" class="navyBtn" onClick="location.href='joinForm.jsp'">회원가입
	</div>


</body>

</html>