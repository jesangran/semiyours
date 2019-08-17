package deal.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import deal.model.vo.Category1;
import deal.model.vo.Category2;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import deal.model.vo.Local;
import member.model.dao.MemberDao;

public class DealDao {
	private Properties prop = new Properties();
	public DealDao() {
		String fileName = MemberDao.class.getResource("/sql/deal/deal-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Category1> selectCategory1(Connection conn) {
		Statement stmt = null;
		ResultSet rset =null;
		String query = prop.getProperty("selectCategory1");
		ArrayList<Category1> cList = new ArrayList<Category1>();
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				cList.add(new Category1(rset.getInt(1),rset.getString(2)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return cList;
	}
	public ArrayList<Category2> selectCategory2(Connection conn, int cNo) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String query = prop.getProperty("selectCategory2");
		ArrayList<Category2> cList = new ArrayList<Category2>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				cList.add(new Category2(rset.getInt(1),rset.getString(2),rset.getInt(3)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}
	public int insertDeal(Connection conn, Deal deal) {
		PreparedStatement pstmt = null;
		int result=0;
		String query =prop.getProperty("insertDeal");
		System.out.println(query);
		try {
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,deal.getDealWirter());
			pstmt.setString(2, deal.getDealTitle());
			pstmt.setString(3,deal.getDealContent());
			pstmt.setInt(4, deal.getDealCount());
			pstmt.setInt(5,Integer.parseInt(deal.getDept1()));
			pstmt.setInt(6,Integer.parseInt(deal.getDept2()));
			pstmt.setString(7, deal.getDealLocal());
			pstmt.setInt(8, deal.getPrice());
			pstmt.setInt(9, deal.getDealType());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertFile(Connection conn, DealAttachment file) {
		PreparedStatement pstmt = null;
		int result=0;
		String query =prop.getProperty("insertFile");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, file.getDaOrigin());
			pstmt.setString(2, file.getDaChange());
			pstmt.setString(3, file.getDaPath());
			pstmt.setInt(4, file.getFileLevel());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//	public ArrayList<Deal> selectList(Connection conn,int currentPage, int limit) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<Deal> dList = new ArrayList<Deal>();
//		String query = prop.getProperty("selectDList");
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, currentPage);
//			pstmt.setInt(2,limit);
//			rset=pstmt.executeQuery();
//			while(rset.next()){
//				dList.add(new Deal(
//						rset.getInt(2),
//						rset.getString(3),
//						rset.getInt(4),
//						rset.getInt(5),						
//						rset.getInt(6)
//						));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return dList;
//	}
//	public ArrayList<DealAttachment> selectDFList(Connection conn,int currentPage, int limit) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<DealAttachment> daList = new ArrayList<DealAttachment>();
//		String query = prop.getProperty("selectDFList");
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, currentPage);
//			pstmt.setInt(2,limit);
//			rset=pstmt.executeQuery();
//			while(rset.next()){
//				daList.add(new DealAttachment(
//						rset.getString(4),
//						rset.getString(3),
//						rset.getInt(2)
//						));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return daList;
//	}
	public int getDealCount(Connection conn,String local) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int count = 0;
		String query = prop.getProperty("getDealCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, local+"%");
			rset=pstmt.executeQuery();
			if(rset.next()) {
				count= rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	public Deal selectDeal(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Deal deal = null;
		String query = prop.getProperty("selectDeal");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				deal = new Deal(
						rset.getInt("DEAL_NO"),
						rset.getString("NICKNAME"),
						rset.getString("DEAL_TITLE"),
						rset.getString("DEAL_CONTENT"),
						rset.getTimestamp("DEAL_ENROLLDATE"),
						rset.getInt("DEAL_COUNT"),
						rset.getInt("DEAL_STATUS"),
						rset.getString("DEPT1_NAME"),
						rset.getString("DEPT2_NAME"),
						rset.getString("DEAL_LOCAL"),
						rset.getInt("PRICE"),
						rset.getInt("DEAL_TYPE"),
						rset.getInt("VIEWCOUNT"),
						rset.getInt("R_TYPE")
						);
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return deal;
	}
	public ArrayList<DealAttachment> selectFile(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> daList =new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectFile");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				daList.add(new DealAttachment(rset.getInt(1),
												rset.getString(2),
												rset.getString(3),
												rset.getString(4),
												rset.getInt(5),
												rset.getString(6).charAt(0),
												rset.getInt(7))
												);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return daList;
	}
	public int getRecentDNo(Connection conn) {
		Statement stmt = null;
		ResultSet rset =null;
		int dno = 0;
		String query = prop.getProperty("getRecentDNo");
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
				dno= rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return dno;
	}
	public ArrayList<Deal> selectLocalDealList(Connection conn, int begin, int limit,String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> dList = new ArrayList<Deal>();
		String query = prop.getProperty("selectLDList");
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,local+"%");
			pstmt.setInt(2, begin);
			pstmt.setInt(3,limit);
			rset=pstmt.executeQuery();
			while(rset.next()){
				dList.add(new Deal(
						rset.getInt(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getInt(5),						
						rset.getInt(6)
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dList;
	}
	public ArrayList<DealAttachment> selectLocalDaList(Connection conn, int begin, int limit, String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> daList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectLDAList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,local+"%");
			pstmt.setInt(2, begin);
			pstmt.setInt(3,limit);
			rset=pstmt.executeQuery();
			while(rset.next()){
				daList.add(new DealAttachment(
						rset.getString(4),
						rset.getString(3),
						rset.getInt(2)
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return daList;
	}
	public int increaseViewCount(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = prop.getProperty("increaseViewCount");
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public ArrayList<Local> selectLocal(Connection conn) {
		Statement stmt = null;
		ResultSet rset =null;
		ArrayList<Local> lList = new  ArrayList<Local>();
		String query =prop.getProperty("selectLocal");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				lList.add(new Local(rset.getInt(1),rset.getString(2),rset.getString(3)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return lList;
	}
}
