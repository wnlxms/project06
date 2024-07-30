<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
     table {
            width: 50%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black; /* 경계선 추가 */
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
  </style>
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
  ArrayList<MemberDto> list = new MemberDao().getAllMemberinfo();
  %>
  <title>Document</title>
</head>
<body>
  <div style="display:flex;">
    <div style="font-size: 30px; font-weight: 900;">회원관리</div>
    <div style="margin-left: 1100px;"><button onclick="location.href='login.jsp'">로그인</button></div>
  </div>
  <table>
    <tr>
        <th>ID</th>
        <th>PW</th>
        <th>Name</th>
        <th>Point</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <%for(int i = 0; i < list.size(); i++) {%>
    <tr>
        <td><%=list.get(i).getId()%></td>
        <td><%=list.get(i).getPw()%></td>
        <td><%=list.get(i).getName()%></td>
        <td><%=list.get(i).getPoint()%></td>
		<td><button onclick="window.location.href='modify.jsp?id=<%=list.get(i).getId()%>'">수정</button></td>
        <td><button onclick="location.href='DeletememberID?id=<%=list.get(i).getId()%>'">삭제</button></td>
    </tr>
    <%}%>
  </table>
  <br><br><br><br><br>
  <h1>스케줄러관리</h1> 
  <button>스케줄러(20초마다 포인트 1증가) 실행시작</button>
  <button>스케줄러실행종료</button>

</body>
</html>