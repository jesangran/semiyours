package message.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	// 수신함조회
	public ArrayList<Message> recieveList(Connection conn, int currentPage, int limit, int mowner) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> mList = null;

		String query = prop.getProperty("recieveList");
		System.out.println(query);

		try {
			pstmt = conn.prepareStatement(query);
			mList = new ArrayList<Message>();
			int startRow = (currentPage-1) * limit+1;
			System.out.println("startRow"+startRow);
			int endRow = startRow + limit -1;
			System.out.println("endRow"+endRow);
			
			pstmt.setInt(1, mowner);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {

				Message msg = new Message(rset.getInt("M_NO"), 
														 rset.getString("M_TITLE"),
														 rset.getString("M_CONTENT"),
														 rset.getString("NICKNAME"),
														 rset.getDate("M_ENROLLDATE"),
														 rset.getString("M_CONDITION").charAt(0));
				mList.add(msg);
				System.out.println("닉네임"+rset.getString("NICKNAME"));
				System.out.println("제목"+rset.getString("M_TITLE"));
				System.out.println("내용"+rset.getString("M_CONTENT"));
				System.out.println(msg);
			}
			System.out.println(mList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return mList;
	}

	// 발신함조회
	public ArrayList<Message> sendList(Connection conn, int currentPage, int limit, int msender) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> mList = null;
		String query = prop.getProperty("sendList");

		try {
			pstmt = conn.prepareStatement(query);
			mList = new ArrayList<Message>();
			int startRow = (currentPage-1) * limit+1;
			System.out.println("startRow"+startRow);
			int endRow = startRow + limit -1;
			System.out.println("endRow"+endRow);
			
			pstmt.setInt(1, msender);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			System.out.println("msender"+msender);
		
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Message msg = new Message(rset.getInt("M_NO"),
														rset.getString("M_TITLE"),
														 rset.getString("M_CONTENT"),
														 rset.getString("NICKNAME"),
														 rset.getDate("M_ENROLLDATE"),
														 rset.getString("M_CONDITION").charAt(0));
				
				System.out.println("닉네임"+rset.getString("NICKNAME"));
				System.out.println("제목"+rset.getString("M_TITLE"));
				System.out.println("내용"+rset.getString("M_CONTENT"));
				
				mList.add(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mList;
	}

	// 수신쪽지 상세조회
	public Message RecieveselectMsg(Connection conn, int mno, int mowner) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Message msg = null;

		String query = prop.getProperty("RecieveSelectMsg");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mowner);
			pstmt.setInt(2, mno);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				msg = new Message(rset.getString("M_TITLE"),
											 rset.getString("M_CONTENT"),
											 rset.getString("NICKNAME"),
											 rset.getDate("M_ENROLLDATE")
				// SELECT M_TITLE, M_CONTENT, NICKNAME, M_ENROLLDATE FROM MESSAGE LEFT JOIN
				// MEMBER ON (M_SENDER = USER_NO) WHERE M_OWNER = ? AND M_NO = ?;
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
	
	//수신쪽지 확인 시 읽음 업데이트
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

	//발신쪽지 상세조회
	public Message SendselectMsg(Connection conn, int msender, int mno) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Message msg = null;

		String query = prop.getProperty("SendSelectMsg");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msender);
			pstmt.setInt(2, mno);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				msg = new Message(rset.getString("M_TITLE"),
											 rset.getString("M_CONTENT"),
											 rset.getString("NICKNAME"),
											 rset.getDate("M_ENROLLDATE")
				// SELECT M_TITLE, M_CONTENT, NICKNAME, M_ENROLLDATE FROM MESSAGE LEFT JOIN
				// MEMBER ON (M_SENDER = USER_NO) WHERE M_SENDER = ? AND M_NO = ?;
				);
				System.out.println("[msg]"+msg);
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

	public int MessageInsert(Connection conn, Message msg) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("MessageInsert");
		System.out.println("쿼리" + query);

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msg.getmOwner()); // 받는사람
			System.out.println("받는사람" + msg.getmOwner());
			pstmt.setString(2, msg.getmTitle());
			System.out.println("제목" + msg.getmTitle());
			pstmt.setString(3, msg.getmContent());
			System.out.println("내용" + msg.getmContent());
			pstmt.setInt(4, msg.getmSender()); // 로그인유저
			System.out.println("작성자" + msg.getmSender());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int getMsgCount(Connection conn, int mowner) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int msgCount = 0;
		
		String query = prop.getProperty("getMsgCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mowner);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				msgCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return msgCount;
	}

	public int sendMsgCount(Connection conn, int msender) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int sendMsgCount = 0;
		
		String query = prop.getProperty("sendMsgCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msender);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sendMsgCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sendMsgCount;
	}

	public int newCountMsg(Connection conn, int mowner) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String query = prop.getProperty("newCountMsg");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mowner);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

}
