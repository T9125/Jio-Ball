package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jioball/privacystatement")
public class PrivacyStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/jioball/privacyStatement [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/layout/privacyStatment.jsp").forward(req, resp);
	}
}
