package customer.model.dao;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;
import customer.model.vo.NoticeVo;


public class Notice_Dao {
	
	private Properties prop = new Properties();
	
	public Notice_Dao() {
		String fileName = NoticeVo.class.getResource("/sql/notice/customer-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 공지사항 리스트 Dao
	public ArrayList<NoticeVo> Notice_selectList(Connection conn, int currentPage, int nLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeVo> list = null;
		// 쿼리문 불러오기
		// selectList = SELECT * FROM NOTICE WHERE STATUS = 'Y' ORDER BY NNO DESC
		String query = prop.getProperty("selectPageList");
		System.out.println("DAO" + query);
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage - 1) * nLimit + 1;
			int endRow = startRow + nLimit -1;
			System.out.println("startRow: " + startRow + ", " + endRow);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<NoticeVo>();
			
			// rset.next 다음 내용이 있으면
			while(rset.next()) {
				NoticeVo no = new NoticeVo(rset.getInt("NOTICE_NO"),
						           			 rset.getString("NOTICE_TITLE"),
						           			 rset.getDate("NOTICE_ENROLLDATE"),
						           			 rset.getInt("NOTICE_COUNT")
						   ); 
			list.add(no);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}
	// 상세페이지 Dao
	public NoticeVo Detail(int nNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		NoticeVo Detail = null;
		
		String query = prop.getProperty("niticeDetail");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 제목, 등록일, 내용
				Detail = new NoticeVo(
							rset.getInt("NOTICE_NO"),
							rset.getString("NOTICE_TITLE"),
							rset.getString("NOTICE_CONTENT"),
							rset.getDate("NOTICE_ENROLLDATE")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return Detail;
	}
	// 조회수 dao
	public int getNoticecount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int NoticeCount = 0;
		
		String query = prop.getProperty("Noticecount");
		/*
		 * #Notice-query.properries 
		 * getNoticeCount=SELECT COUNT(*) FROM NOTICE WHERE MANAGER_NO=2
		 */
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				NoticeCount = rset.getInt(2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return NoticeCount;
	}
	public int nCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int nCount = 0;
		
		String query = prop.getProperty("Noticecount");
		/*
		 * #Notice-query.properries 
		 * getNoticeCount=SELECT COUNT(*) FROM NOTICE WHERE MANAGER_NO=2
		 */
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				nCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return nCount;
	}

	/*
	 * public ArrayList<NoticeVo> selectPageList(Connection conn, int currentPage,
	 * int noticelimit) { PreparedStatement pstmt = null; ResultSet rset = null;
	 * ArrayList<NoticeVo> list = null; System.out.println("2"); String query =
	 * prop.getProperty("selectPageList"); System.out.println("3"); try { pstmt =
	 * conn.prepareStatement(query);
	 * 
	 * int startRow = (currentPage - 1) * noticelimit + 1; int endRow = startRow +
	 * noticelimit -1;
	 * 
	 * pstmt.setInt(1, 2); pstmt.setInt(2, startRow); pstmt.setInt(3, endRow);
	 * 
	 * rset = pstmt.executeQuery(); list = new ArrayList<NoticeVo>();
	 * while(rset.next()) { NoticeVo nCount = new NoticeVo( rset.getInt("NOTICENO"),
	 * rset.getString("NOTITLE"), rset.getString("NOTICECONTENT"),
	 * rset.getDate("NOTICEENROLLDATE"), rset.getInt("NOTICECOUNT"),
	 * rset.getInt("MANAGERNO")); list.add(nCount); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally { close(rset);
	 * close(pstmt); }
	 * 
	 * return list; }
	 */
}






























