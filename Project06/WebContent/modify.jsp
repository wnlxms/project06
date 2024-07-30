<%@page import="dao.MemberDao"%>
<%@page import="dao.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String) request.getSession().getAttribute("userId");
System.out.println("id = " + id);
if(id == null || !(id.equals("admin"))){				
	out.println("<script>");
	out.println("alert('관리자로 로그인하세요');");
	out.println("location.href='login.jsp'");
	out.println("</script>");
	out.println("</body>");
	out.println("</html>");
}
String memid = request.getParameter("id");
MemberDto dto = new MemberDao().getMemberinfoadmin(memid); %>
<h1>회원관리-수정관리자</h1>
<form action="Modify">
ID : <input type="text" name="id" readonly value="<%=dto.getId()%>">
PW : <input type="text" name="pw" value="<%=dto.getPw()%>">
Name : <input type="text" name="name" value="<%=dto.getName()%>">
Point : <input type="text" name="point" value="<%=dto.getPoint()%>">
<button>제출</button>
</form>
</body>
</html>