package report.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import report.model.vo.Report;
import static common.JDBCTemplate.*;

public class ReportDao {
	private Properties prop = new Properties();
	
	public ReportDao() {
		String fileName = ReportDao.class.getResource("/sql/report/report-query.properties").getPath();
		try{
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 신고물 작성용
	 * @param conn
	 * @param report
	 * @return result
	 */
	public int insertReport(Connection conn, Report report) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertReport");
		//INSERT INTO REPORT VALUES(SEQ_RNO.NEXTVAL, '게시글 욕설', SYSDATE, DEFAULT, 1, 33, 21, 1);
		
		//신고번호  ?(상세내용)  sysdate default ?(신고물유형), ?게시글번호 ?작성자  ?신고사유
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, report.getReportCon());
			pstmt.setInt(2, Integer.parseInt(report.getReportType()));
			pstmt.setInt(3, report.getNo());
			/* pstmt.setString(4, report.getReporter()); */
			pstmt.setInt(4, Integer.parseInt(report.getReportReason()));
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getReportCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int reportCount = 0;
		
		String query = prop.getProperty("getReportCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				reportCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return reportCount;
	}

	public ArrayList<Report> selectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Report> rList = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			int startRow=(currentPage -1)* limit +1;
			int endRow = startRow + limit-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Report>();
			
			while(rset.next()) {
				Report r = new Report(rset.getInt("REPORT_NO"), rset.getString("REPORTTYPE_NAME"),
						rset.getString("REASON_CONTENT"), rset.getString("REPORT_CON"),
						rset.getDate("REPORT_DATE"), rset.getInt("NO"));
				rList.add(r);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

}
