package customer.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import customer.model.dao.FaqDao;
import customer.model.dao.NoticeDao;
import customer.model.vo.NoticeVo;

import static common.JDBCTemplate.*;
public class NoticeService {
	
	// FAQ 게시판 
	public ArrayList<NoticeVo> notice_selectList(int currentPage, int nLimit) {
		Connection conn = getConnection();
		
		ArrayList<NoticeVo> list = new NoticeDao().Notice_selectList(conn, currentPage, nLimit);
		return list;
	}
	

	public NoticeVo noticeDetail(int nNo) {
		Connection conn = getConnection();
		
		NoticeDao nDao = new NoticeDao();
		
		NoticeVo Detail = nDao.Detail(nNo, conn);
		
		if(Detail != null) {
			int result = nDao.increaseCount(conn, nNo);
			if(result >0) {
				commit(conn);
				Detail.setNoticeCount(Detail.getNoticeCount()+1);
			}else {
				rollback(conn);
				Detail=null;
			}
		}
		
		return Detail;
	}

	public int nCount() {
		Connection conn = getConnection();
		
		int nCount = new NoticeDao().nCount(conn);
		
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
