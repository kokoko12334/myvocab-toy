<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>

<body>

	<a href = "home.jsp">홈으로</a>
	
	<form action = "/join" method = "post" >     
        <table >
            <tr>
                <td>아이디 <input type = "text" name = "id"   style="margin-left:50px"></td>
            </tr>    
            <tr>
                <td>비밀번호 <input type = "password" name = "pwd" style="margin-left:35px"></td>
            </tr>
            <tr>
                <td>비밀번호 확인<input type = "password" name = "pwd_check" style="margin-left:3px"></td>
            </tr>
            <tr>
                <td>이름<input type = "text" name = "name" style="margin-left:73px"></td>
            </tr>
            <tr>
                <td>성별 <input style="margin-left:65px" type="radio" name="gender" value="여자">여성 
                <input type="radio" name="gender" value="남자">남성 </td>
            </tr>
            <tr>
                <td>생일<input type = "date" name = "birthday" style="margin-left:73px"></td>
            </tr>
            <tr>
                <td>전화번호 
                    <select name = "phone1" style="margin-left:33px">
                    <option value = "02">02</option>
                    <option value = "011">011</option>
                    <option value = "010">010</option>
                    </select><input type = 'tel' name = 'phone2'><input type = 'tel' name = 'phone3'></td>
            </tr>
            <tr>
                <td>이메일 <input type = "text" name = "email" style="margin-left:48px"> @ 
                    <select name = "dotcom">
                        <option value = "0">선택</option>
                        <option value = "naver.com">naver.com</option>
                        <option value = "daum.net">daum.net</option>
                        <option value = "gamail.com">gamail.com</option>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td><input type = "submit" value = "작성 완료"></td>
            </tr>
        </table>
    </form>

</div>
</body>

</html>