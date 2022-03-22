package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.GroundInfo;
import service.face.GroundListService;
import service.impl.GroundListServiceImpl;
import util.Paging;

@WebServlet("/manager/groundlistboard")
public class GroundListBoardController extends HttpServlet {
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
			System.out.println("/manager/groundlistboard [GET]");
			
			// 전달 파라미터에 대한 한글 인코딩 설정 (UTF-8)
			req.setCharacterEncoding("UTF-8");
			
			// 검색 전달 파라미터 얻어오기
			String searchValue = req.getParameter("searchValue");
	
			// 페이징 전달 파라미터에서 현재 페이징 객체 알아내기
			Paging paging = groundListBoardService.getPaging(req);
			
			// 게시글 페이징 목록 조회
			List<GroundInfo> groundBoardList = groundListBoardService.getGroundList(searchValue, paging);
			
			req.setAttribute("groundBoardList", groundBoardList);
			req.setAttribute("paging", paging);
			
			//VIEW 지정 및 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/manager/groundListBoard.jsp").forward(req, resp);
	    }
	}
}