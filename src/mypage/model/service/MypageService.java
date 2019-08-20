package mypage.model.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import mypage.model.dao.MypageDao;

public class MypageService {

	public MypageService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int insertPick(int pickNo, int userNo) {
		Connection conn = getConnection();
		MypageDao mpDao =new MypageDao();
		int count = mpDao.pickCheck(conn,pickNo,userNo);
		int result=0;
		if(count==0) {
			 result= mpDao.insertPick(conn, pickNo, userNo);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		

		return result;
	}

	public ArrayList<Deal> selectPick(int start, int limit,int uno) {
		Connection conn = getConnection();
		 ArrayList<Deal> pList = new MypageDao().selectPick(conn,start,limit,uno);
		return pList;
	}

	public ArrayList<DealAttachment> selectPickFile(int start, int limit, int uno) {
		Connection conn = getConnection();
		 ArrayList<DealAttachment> pfList = new MypageDao().selectPickFile(conn,start,limit,uno);
		return pfList;
	}

	public int deletePick(int dNo,int uno) {
		Connection conn = getConnection();
		int result = new MypageDao().deletePick(conn,dNo,uno);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

}
