package message.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;
import message.model.vo.Message;

public class MessageDao {
	
	private Properties prop = new Properties();
	public MessageDao() {
		String fileName = MessageDao.class.getResource("/sql/message/message-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Message> recieveList(Connection conn, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> mList = null;
		
		String query = prop.getProperty("recieveList");
		
		try {
			pstmt = conn.prepareStatement(query);
			mList = new ArrayList<Message>();
			System.out.println(query);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			System.out.println(query);
			while(rset.next()) {
				
				System.out.println("M_NO===["+rset.getInt("M_NO"));       
				System.out.println("M_OWNER===["+rset.getInt("M_OWNER"));     
				System.out.println("M_TITLE===["+rset.getString("M_TITLE"));  
				System.out.println("M_CONTENT===["+rset.getString("M_CONTENT"));
				System.out.println("NICKNAME===["+rset.getString("NICKNAME")); 
				System.out.println("M_ENROLLDATE===["+rset.getDate("M_ENROLLDATE"));
				System.out.println("M_CONDITION===["+rset.getString("M_CONDITION").charAt(0));
				
				Message msg = new Message(
								rset.getInt("M_NO"), 
								rset.getInt("M_OWNER"), 
								rset.getString("M_TITLE"),
								rset.getString("M_CONTENT"), 
								rset.getString("NICKNAME"), 
								rset.getDate("M_ENROLLDATE"),
								rset.getString("M_CONDITION").charAt(0));
						//(mNo, mOwner, mTitle, mContent, mSender, mEnrollDate, mCondition)
				mList.add(msg);
				System.out.println(msg);
			}
			System.out.println(mList);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mList;
	}
	
	public ArrayList<Message> sendList(Connection conn, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> mList = null;
		
		String query = prop.getProperty("sendList");
		
		System.out.println("userNo : " +  userNo);
		
		try{
			pstmt = conn.prepareStatement(query);
			mList = new ArrayList<Message>();
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			System.out.println("발신함==============");
			System.out.println(query);
			System.out.println("발신함==============");
			while(rset.next()) {
				
				System.out.println("M_NO===["+rset.getInt("M_NO"));                                     
				System.out.println("M_TITLE===["+rset.getString("M_TITLE"));                            
				System.out.println("M_ENROLLDATE===["+rset.getDate("M_ENROLLDATE"));                    
				System.out.println("M_CONDITION===["+rset.getString("M_CONDITION").charAt(0));          

				Message msg = new Message(
						rset.getInt("M_NO"), 
						rset.getInt("M_SENDER"), 
						rset.getString("M_TITLE"),
						rset.getString("M_CONTENT"), 
						rset.getString("NICKNAME"), 
						rset.getDate("M_ENROLLDATE"),
						rset.getString("M_CONDITION").charAt(0));
				//(mNo, mOwner, mTitle, mContent, mSender, mEnrollDate, mCondition)
				mList.add(msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return mList;
	}
	
	public Message RecieveselectMsg(Connection conn, int mno) { 
		
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		Message msg = null;
		
		String query = prop.getProperty("RecieveSelectMsg");
	  
		try{ 
			pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1, mno); 
			rset =pstmt.executeQuery();
			if(rset.next()) { 
				msg = new Message( rset.getInt("M_NO"),
											  rset.getInt("M_OWNER"), 
											  rset.getString("M_TITLE"),
											  rset.getString("M_CONTENT"),
											  rset.getString("NICKNAME"),
											  rset.getDate("M_ENROLLDATE"), 
											  rset.getString("M_CONDITION").charAt(0)
											  );
			}
	  } catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
		return msg; 
		
	}
	public int changeCondition(Connection conn, int mno) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeCondition");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public Message SendselectMsg(Connection conn, int mno) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		Message msg = null;
		
		String query = prop.getProperty("SendSelectMsg");
	  
		try{ 
			pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1, mno); 
			rset =pstmt.executeQuery();
			if(rset.next()) { 
				msg = new Message(rset.getInt("M_NO"), 
												rset.getInt("M_SENDER"), 
												rset.getString("M_TITLE"),
												rset.getString("M_CONTENT"), 
												rset.getString("NICKNAME"), 
												rset.getDate("M_ENROLLDATE"),
												rset.getString("M_CONDITION").charAt(0)
												);
			}
	  } catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
		return msg; 
	}
	public int recieveMsgDelete(Connection conn, int mno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("recieveMsgDelete");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	

}
