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
      .header{
        width: 1000px;
        height: 150px;
        margin-top: 20px;
        display: flex;
      }

  </style>
  <title>메인임</title>
</head>
<body>
<%
String id = (String) request.getSession().getAttribute("userId");
MemberDto dto = new MemberDao().getMemberinfo(id);

%>
  <div>
    <div style="width: 1000px; height: 150px; margin-top: 20px; display: flex;">
      <div style="font-size: 35px;">
        메인페이지
      </div>
      <div style="margin-left: 500px; font-size: 15px;">
        <%=dto.getId() + "(" + dto.getName() + ")"%>씨안녕하세요
        <br>
        포인트 : <%=dto.getPoint()%>점
      </div>
      <div>
        <button onclick="location.href='logout'">로그아웃</button>
      </div>
    </div>
    <div style="font-size: 20px; font-weight: 600;">구입할 컨텐츠를 선택하세요.</div>
    <div style="margin-top: 3dvi;">
      <div style="display: flex;">
        <div style="text-align: center;">
        <a href="UsePoint?product=intro">
        <img src="img/Intro_350_408.png" alt=""></a>
          <br>
          <br>
          100,000포인트
        </div>
        <div style="margin-left: 2px; text-align: center;">
          <a href="UsePoint?product=java">
            <img src="img/Java_350_408.png" alt="">
          </a>
          <br>
          <br>
          500,000포인트</div>
        <div style="margin-left: 2px; text-align: center;">
          <a href="UsePoint?product=c">
            <img src="img/Cpp_350_408.png" alt="">
          </a>
          <br>
          <br>
          300,000포인트</div>
      </div>
    </div>
    <br>
    <br>
    <div style="border: 1px solid black; margin-left: 900px; width: 280px;">
      &lt;광고>
      <br>
      <a href="UsePoint?product=ad">
        <img src="img/korea_it.png" alt="">
      </a>

    </div>
  </div>
</body>
</html>