package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDto;

/**
 * Servlet implementation class UsePoint
 */
@WebServlet("/UsePoint")
public class UsePoint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>");
		
		String id = (String) request.getSession().getAttribute("userId");
		if(id == null) {
			out.println("alert('로그인부터하세요');");
			out.println("location.href='login.jsp'");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
		}
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.getMemberinfo(id);
		System.out.println(dto);
		
		switch (request.getParameter("product")) {
			case "intro": {
				if (dto.getPoint() >= 100000) {
					dao.payProduct(id, 100000, "intro");
					out.println("alert('컨텐트(intro)를 구입하였습니다.');");
					out.println("location.href='main.jsp';");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				} else {
					out.println("alert('포인트가 부족합니다. 광고를 클릭하세요.');");
					out.println("history.back();");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				}
				break;
			}
			case "java": {
				if (dto.getPoint() >= 500000) {
					dao.payProduct(id, 500000, "java");
					out.println("alert('컨텐트(java)를 구입하였습니다.');");
					out.println("location.href='main.jsp';");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				} else {
					out.println("alert('포인트가 부족합니다. 광고를 클릭하세요.');");
					out.println("history.back();");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				}
				break;
			}
			case "c": {
				if (dto.getPoint() >= 300000) {
					dao.payProduct(id, 300000, "c++");
					out.println("alert('컨텐트(C++)를 구입하였습니다.');");
					out.println("location.href='main.jsp';");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				} else {
					out.println("alert('포인트가 부족합니다. 광고를 클릭하세요.');");
					out.println("history.back();");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				}
				break;
			}
			case "ad": {
				int point = (int)(Math.random()*1000) + 1;
				dao.viewAd(id, point);
				out.println("alert('"+point+"점이 적립되었습니다.');");
				out.println("location.href='https://www.koreaisacademy.com';");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
