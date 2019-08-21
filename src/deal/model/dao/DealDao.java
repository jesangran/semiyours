
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
import deal.model.vo.DealComment;
import deal.model.vo.Local;
import member.model.dao.MemberDao;

public class DealDao {
	private Properties prop = new Properties();

	public DealDao() {
		String fileName = MemberDao.class.getResource("/sql/deal/deal-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Category1> selectCategory1(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectCategory1");
		ArrayList<Category1> cList = new ArrayList<Category1>();
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				cList.add(new Category1(rset.getInt(1), rset.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return cList;
	}

	public ArrayList<Category2> selectCategory2(Connection conn, int cNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectCategory2");
		ArrayList<Category2> cList = new ArrayList<Category2>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				cList.add(new Category2(rset.getInt(1), rset.getString(2), rset.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}

	public int insertDeal(Connection conn, Deal deal) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertDeal");
		System.out.println(query);
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deal.getDealWriter());
			pstmt.setString(2, deal.getDealTitle());
			pstmt.setString(3, deal.getDealContent());
			pstmt.setInt(4, deal.getDealCount());
			pstmt.setInt(5, Integer.parseInt(deal.getDept1()));
			pstmt.setInt(6, Integer.parseInt(deal.getDept2()));
			pstmt.setString(7, deal.getDealLocal());
			pstmt.setInt(8, deal.getPrice());
			pstmt.setInt(9, deal.getDealType());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertFile(Connection conn, DealAttachment file) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertFile");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, file.getDaOrigin());
			pstmt.setString(2, file.getDaChange());
			pstmt.setString(3, file.getDaPath());
			pstmt.setInt(4, file.getFileLevel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int getDealCount(Connection conn, String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		String query = prop.getProperty("getDealCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, local + "%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				count = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	public int getDealCount(Connection conn, String keyword, String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		String query = prop.getProperty("getDealSearchCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setString(4, local + "%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				count = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			rset = pstmt.executeQuery();
			if (rset.next()) {
				deal = new Deal(rset.getInt("DEAL_NO"), rset.getInt("DEAL_WRITER"), rset.getString("NICKNAME"),
						rset.getString("DEAL_TITLE"), rset.getString("DEAL_CONTENT"),
						rset.getTimestamp("DEAL_ENROLLDATE"), rset.getInt("DEAL_COUNT"), rset.getInt("DEAL_STATUS"),
						rset.getString("DEPT1_NAME"), rset.getString("DEPT2_NAME"), rset.getString("DEAL_LOCAL"),
						rset.getInt("PRICE"), rset.getInt("DEAL_TYPE"), rset.getInt("VIEWCOUNT"), rset.getInt("R_TYPE"),
						rset.getString("GNAME"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return deal;
	}


	public ArrayList<DealAttachment> selectFile(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> daList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectFile");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				daList.add(new DealAttachment(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6).charAt(0), rset.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return daList;
	}

	public int getRecentDNo(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int dno = 0;
		String query = prop.getProperty("getRecentDNo");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				dno = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return dno;
	}


	public ArrayList<DealAttachment> selectLocalDaList(Connection conn, int begin, int limit, String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> daList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectLDAList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, local + "%");
			pstmt.setInt(2, begin);
			pstmt.setInt(3, limit);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				daList.add(new DealAttachment(rset.getString(4), rset.getString(3), rset.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return daList;
	}

	public int increaseViewCount(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("increaseViewCount");
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Local> selectLocal(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Local> lList = new ArrayList<Local>();
		String query = prop.getProperty("selectLocal");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				lList.add(new Local(rset.getInt(1), rset.getString(2), rset.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return lList;
	}

	public int updateStatus(Connection conn, int dealNo, int statusNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateStatus");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, statusNo);
			pstmt.setInt(2, dealNo);
			result = pstmt.executeUpdate();


   public int increaseViewCount(Connection conn, int dealNo) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("increaseViewCount");
      System.out.println(query);
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, dealNo);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public ArrayList<Local> selectLocal(Connection conn) {
      Statement stmt = null;
      ResultSet rset = null;
      ArrayList<Local> lList = new ArrayList<Local>();
      String query = prop.getProperty("selectLocal");

      try {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         while (rset.next()) {
            lList.add(new Local(rset.getInt(1), rset.getString(2), rset.getString(3)));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(stmt);
      }
      return lList;
   }

   public int updateStatus(Connection conn, int dealNo, int statusNo) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("updateStatus");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, statusNo);
         pstmt.setInt(2, dealNo);
         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int deleteDealfile(Connection conn, int dealNo) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("deleteDealfile");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, dealNo);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int updateDeal(Connection conn, Deal deal) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("updateDeal");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, deal.getDealTitle());
         pstmt.setString(2, deal.getDealContent());
         pstmt.setInt(3, deal.getDealCount());
         pstmt.setInt(4, Integer.parseInt(deal.getDept1()));
         pstmt.setInt(5, Integer.parseInt(deal.getDept2()));
         pstmt.setString(6, deal.getDealLocal());
         pstmt.setInt(7, deal.getPrice());
         pstmt.setInt(8, deal.getDealType());
         pstmt.setInt(9, deal.getDealNo());
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int insertUpdateFile(Connection conn, int dealNo, DealAttachment da) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("insertUpdateFile");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, da.getDaOrigin());
         pstmt.setString(2, da.getDaChange());
         pstmt.setString(3, da.getDaPath());
         pstmt.setInt(4, dealNo);
         pstmt.setInt(5, da.getFileLevel());
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }


	public int deleteDealfile(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteDealfile");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateDeal(Connection conn, Deal deal) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateDeal");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deal.getDealTitle());
			pstmt.setString(2, deal.getDealContent());
			pstmt.setInt(3, deal.getDealCount());
			pstmt.setInt(4, Integer.parseInt(deal.getDept1()));
			pstmt.setInt(5, Integer.parseInt(deal.getDept2()));
			pstmt.setString(6, deal.getDealLocal());
			pstmt.setInt(7, deal.getPrice());
			pstmt.setInt(8, deal.getDealType());
			pstmt.setInt(9, deal.getDealNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertUpdateFile(Connection conn, int dealNo, DealAttachment da) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertUpdateFile");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, da.getDaOrigin());
			pstmt.setString(2, da.getDaChange());
			pstmt.setString(3, da.getDaPath());
			pstmt.setInt(4, dealNo);
			pstmt.setInt(5, da.getFileLevel());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<DealAttachment> selectDeletedFileName(Connection conn, int dealNo) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		ArrayList<DealAttachment> deleteList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectDeletedFileName");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				deleteList.add(new DealAttachment(rset.getString(3),rset.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return deleteList;
	}
	
	public int insertComment(Connection conn, DealComment dComment) {
		PreparedStatement pstmt = null;
		int result=0;
		String query=prop.getProperty("insertComment");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(dComment.getDealCommWriter()));
			pstmt.setString(2, dComment.getDealCommContent());
			pstmt.setInt(3, dComment.getRefDealNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<DealComment> selectComment(Connection conn,int dealNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealComment> commList = new ArrayList<DealComment>();
		String query =prop.getProperty("selectComment");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				commList.add(new DealComment(rset.getInt(1),
											rset.getString(2),
											rset.getString(3),
											rset.getTimestamp(4),
											rset.getString(5).charAt(0),
											rset.getInt(6),
											rset.getTimestamp(7),
											rset.getInt(8)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return commList;
	}

	public ArrayList<Deal> selectCategoryList(Connection conn,int start,int limit,String cName,String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> csList = new ArrayList<Deal>();
		String query = prop.getProperty("selectCDList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cName);
			pstmt.setString(2, cName);
			pstmt.setString(3, local + "%");
			pstmt.setInt(4, start);
			pstmt.setInt(5, limit);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				csList.add(new Deal(rset.getInt(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getInt(6),rset.getString(7),rset.getString("DEPT1_NAME"),rset.getString("DEPT2_NAME")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return csList;
	}

	public ArrayList<DealAttachment> selectCategoryDaList(Connection conn, int start, int limit, String cName,
			String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> cdaList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectCDAList");
		DealAttachment da=null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cName);
			pstmt.setString(2, cName);
			pstmt.setString(3, local+"%");
			pstmt.setInt(4, start);
			pstmt.setInt(5, limit);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				da= new DealAttachment();
				da.setDaChange(rset.getString(4));
				cdaList.add(da);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cdaList;
	}

	public int updateComment(Connection conn, String content, int cNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query=prop.getProperty("updateComment");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,content);
			pstmt.setInt(2, cNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteComment(Connection conn, int cNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query=prop.getProperty("deleteComment");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Deal> selectSearchList(Connection conn, int start, int limit, String keyword, String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> sdList = new ArrayList<Deal>();
		String query = prop.getProperty("selectSDList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,keyword);
			pstmt.setString(2,keyword);
			pstmt.setString(3,keyword);
			pstmt.setString(4, local + "%");
			pstmt.setInt(5, start);
			pstmt.setInt(6, limit);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				sdList.add(new Deal(rset.getInt(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getInt(6),rset.getString(7)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdList;
	}

	public ArrayList<DealAttachment> selectSearchDaList(Connection conn, int start, int limit, String keyword,
			String local) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DealAttachment> sdaList = new ArrayList<DealAttachment>();
		String query = prop.getProperty("selectSDAList");
		DealAttachment da=null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,keyword);
			pstmt.setString(2,keyword);
			pstmt.setString(3,"%"+keyword+"%");
			pstmt.setString(4, local+"%");
			pstmt.setInt(5, start);
			pstmt.setInt(6, limit);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				da= new DealAttachment();
				da.setDaChange(rset.getString(4));
				sdaList.add(da);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdaList;
	}

	



}
