package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.GroundInfo;
import service.face.GroundListService;
import service.impl.GroundListServiceImpl;

@WebServlet("/ground/view")
public class GroundViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private GroundListService groundListService = new GroundListServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/ground/view [GET]");
		
		// 전달파라미터 얻기 - groundNo
		GroundInfo groundNo = groundListService.getGroundNo(req);
		
		// 상세보기 결과 조회
		GroundInfo groundInfo = groundListService.getGroundInfo(groundNo); 
		
		// 조회결과 MODEL값 전달
		req.setAttribute("groundInfo", groundInfo);
		
		// VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/user/view.jsp").forward(req, resp);
	}
}