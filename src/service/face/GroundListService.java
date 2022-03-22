package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.GroundInfo;
import util.Paging;

public interface GroundListService {
	
	// ------------------------------------------ USER ------------------------------------------
	/**
	 * 구장 목록 조회
	 *
	 * @param playlocalNo			- 조회할 playlocalNo 값을 포함한 GroundInfo 객체
	 * @param searchValue			- 조회할 searchValue 값을 포함한 변수
	 * @param paging				- 조회할 paging 값을 포함한 Paging 객체
	 * @return List<GroundInfo> 	- 조회된 구장 목록 조회 결과
	 */
	public List<GroundInfo> getGroundList(GroundInfo playlocalNo, String searchValue, Paging paging);
	
	/**
	 * 요청 파라미터 지역 번호(playlocalNo) 얻어오기
	 * 
	 * @param req					- 요청 정보 객체
	 * @return GroundInfo			- 전달 파라미터 playlocalNo 값을 포함한 GroundInfo 객체
	 */
	public GroundInfo getPlaylocalNo(HttpServletRequest req);
	
	/**
	 * 요청 파라미터 페이징(paging) 얻어오기
	 * 
	 * @param req					- 요청 정보 객체
	 * @return Paging				- 전달 파라미터 paging 계산값을 포함한 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 구장 상세 정보 조회
	 * 
	 * @param groundNo 				- 조회할 groundNo 값을 포함한 GroundInfo 객체
	 * @return GroundInfo 			- 조회된 구장 상세 정보 조회 결과
	 */
	public GroundInfo getGroundInfo(GroundInfo groundNo);
	
	/**
	 * 요청 파라미터 구장 번호(groundNo) 얻어오기
	 * 
	 * @param req 					- 요청 정보 객체
	 * @return GroundInfo			- 전달 파라미터 groundNo 값을 포함한 GroundInfo 객체
	 */
	public GroundInfo getGroundNo(HttpServletRequest req);
	// ------------------------------------------------------------------------------------------
	
	// ---------------------------------------- MANAGER -----------------------------------------
	/**
	 * 구장 목록 조회
	 *
	 * @param searchValue			- 조회할 searchValue 값을 포함한 변수
	 * @param paging				- 조회할 paging 값을 포함한 Paging 객체
	 * @return List<GroundInfo> 	- 조회된 구장 목록 조회 결과
	 */
	public List<GroundInfo> getGroundList(String searchValue, Paging paging);
	
	/**
	 * 요청 파라미터 구장 정보(groundInfo) 얻어오기
	 * 
	 * @param req 					- 요청 정보 객체
	 * @return GroundInfo 			- 전달 파라미터 groundInfo 값을 포함한 GroundInfo 객체
	 */
	public GroundInfo getGroundInfo(HttpServletRequest req);

	/**
	 * 구장 등록 처리
	 * 
	 * @param GroundInfo 			- 구장 등록 정보 객체
	 */
	public void groundInsert(GroundInfo groundInfo);
	
	/**
	 * 구장 수정 처리
	 * 
	 * @param GroundNo 				- 수정할 groundNo 값을 포함한 GroundInfo 객체
	 */
	public void groundUpdate(GroundInfo groundNo);
	
	/**
	 * 구장 삭제 처리
	 * 
	 * @param GroundNo 				- 삭제할 groundNo 값을 포함한 GroundInfo 객체
	 */
	public void groundDelete(GroundInfo groundNo);
	// ------------------------------------------------------------------------------------------
}