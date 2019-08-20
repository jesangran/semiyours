package mypage.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import member.model.dao.MemberDao;
public class MypageDao {
	
	private Properties prop = new Properties();
	public MypageDao() {
		String fileName = MemberDao.class.getResource("/sql/mypage/mypage-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertPick(Connection conn, int pickNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertPick");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, pickNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int pickCheck(Connection conn, int pickNo, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count =0;
		String query = prop.getProperty("checkPick");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, pickNo);
			pstmt.setInt(2, userNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public ArrayList<Deal> selectPick(Connection conn,int start,int limit, int uno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> pList = new ArrayList<Deal>();
		String query = prop.getProperty("selectPick");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, uno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, limit);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				pList.add(new Deal(rset.getInt(2),rset.getString(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getString("DEAL_LOCAL")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pList;
	}

	public ArrayList<DealAttachment> selectPickFile(Connection conn, int start, int limit, int uno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> pfList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectPickFile");
		DealAttachment da =null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, uno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, limit);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				da= new DealAttachment();
				da.setDaChange(rset.getString(2));
				pfList.add(da);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pfList;
	}

	public int deletePick(Connection conn, int dNo,int uNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteMyPick");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uNo);
			pstmt.setInt(2, dNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
