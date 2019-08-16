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
			System.out.println(file.getDaOrigin());
			System.out.println(file.getDaChange());
			System.out.println(file.getDaPath());
			
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
	public ArrayList<Deal> selectList(Connection conn,int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> dList = new ArrayList<Deal>();
		String query = prop.getProperty("selectDList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2,limit);
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
	public ArrayList<DealAttachment> selectDFList(Connection conn,int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> daList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectDFList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2,limit);
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
	public int getDealCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset =null;
		int count = 0;
		String query = prop.getProperty("getDealCount");
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
				count= rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return count;
	}
}
