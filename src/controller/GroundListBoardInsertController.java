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

@WebServlet("/manager/insert")
public class GroundListBoardInsertController extends HttpServlet {
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
			System.out.println("/manage/ground/insert [GET]");
		
			//VIEW 지정 및 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/manager/insert.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
HttpSession session = req.getSession();
		
		if(session.getAttribute("managerNo") == null) {
			System.out.println("ManagerInfo [managerNo=" + session.getAttribute("managerNo") + "]");
			System.out.println("Connection Unavailable [Redirect]");
			resp.sendRedirect("/manager/login");
		} else {
			System.out.println("/manage/ground/insert [POST]");
			
			// 구장 정보 전달파라미터 추출하기
			GroundInfo groundInfo = groundListBoardService.getGroundInfo(req);
			
			// 구장 정보 등록 처리
			groundListBoardService.groundInsert(groundInfo);
			
	 		System.out.println(("구장 등록 완료"));
			
			// 메인으로 리다이렉트
			resp.sendRedirect("/manager/insertcomplete");
		}
	}
}
