package servlet;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstAjax
 */
@WebServlet("/Ajax1")
public class Ajax1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("GET 요청을 처리했습니다.");
        System.out.println("GET 요청이 들어옴");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        System.out.println("POST 요청이 들어옴");

        // JSON 데이터 읽기
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonData = sb.toString();

        // JSON 데이터 출력
        System.out.println("받은 JSON 데이터: " + jsonData);

        // 응답으로 간단한 메시지 전송
        response.setContentType("application/json");
        response.getWriter().write("{\"status\":\"success\", \"message\":\"데이터 수신 성공\"}");
    }
}
