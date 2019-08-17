package customer.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import customer.model.dao.FaqDao;
import customer.model.vo.FaqVo;

import static common.JDBCTemplate.*;
public class FaqService {
	
	/*
	public int getNoticeCount() {
		Connection conn = getConnection();
		
		int NoticeCount = new FAQ_Dao().getNoticecount(conn);
		
		return NoticeCount;
	}
	*/

	public FaqVo faqDetail(int fno) {
		Connection conn = getConnection();
		
		 FaqVo faqDetail  = new FaqDao().Detail(fno, conn);
		 return faqDetail;
	}
	// FAQ 전체 게시글 수 측정
	public int FaqCount() {
		Connection conn = getConnection();
		
		int FaqCount = new FaqDao().FaqCount(conn);
		
		return FaqCount;
	}
	public ArrayList<FaqVo> FaqSelectList(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<FaqVo> FaqList = new FaqDao().FaqSelectList(conn, currentPage, limit);
		
		return FaqList;
	}
		


	
}
