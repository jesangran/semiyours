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

			if(rset.next()) {
				FaqCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
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
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return FaqList;
	}
}
































