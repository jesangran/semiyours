package customer.model.service;

import java.io.File;
import java.sql.Connection;


import customer.model.dao.QnaDao;
import customer.model.vo.QnaAttachment;
import customer.model.vo.QnaVo;
import static common.JDBCTemplate.*;

public class QnaService {

	public int insertBoard(QnaVo qBoard) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertBoard(conn, qBoard);
		System.out.println("서비스 "+ result);
		if(result > 0) {
			commit(conn);
		}else {
			
			rollback(conn);
		}
		
		return result;
	}
	
	public int insertBoard(QnaVo qBoard, QnaAttachment file) {
		Connection conn = getConnection();
		
		QnaDao qDao = new QnaDao();
		// 글등록 dao	
		int result1 = qDao.insertBoard(conn, qBoard);
		// 파일 등록
		int result2 = qDao.insertFile(conn, file);
		System.out.println(result2);
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			// DB 저장 실패시 파일 삭제 
			String savePath = file.getQaPath();
			String saveFile = file.getQaChange();
			File failedFile = new File(savePath + saveFile);
			
			failedFile.delete();
			
			result1 = 0;
			rollback(conn);
		}
		return result1;
		
		
	}
}
