package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.GroundInfo;
import util.Paging;

public interface GroundListDao {
	/**
	 * 
	 * 구장 목록 조회 (페이징 처리 추가)
	 * 
	 * @param conn					- DB 연결 객체
	 * @param playlocalNo			- 지역 번호
	 * @param searchValue			- 검색어
	 * @param paging				- 페이징
	 * @return List<GroundInfo>		- 조회된 구장 정보 목록 
	 */
	public List<GroundInfo> selectGroundList(Connection conn, GroundInfo playLocalNo, String searchValue, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn 					- DB 연결 객체
	 * @return int 					- 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 전달된 groundNo의 게시글 조회
	 * 
	 * @param conn					- DB 연결 객체
	 * @param groundNo 				- 조회할 게시글의 groundNo
	 * @return GroundInfo			- 조회된 게시글의 상세정보
	 */
	public GroundInfo selectGroundListByGroundNo(Connection conn, GroundInfo groudNo);
	
	/**
	 * 
	 * 구장 게시판 목록 조회 (페이징 처리 추가)
	 * 
	 * @param conn					- DB 연결 객체
	 * @param searchValue			- 검색어
	 * @param paging				- 페이징
	 * @return List<GroundInfo>		- 조회된 구장 정보 목록 
	 */
	public List<GroundInfo> selectGroundBoardList(Connection conn, String searchValue, Paging paging);
	
	/**
	 * 구장 정보 등록
	 * 
	 * @param conn					- DB연결 객체
	 * @param groundInfo 			- 구장 정보
	 * @return int 					- 수행 결과
	 */
	public int insert(Connection conn, GroundInfo groundInfo);
	
	/**
	 * 구장 정보 수정
	 * 
	 * @param conn					- DB연결 객체
	 * @param groudNo 				- 수정할 구장의 groundNo
	 * @param groundInfo 			- 구장 정보
	 * @return int 					- 수행 결과
	 */
	public int update(Connection conn, GroundInfo groudNo);
	
	/**
	 * 구장 정보 삭제
	 * 
	 * @param conn					- DB연결 객체
	 * @param groudNo 				- 삭제할 구장의 groundNo
	 * @param groundInfo 			- 구장 정보
	 * @return int 					- 수행 결과
	 */
	public int delete(Connection conn, GroundInfo groudNo);
}

	
