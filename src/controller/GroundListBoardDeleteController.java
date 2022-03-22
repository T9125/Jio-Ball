package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.GroundInfo;
import service.face.GroundListService;
import service.impl.GroundListServiceImpl;

@WebServlet("/manager/delete")
public class GroundListBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 서비스 객체
	private GroundListService groundListBoardService = new GroundListServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	      
		if(session.getAttribute("managerNo") == null) {
			System.out.println("ManagerInfo [managerNo=" + session.getAttribute("managerNo") + "]");
			System.out.println("Connection Unavailable [Redirect]");
			resp.sendRedirect("/manager/login");
		} else {
			System.out.println("/manager/delete [GET]");
			
			GroundInfo groundNo = groundListBoardService.getGroundNo(req);
			
			groundListBoardService.groundDelete(groundNo);
			
			resp.sendRedirect("/manager/groundlistboard");
		}
	}
}
