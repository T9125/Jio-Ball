package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.GroundListDao;
import dao.impl.GroundListDaoImpl;
import dto.GroundInfo;
import service.face.GroundListService;
import util.Paging;

public class GroundListServiceImpl implements GroundListService {

	// DAO 객체
	private GroundListDao groundListDao = new GroundListDaoImpl(); 
	
	// --- 조회된 구장 목록 ---
	@Override
	public List<GroundInfo> getGroundList(GroundInfo playlocalNo, String searchValue, Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		// 조회 결과 반환
		return groundListDao.selectGroundList(conn, playlocalNo, searchValue, paging);
	}
	
	// --- 요청 파라미터 playlocalNo 얻어오기 ---
	@Override
	public GroundInfo getPlaylocalNo(HttpServletRequest req) {
		
		// 전달파라미터 playlocalNo 추출하기
		String param = req.getParameter("playlocalNo");
		
		// 전달파라미터 groundNo를 저장할 DTO객체 생성
		GroundInfo playlocalNo = new GroundInfo();
		
		if( param != null && !"".equals(param)) {
			playlocalNo.setPlayLocalNo(Integer.parseInt(param));
		}
		return playlocalNo;
	}

	// --- 계산이 완료된 페이징 ---
	@Override
	public Paging getPaging(HttpServletRequest req) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		
		int curPage = 0;
		
		if(param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		// 총 게시글 수 조회하기
		int totalCount = groundListDao.selectCntAll(conn);
		
		// Paging 객체 생성 - 페이징 계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	// --- 요청 파라미터 groundNo 얻어오기 ---
	@Override
	public GroundInfo getGroundNo(HttpServletRequest req) {
		
		// 전달파라미터 groundNo 추출하기
		String param = req.getParameter("groundNo");
		
		// 전달파라미터 groundNo를 저장할 DTO객체 생성
		GroundInfo groundNo = new GroundInfo();
		
		if( param != null && !"".equals(param)) {
			groundNo.setGroundNo(Integer.parseInt(param));
		}
		return groundNo;
	}
	
	// --- groudNo로 조회된 구장 정보 ---
	@Override
	public GroundInfo getGroundInfo(GroundInfo groundNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 조회
		GroundInfo groundInfo = groundListDao.selectGroundListByGroundNo(conn, groundNo);
		
		return groundInfo;
	}

	// --- 조회된 구장 게시판 목록 ---
	@Override
	public List<GroundInfo> getGroundList(String searchValue, Paging paging) {
		Connection conn = JDBCTemplate.getConnection();

		// 조회 결과 반환
		return groundListDao.selectGroundBoardList(conn,searchValue, paging);
	}
	
	// --- 구장 등록 ---
	@Override
	public void groundInsert(GroundInfo groundInfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(groundListDao.insert(conn, groundInfo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	// --- 요청 파라미터 얻어오기 ---
	@Override
	public GroundInfo getGroundInfo(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 전달파라미터 groundInfo를 저장할 DTO객체 생성
		GroundInfo groundInfo = new GroundInfo();
		
		String groundNo = req.getParameter("groundNo");
		String groundLocation = req.getParameter("groundLocation");
		String groundShower = req.getParameter("groundShower");
		String groundParking = req.getParameter("groundParking");
		String groundShoes = req.getParameter("groundShoes");
		String groundBib = req.getParameter("groundBib");
		String groundFee = req.getParameter("groundFee");
		String playTypeNo = req.getParameter("playTypeNo");
		
		if(groundNo != null && !"".equals(groundNo)) { 
			groundInfo.setGroundNo(Integer.parseInt(groundNo));
		} else {
		}
		
		groundInfo.setGroundName(req.getParameter("groundName"));
		
		groundInfo.setGroundLocation(req.getParameter("groundLocation"));
		
		groundInfo.setGroundSize(groundSize(req.getParameter("groundSizeWidth"), req.getParameter("groundSizeHeight")));
		
		groundInfo.setGroundOpenTime(groundOpenTime(req.getParameter("groundOpenTime")));
		
		groundInfo.setGroundCloseTime(groundCloseTime(req.getParameter("groundCloseTime")));
		
		if(groundShower != null && !"".equals(groundShower)) { 
			groundInfo.setGroundShower(Integer.parseInt(groundShower));
		}
		
		if(groundParking != null && !"".equals(groundParking)) {
			groundInfo.setGroundParking(Integer.parseInt(groundParking));
		}
		
		if(groundShoes != null && !"".equals(groundShoes)) {
			groundInfo.setGroundShoes(Integer.parseInt(groundShoes));
		}
		
		if(groundBib != null && !"".equals(groundBib)) {
			groundInfo.setGroundBib(Integer.parseInt(groundBib));
		}
		
		groundInfo.setGroundNotice(req.getParameter("groundNotice"));
		
		if(groundFee != null && !"".equals(groundFee)) {
			groundInfo.setGroundFee(Integer.parseInt(groundFee));
		}
		
		if(playTypeNo != null && !"".equals(playTypeNo)) {
			groundInfo.setPlayTypeNo(Integer.parseInt(playTypeNo));
		}
		
		if (groundLocation.substring(0, 6).contains("김해시")) {
			groundInfo.setPlayLocalNo(1);
		} else if (groundLocation.substring(0, 6).contains("부산")) {
			groundInfo.setPlayLocalNo(2);
		} else if (groundLocation.substring(0, 6).contains("양산시")) {
			groundInfo.setPlayLocalNo(3);
		} else if (groundLocation.substring(0, 6).contains("진주시")) {
			groundInfo.setPlayLocalNo(4);
		} else if (groundLocation.substring(0, 6).contains("창원시")) {
			groundInfo.setPlayLocalNo(5);
		}
		return groundInfo;
	}
	
	// --- 구장 가로 세로 길이 CONCAT ---
	public String groundSize(String width, String height) {
		
		String groundSize = width + "X" + height;
		
		return groundSize;
	}
	
	// --- 문자열로 구성된 GroundOpenTime Timestamp로 변환 ---
	public Timestamp groundOpenTime(String openTime) {
		
		Timestamp groundOpenTime = Timestamp.valueOf("1990-01-01 " + openTime);
		
		return groundOpenTime;
		
	}

	// --- 문자열로 구성된 GroundCloseTime Timestamp로 변환 ---
	public Timestamp groundCloseTime(String closeTime) {
		
		Timestamp groundCloseTime = Timestamp.valueOf("9999-12-31 " + closeTime);
		
		return groundCloseTime; 
	}

	
	// --- 구장 수정 ---
	@Override
	public void groundUpdate(GroundInfo groundNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(groundListDao.update(conn, groundNo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	
	// --- 구장 삭제 ---
	@Override
	public void groundDelete(GroundInfo groundNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if(groundListDao.delete(conn, groundNo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
}