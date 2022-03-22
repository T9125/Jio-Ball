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

@WebServlet("/manager/update")
public class GroundListBoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 서비스 객체
	private GroundListService groundListBoardService = new GroundListServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/manage/ground/update [GET]");
		
		// 전달파라미터 얻기 - groundNo
		GroundInfo groundNo = groundListBoardService.getGroundNo(req);
		
		// 상세보기 결과 조회
		GroundInfo groundInfo = groundListBoardService.getGroundInfo(groundNo); 
		
		// 조회결과 MODEL값 전달
		req.setAttribute("groundInfo", groundInfo);
		
		//VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/manager/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/manage/ground/update [POST]");
		
		// 구장 정보 전달파라미터 추출하기
		GroundInfo groundInfo = groundListBoardService.getGroundInfo(req);
		
		// 구장정보 수정 처리
		groundListBoardService.groundUpdate(groundInfo);
		
 		resp.sendRedirect("/manager/updatecomplete");
	}
}
