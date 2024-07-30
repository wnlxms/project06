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

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		switch (dao.logincheck(id, pw)) {
			case 0: {
				out.println("<html>");
				out.println("<head>");
				out.println("<title></title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<script>");
				out.println("alert('아이디/비밀번호를 다시 확인하세요');");
				out.println("history.back();");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");
				return;
			}
			case 2: {
				request.getSession().setAttribute("userId", id);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				return;
			}
		}
		request.getSession().setAttribute("userId", id);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
