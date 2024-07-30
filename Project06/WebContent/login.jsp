<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지임</title>
</head>
<body>
	<div style="border: 1px solid black; width: 400px; height: 300px;">
		<h1>로그인</h1>
		<br>
		<br>
		<form action="Controller" method="post">
		ID : <input type="text" name="id">
		<br>
		PW : <input type="password" name="pw">
		<br>
		<button style="width: 200px;">작성완료</button>
		<input type="hidden" name="controller" value="logincheck">

		</form>
		<button style="width: 200px;" onclick="location.href='createnew.jsp'">회원가입</button>
	</div>
</body>
</html>