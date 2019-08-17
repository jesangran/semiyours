package customer.model.dao;


import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import customer.model.vo.FaqVo;



public class FaqDao {
	
	private Properties prop = new Properties();
	
	public FaqDao() {
		String fileName = FaqDao.class.getResource("/sql/notice/customer-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	// FAQ 게시판
	public ArrayList<FaqVo> FaqSelectList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<FaqVo> list = null;
		
		// 쿼리문 불러오기
		String query = prop.getProperty("FaqSelectList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<FaqVo>();
			
			// rset.next 다음 내용이 있으면
			while(rset.next()) {
				FaqVo fo = new FaqVo(rset.getInt("FAQ_NO"),
						           	   rset.getString("FAQ_TITLE"),
						           	   rset.getString("FAQ_CONTENT"),
						           	   rset.getString("FAQ_TYPE"),						           			 
						           	   rset.getInt("MANAGER_NO")); 
			list.add(fo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	*/

	public FaqVo Detail(int fno, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		FaqVo faqDetail = null;
		
		String query = prop.getProperty("faqDetail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {// 글 번호, 분류 유형, 제목, 내용, 
				faqDetail = new FaqVo(rset.getInt("FAQ_NO"),
									rset.getString("FAQ_TITLE"), 
									rset.getString("FAQ_CONTENT"), 
									rset.getString("FAQ_TYPE")
									);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return faqDetail;
	}

	// 전체 게시글 조회
	public int FaqCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int FaqCount = 0;
		
		String query = prop.getProperty("FaqCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			System.out.println("query: " + query);
			if(rset.next()) {
				FaqCount = rset.getInt(1);
				System.out.println("FaqCount: " + FaqCount);
			}
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		System.out.println("FaqCount: " + FaqCount);
		
		return FaqCount;
	}

	public ArrayList<FaqVo> FaqSelectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FaqVo> FaqList = null;
		
		String query = prop.getProperty("FaqSelectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			FaqList = new ArrayList<FaqVo>();
			
			while(rset.next()) {
				FaqVo b = new FaqVo(
						rset.getInt("FAQ_NO"),
			           	rset.getString("FAQ_TITLE"),
			           	rset.getString("FAQ_CONTENT"),
			           	rset.getString("FAQ_TYPE"),						           			 
			           	rset.getInt("MANAGER_NO") 
						);
				FaqList.add(b);
				System.out.println(FaqList);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return FaqList;
	}

	
	// FAQ 상세 페이지
	/*
	public int getNoticecount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int NoticeCount = 0;
		
		String query = prop.getProperty("Noticecount");
		
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
	*/
	/*
	public ArrayList<Notice_vo> selectPageList(Connection conn, int currentPage, int noticelimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice_vo> list = null;
		System.out.println("2");
		String query = prop.getProperty("selectPageList");
		System.out.println("3");
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage - 1) * noticelimit + 1;
			int endRow = startRow + noticelimit -1;
			
			pstmt.setInt(1, 2);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Notice_vo>();
			while(rset.next()) {
				Notice_vo nCount = new Notice_vo(
						rset.getInt("NOTICENO"),
	           			rset.getString("NOTITLE"),
	           			rset.getString("NOTICECONTENT"),
	           			rset.getDate("NOTICEENROLLDATE"),
	           			rset.getInt("NOTICECOUNT"),
	           			rset.getInt("MANAGERNO")); 
				list.add(nCount);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	*/


}
































