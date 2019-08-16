package report.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import report.model.dao.ReportDao;
import report.model.vo.Report;

public class ReportService {


	/**
	 * 신고 작성용
	 * @param report
	 * @return
	 */
	public int insertReport(Report report) {
		Connection conn = getConnection();
		int result = new ReportDao().insertReport(conn, report);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int getReportCount() {
		Connection conn = getConnection();
		int reportCount = new ReportDao().getReportCount(conn);
		
		return reportCount;
	}

	public ArrayList<Report> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Report> rList = new ReportDao().selectList(conn, currentPage, limit);
		
		return rList;
	}

}
