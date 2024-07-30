<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지임</title>
</head>
<body>
	<div>
		<h1>회원가입</h1>
		<br>
		<br>
		<form action="Controller" method="post">
			ID : <input type="text" name="id" required>
			<br>
			PW : <input type="text" name="pw" required>
			<br>
			NAME : <input type="text" name="name" required>
			<br>
			<input type="hidden" name="controller" value="createaccount">
			<button>작성완료</button>
		</form>
	</div>
</body>
</html>