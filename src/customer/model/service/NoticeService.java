package customer.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import customer.model.dao.FaqDao;
import customer.model.dao.Notice_Dao;
import customer.model.vo.NoticeVo;

import static common.JDBCTemplate.*;
public class NoticeService {
	
	// FAQ 게시판 
	public ArrayList<NoticeVo> notice_selectList(int currentPage, int nLimit) {
		Connection conn = getConnection();
		
		ArrayList<NoticeVo> list = new Notice_Dao().Notice_selectList(conn, currentPage, nLimit);
		return list;
	}
	
	/*
	public int getFAQCount() {
		Connection conn = getConnection();
		
		int NoticeCount = new FAQ_Dao().getNoticecount(conn);
		
		return NoticeCount;
	}
	*/

	public NoticeVo noticeDetail(int nNo) {
		Connection conn = getConnection();
		
		NoticeVo Detail = new Notice_Dao().Detail(nNo, conn);
		return Detail;
	}

	public int nCount() {
		Connection conn = getConnection();
		
		int nCount = new Notice_Dao().nCount(conn);
		
		return nCount;
	}

	/*
	 * public ArrayList<FAQ_vo> selectPageList(int currentPage, int noticelimit) {
	 * Connection conn = getConnection(); System.out.println(1); ArrayList<FAQ_vo>
	 * list = new FAQ_Dao().selectPageList(conn, currentPage, noticelimit);
	 * 
	 * return list; }
	 */


	
}
