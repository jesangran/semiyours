package message.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import message.model.dao.MessageDao;
import message.model.vo.Message;

public class MessageService {

	/**
	 * 쪽지 수신함 조회용 
	 * @return
	 */
	public ArrayList<Message> recieveList(int userNo) {
		Connection conn = getConnection();
		ArrayList<Message> mList = new MessageDao().recieveList(conn, userNo);
		
		return mList;
	}

	public ArrayList<Message> sendList(int userNo){
		Connection conn = getConnection();
		ArrayList<Message> mList = new MessageDao().sendList(conn, userNo);
		
		return mList;
	}

	public Message RecieveselectMsg(int mno) {
		Connection conn = getConnection();
		Message msg = new MessageDao().RecieveselectMsg(conn, mno);
		return msg;
	}

	public int changeCondition(int mno) {
		
		Connection conn = getConnection();
		int result = new MessageDao().changeCondition(conn, mno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public Message SendselectMsg(int mno) {
		
		Connection conn = getConnection();
		Message msg = new MessageDao().SendselectMsg(conn, mno);
		
		return msg;
	}

	public int recieveMsgDelete(int mno) {
		Connection conn = getConnection();
		int result = new MessageDao().recieveMsgDelete(conn, mno);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int MessageInsert(Message msg) {
		Connection conn = getConnection();

		int result = new MessageDao().MessageInsert(conn, msg);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}





}
