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
import deal.model.vo.DealComment;
import deal.model.vo.Local;

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
		ArrayList<Category2> cList = new DealDao().selectCategory2(conn, cNo);
		return cList;
	}

	public int insertDeal(Deal deal, ArrayList<DealAttachment> fileList) {
		Connection conn = getConnection();
		DealDao dDao = new DealDao();
		int result1 = dDao.insertDeal(conn, deal);
		int result2 = 0;
		for (int i = 0; i < fileList.size(); i++) {
			result2 = dDao.insertFile(conn, fileList.get(i));
			if (result2 == 0) {
				break;
			}
		}
		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			for (int i = 0; i < fileList.size(); i++) {
				String savePath = fileList.get(i).getDaPath();
				String saveFile = fileList.get(i).getDaChange();
				File failedFile = new File(savePath + saveFile);
				failedFile.delete();
			}

			rollback(conn);
		}

		return result1 * result2;

	}

	public ArrayList<Deal> selectList(int begin, int limit, String local) {
		Connection conn = getConnection();
		ArrayList<Deal> dList = null;
		dList = new DealDao().selectLocalDealList(conn, begin, limit, local);

		return dList;
	}

	public ArrayList<DealAttachment> selectDFList(int begin, int limit, String local) {
		Connection conn = getConnection();
		ArrayList<DealAttachment> daList = null;

		daList = new DealDao().selectLocalDaList(conn, begin, limit, local);

		return daList;
	}

	public int getDealCount(String local) {
		Connection conn = getConnection();
		int count = new DealDao().getDealCount(conn, local);
		return count;
	}

	public Deal selectDeal(int dealNo) {
		Connection conn = getConnection();
		DealDao dDao = new DealDao();
		Deal deal = dDao.selectDeal(conn, dealNo);
		if (deal != null) {
			int result = dDao.increaseViewCount(conn, dealNo);
			if (result > 0) {
				commit(conn);
			} else {
				deal = null;
				rollback(conn);
			}
			return deal;
		}

		return deal;
	}

	public ArrayList<DealAttachment> selectFile(int dealNo) {
		Connection conn = getConnection();

		ArrayList<DealAttachment> daList = new DealDao().selectFile(conn, dealNo);

		return daList;
	}

	public int getRecentDNo() {
		Connection conn = getConnection();
		int count = new DealDao().getRecentDNo(conn);
		return count;
	}

	public ArrayList<Local> selectLocal() {
		Connection conn = getConnection();
		ArrayList<Local> lList = new DealDao().selectLocal(conn);
		return lList;
	}

	public int updateStatus(int dealNo, int statusNo) {
		Connection conn = getConnection();
		int result = new DealDao().updateStatus(conn, dealNo, statusNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int updateDeal(Deal deal, ArrayList<DealAttachment> fileList) {
		Connection conn = getConnection();
		DealDao dDao = new DealDao();
		int result1 = dDao.updateDeal(conn, deal);
		int result2 = dDao.deleteDealfile(conn, deal.getDealNo());
		int result3 = 0;
		for (DealAttachment da : fileList) {
			result3 = dDao.insertUpdateFile(conn, deal.getDealNo(), da);
			if (result3 == 0) {
				break;
			}
		}
		ArrayList<DealAttachment> deleteList = dDao.selectDeletedFileName(conn, deal.getDealNo());
		if (result1 > 0 && result2 > 0 && result3 > 0 && !deleteList.isEmpty()) {
			for (int i = 0; i < deleteList.size(); i++) {
				String savePath = deleteList.get(i).getDaPath();
				String saveFile = deleteList.get(i).getDaChange();
				File failedFile = new File(savePath + saveFile);
				failedFile.delete();
			}
			commit(conn);
		} else {
			for (int i = 0; i < fileList.size(); i++) {
				String savePath = fileList.get(i).getDaPath();
				String saveFile = fileList.get(i).getDaChange();
				File failedFile = new File(savePath + saveFile);
				failedFile.delete();
			}
			result1 = 0;
			rollback(conn);
		}

		return result1;
	}
	public int insertComment(DealComment dComment) {
		Connection conn= getConnection();
		int result = new DealDao().insertComment(conn,dComment);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<DealComment> selectComment(int dealNo) {
		Connection conn= getConnection();
		ArrayList<DealComment> commList =new DealDao().selectComment(conn,dealNo);
		return commList;
	}

	public ArrayList<Deal> selectCategoryList(int start,int limit,String cName,String local) {
		Connection conn = getConnection();
		ArrayList<Deal> csList = new DealDao().selectCategoryList(conn,start,limit,cName,local);
		
		return csList;
	}

	public ArrayList<DealAttachment> selectCategoryDaList(int start, int limit, String cName, String local) {
		Connection conn = getConnection();
		ArrayList<DealAttachment> cdaList = null;

		cdaList = new DealDao().selectCategoryDaList(conn, start, limit,cName, local);

		return cdaList;
	}
	
	 

}
