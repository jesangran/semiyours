package customer.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import static common.JDBCTemplate.*;

import customer.model.vo.NoticeVo;
import customer.model.vo.QnaAttachment;
import customer.model.vo.QnaVo;

public class QnaDao {

	private Properties prop = new Properties();

	public QnaDao() {
		String fileName = NoticeVo.class.getResource("/sql/notice/customer-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(Connection conn, QnaVo qBoard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");

		try {
			pstmt = conn.prepareStatement(query);
													  // 문의
			pstmt.setString(1, qBoard.getqType());    // - 유형
			pstmt.setString(2, qBoard.getqTitle());   // - 제목
			pstmt.setString(3, qBoard.getQcontent()); // - 내용
			pstmt.setInt(4, qBoard.getqWriter());     // - 번호

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertFile(Connection conn, QnaAttachment file) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("insertFile 쿼리 진행 전 : file - " + file);
		String query = prop.getProperty("insertFile");
		System.out.println("query : " + query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, file.getQaOrigin());
			pstmt.setString(2, file.getQaChange());
			pstmt.setString(3, file.getQaPath());
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
			// 업데이트를 실행하다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("result : " + result);
		return result;
	}
}
