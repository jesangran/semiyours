package deal.model.service;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import deal.model.dao.DealDao;
import deal.model.vo.Category1;
import deal.model.vo.Category2;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
public class DealService {
	public DealService() {
		super();
	}

	public ArrayList<Category1> selectCategory1() {
		Connection conn = getConnection();
		ArrayList<Category1> cList = new DealDao().selectCategory1(conn);
		return cList;
	}

	public ArrayList<Category2> selectCategory2(int cNo) {
		Connection conn = getConnection();
		ArrayList<Category2> cList = new DealDao().selectCategory2(conn,cNo);
		return cList;
	}

	public int insertDeal(Deal deal, DealAttachment file) {
		Connection conn = getConnection();
		DealDao dDao = new DealDao();
		int result1 = dDao.insertDeal(conn,deal);
		int result2=dDao.insertFile(conn,file);
		if(result1>0 && result2>0) {
			commit(conn);
		}else {
			String savePath = file.getDaPath();
			String saveFile = file.getDaChange();
			File failedFile= new File(savePath+ saveFile);
			failedFile.delete();
			rollback(conn);
		}
		return result1*result2;
	}

	public int insertDeal(Deal deal) {
		Connection conn = getConnection();
		DealDao dDao = new DealDao();
		int result = dDao.insertDeal(conn,deal);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Deal> selectList(int currPage,int limit) {
		Connection conn = getConnection();
		ArrayList<Deal> dList = new DealDao().selectList(conn,currPage,limit);
		
		return dList;
	}
	
	public ArrayList<DealAttachment> selectDFList(int currPage,int limit) {
		Connection conn = getConnection();
		ArrayList<DealAttachment> daList = new DealDao().selectDFList(conn,currPage,limit);
		
		return daList;
	}


	public int getDealCount() {
		Connection conn = getConnection();
		int count = new DealDao().getDealCount(conn);
		return count;
	}


}
