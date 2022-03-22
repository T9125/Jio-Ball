package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.GroundListDao;
import dto.GroundInfo;
import util.Paging;

public class GroundListDaoImpl implements GroundListDao {
	
	// SQL 수행 객체
	PreparedStatement ps = null;
	
	// 결과 집합 객체
	ResultSet rs = null;
	
	// --- 구장 목록 조회 ---
	@Override
	public List<GroundInfo> selectGroundList(Connection conn, GroundInfo playLocalNo, String searchValue, Paging paging) {
		
		// --- 공통 SQL작성 ---
		String sql = "";
		sql += "SELECT *";
		sql += "  FROM (SELECT ROWNUM RNUM";
		sql += "              ,B.*";
		sql += "          FROM (SELECT *";
		sql += "                  FROM GROUNDINFO";
		
		List<GroundInfo> list = new ArrayList<>();
		
		// 필터 X
		if (playLocalNo.getPlayLocalNo() == 0) {
			// 검색 X
			if (searchValue == null || searchValue == "") {
				sql += "                 ORDER BY GROUND_NO";
				sql += "               ) B";
				sql += "        )GROUND_INFO";
				sql += " WHERE RNUM BETWEEN ? AND ?";
				
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, paging.getStartNo());
					ps.setInt(2, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while (rs.next()) {
						GroundInfo groundInfo = new GroundInfo();
						
						groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
						groundInfo.setGroundName(rs.getString("GROUND_NAME"));
						groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
						groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
						groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
						groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
						groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
						groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
						groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
						groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
						groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
						groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
						groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
						groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
						groundInfo.setGroundImgName(rs.getString("GROUND_IMG_NAME"));
						groundInfo.setGroundImgPath(rs.getString("GROUND_IMG_PATH"));
						
						list.add(groundInfo);
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				return list;
			} else {
				// 검색 O
				sql += "                 WHERE UPPER(GROUND_NAME) LIKE UPPER(?)";
				sql += "                 ORDER BY GROUND_NO DESC";
				sql += "               ) B";
				sql += "        )GROUND_INFO";
				sql += " WHERE RNUM BETWEEN ? AND ?";
				
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, "%" + searchValue + "%");
					ps.setInt(2, paging.getStartNo());
					ps.setInt(3, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while (rs.next()) {
						GroundInfo groundInfo = new GroundInfo();
						
						groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
						groundInfo.setGroundName(rs.getString("GROUND_NAME"));
						groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
						groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
						groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
						groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
						groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
						groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
						groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
						groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
						groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
						groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
						groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
						groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
						groundInfo.setGroundImgName(rs.getString("GROUND_IMG_NAME"));
						groundInfo.setGroundImgPath(rs.getString("GROUND_IMG_PATH"));
						
						list.add(groundInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				return list;
			}
		}

		// 필터 O
		if (playLocalNo.getPlayLocalNo() != 0) {
			// 검색 X
			if (searchValue == null || searchValue == "") {
				sql += "                 WHERE PLAYLOCAL_NO = ?";
				sql += "                 ORDER BY GROUND_NO";
				sql += "               ) B";
				sql += "        )GROUND_INFO";
				sql += " WHERE RNUM BETWEEN ? AND ?";
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, playLocalNo.getPlayLocalNo());
					ps.setInt(2, paging.getStartNo());
					ps.setInt(3, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while (rs.next()) {
						GroundInfo groundInfo = new GroundInfo();
						
						groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
						groundInfo.setGroundName(rs.getString("GROUND_NAME"));
						groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
						groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
						groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
						groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
						groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
						groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
						groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
						groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
						groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
						groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
						groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
						groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
						groundInfo.setGroundImgName(rs.getString("GROUND_IMG_NAME"));
						groundInfo.setGroundImgPath(rs.getString("GROUND_IMG_PATH"));
						
						list.add(groundInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				return list;
			} else {
				// 검색 O
				sql += "                 WHERE PLAYLOCAL_NO = ?";
				sql += "                   AND UPPER(GROUND_NAME) LIKE UPPER(?)";
				sql += "                 ORDER BY GROUND_NO DESC";
				sql += "               ) B";
				sql += "        )GROUND_INFO";
				sql += " WHERE RNUM BETWEEN ? AND ?";
				
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, playLocalNo.getPlayLocalNo());
					ps.setString(2, "%" + searchValue + "%");
					ps.setInt(3, paging.getStartNo());
					ps.setInt(4, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while (rs.next()) {
						GroundInfo groundInfo = new GroundInfo();
						
						groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
						groundInfo.setGroundName(rs.getString("GROUND_NAME"));
						groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
						groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
						groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
						groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
						groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
						groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
						groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
						groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
						groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
						groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
						groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
						groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
						groundInfo.setGroundImgName(rs.getString("GROUND_IMG_NAME"));
						groundInfo.setGroundImgPath(rs.getString("GROUND_IMG_PATH"));
						
						list.add(groundInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				return list;
			}
		}
		return list;
	}
	
	// --- 총 게시글 수 조회 ---
	@Override
	public int selectCntAll(Connection conn) {
		
		// SQL 작성
		String sql = "";
		sql += "SELECT COUNT(*) CNT";
		sql += "  FROM GROUNDINFO";
		
		// 총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return count;
	}
	
	// --- 특정 groundNo의 게시글 조회 ---
	@Override
	public GroundInfo selectGroundListByGroundNo(Connection conn, GroundInfo groundNo) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT *";
		sql += "  FROM GROUNDINFO";
		sql += " WHERE GROUND_NO = ?";
		
		GroundInfo groundInfo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, groundNo.getGroundNo());
			
			rs = ps.executeQuery();

			while(rs.next()) {
				groundInfo = new GroundInfo();
				
				groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
				groundInfo.setGroundName(rs.getString("GROUND_NAME"));
				groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
				groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
				groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
				groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
				groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
				groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
				groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
				groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
				groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
				groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
				groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
				groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
				groundInfo.setGroundImgName(rs.getString("GROUND_IMG_NAME"));
				groundInfo.setGroundImgPath(rs.getString("GROUND_IMG_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return groundInfo;
	}

	// --- 구장 게시판 목록 조회 ---
	@Override
	public List<GroundInfo> selectGroundBoardList(Connection conn, String searchValue, Paging paging) {
		
		// --- 공통 SQL작성 ---
		String sql = "";
		sql += "SELECT *";
		sql += "  FROM (SELECT ROWNUM RNUM";
		sql += "              ,B.*";
		sql += "          FROM (SELECT *";
		sql += "                  FROM GROUNDINFO";
		
		List<GroundInfo> list = new ArrayList<>();
		
		if (searchValue == null || searchValue == "") {
			// 검색 X
			sql += "                 ORDER BY GROUND_NO";
			sql += "               ) B";
			sql += "        )GROUND_INFO";
			sql += " WHERE RNUM BETWEEN ? AND ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					GroundInfo groundInfo = new GroundInfo();
					
					groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
					groundInfo.setGroundName(rs.getString("GROUND_NAME"));
					groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
					groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
					groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
					groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
					groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
					groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
					groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
					groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
					groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
					groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
					groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
					groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
					
					
					list.add(groundInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			return list;
		} else {
			// 검색 O
			sql += "                 WHERE UPPER(GROUND_NAME) LIKE UPPER(?)";
			sql += "                 ORDER BY GROUND_NO DESC";
			sql += "               ) B";
			sql += "        )GROUND_INFO";
			sql += " WHERE RNUM BETWEEN ? AND ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, "%" + searchValue + "%");
				ps.setInt(2, paging.getStartNo());
				ps.setInt(3, paging.getEndNo());
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					GroundInfo groundInfo = new GroundInfo();
					
					groundInfo.setGroundNo(rs.getInt("GROUND_NO"));
					groundInfo.setGroundName(rs.getString("GROUND_NAME"));
					groundInfo.setGroundLocation(rs.getString("GROUND_LOCATION"));
					groundInfo.setGroundSize(rs.getString("GROUND_SIZE"));
					groundInfo.setGroundOpenTime(rs.getTimestamp("GROUND_OPENTIME"));
					groundInfo.setGroundCloseTime(rs.getTimestamp("GROUND_CLOSETIME"));
					groundInfo.setGroundShower(rs.getInt("GROUND_SHOWER"));
					groundInfo.setGroundParking(rs.getInt("GROUND_PARKING"));
					groundInfo.setGroundShoes(rs.getInt("GROUND_SHOES"));
					groundInfo.setGroundBib(rs.getInt("GROUND_BIB"));
					groundInfo.setGroundNotice(rs.getString("GROUND_NOTICE"));
					groundInfo.setGroundFee(rs.getInt("GROUND_FEE"));
					groundInfo.setPlayTypeNo(rs.getInt("PLAYTYPE_NO"));
					groundInfo.setPlayLocalNo(rs.getInt("PLAYLOCAL_NO"));
					
					
					list.add(groundInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			return list;
		}
	}

	// --- 구장 정보 등록 ---
	@Override
	public int insert(Connection conn, GroundInfo groundInfo) {
		
		String sql = "";
		
		sql += "INSERT INTO GROUNDINFO (GROUND_NO";
		sql += "                       ,GROUND_NAME";
		sql += "                       ,GROUND_LOCATION";
		sql += "                       ,GROUND_SIZE";
		sql += "                       ,GROUND_OPENTIME";
		sql += "                       ,GROUND_CLOSETIME";
		sql += "                       ,GROUND_SHOWER";
		sql += "                       ,GROUND_PARKING";
		sql += "                       ,GROUND_SHOES";
		sql += "                       ,GROUND_BIB";
		sql += "                       ,GROUND_NOTICE";
		sql += "                       ,GROUND_FEE";
		sql += "                       ,PLAYTYPE_NO";
		sql += "                       ,PLAYLOCAL_NO)";
		sql += "                VALUES (GROUNDINFO_SEQ.NEXTVAL";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?";
		sql += "                       ,?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, groundInfo.getGroundName());
			ps.setString(2, groundInfo.getGroundLocation());
			ps.setString(3, groundInfo.getGroundSize());
			ps.setTimestamp(4, groundInfo.getGroundOpenTime());
			ps.setTimestamp(5, groundInfo.getGroundCloseTime());
			ps.setInt(6, groundInfo.getGroundShower());
			ps.setInt(7, groundInfo.getGroundParking());
			ps.setInt(8, groundInfo.getGroundShoes());
			ps.setInt(9, groundInfo.getGroundBib());
			ps.setString(10, groundInfo.getGroundNotice());
			ps.setInt(11, groundInfo.getGroundFee());
			ps.setInt(12, groundInfo.getPlayTypeNo());
			ps.setInt(13, groundInfo.getPlayLocalNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}

	// --- 구장 정보 수정 ---
	@Override
	public int update(Connection conn, GroundInfo groundInfo) {
		
		String sql = "";
		
		sql += "UPDATE GROUNDINFO";
		sql += "   SET GROUND_NAME = ?";
		sql += "      ,GROUND_LOCATION = ?";
		sql += "      ,GROUND_SIZE = ?";
		sql += "      ,GROUND_OPENTIME = ?";
		sql += "      ,GROUND_CLOSETIME = ?";
		sql += "      ,GROUND_SHOWER = ?";
		sql += "      ,GROUND_PARKING = ?";
		sql += "      ,GROUND_SHOES = ?";
		sql += "      ,GROUND_BIB = ?";
		sql += "      ,GROUND_NOTICE = ?";
		sql += "      ,GROUND_FEE = ?";
		sql += "      ,PLAYTYPE_NO = ?";
		sql += "      ,PLAYLOCAL_NO = ?";
		sql += " WHERE GROUND_NO = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, groundInfo.getGroundName());
			ps.setString(2, groundInfo.getGroundLocation());
			ps.setString(3, groundInfo.getGroundSize());
			ps.setTimestamp(4, groundInfo.getGroundOpenTime());
			ps.setTimestamp(5, groundInfo.getGroundCloseTime());
			ps.setInt(6, groundInfo.getGroundShower());
			ps.setInt(7, groundInfo.getGroundParking());
			ps.setInt(8, groundInfo.getGroundShoes());
			ps.setInt(9, groundInfo.getGroundBib());
			ps.setString(10, groundInfo.getGroundNotice());
			ps.setInt(11, groundInfo.getGroundFee());
			ps.setInt(12, groundInfo.getPlayTypeNo());
			ps.setInt(13, groundInfo.getPlayLocalNo());
			ps.setInt(14, groundInfo.getGroundNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return res;
		
	}

	// --- 구장 정보 삭제 ---
	@Override
	public int delete(Connection conn, GroundInfo groundNo) {

		String sql = "";
		
		sql += "DELETE";
		sql += "  FROM GROUNDINFO";
		sql += " WHERE GROUND_NO = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, groundNo.getGroundNo());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}
}