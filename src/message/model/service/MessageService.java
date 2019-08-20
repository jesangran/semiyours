package message.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import message.model.dao.MessageDao;
import message.model.vo.Message;

public class MessageService {


	/**쪽지 수신함 조회용 
	 * @param currentPage
	 * @param limit
	 * @param userNo
	 * @return mList
	 */
	public ArrayList<Message> recieveList(int currentPage, int limit, int userNo) {
		Connection conn = getConnection();
		ArrayList<Message> mList = new MessageDao().recieveList(conn, currentPage, limit, userNo);
		
		return mList;
	}

	/**
	 * 쪽지 발신함
	 * @param currentPage
	 * @param limit
	 * @param userNo
	 * @return mList
	 */
	public ArrayList<Message> sendList(int currentPage, int limit, int userNo){
		Connection conn = getConnection();
		ArrayList<Message> mList = new MessageDao().sendList(conn, currentPage, limit, userNo);
		
		return mList;
	}

	/** 쪽지 수신 상세조회
	 * @param mno
	 * @param mowner
	 * @return msg
	 */
	public Message RecieveselectMsg(int mno, int mowner) {
		Connection conn = getConnection();
		Message msg = new MessageDao().RecieveselectMsg(conn, mno, mowner);
		return msg;
	}

	/** 수신쪽지 읽음처리
	 * @param mno
	 * @return result
	 */
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

	/** 쪽지 발신 상세조회
	 * @param msender
	 * @param mno
	 * @return
	 */
	public Message SendselectMsg(int msender, int mno) {
		
		Connection conn = getConnection();
		Message msg = new MessageDao().SendselectMsg(conn, msender, mno);
		
		return msg;
	}

	/** 수신쪽지 삭제처리
	 * @param mno
	 * @return result
	 */
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

	/** 쪽지 보내기
	 * @param msg
	 * @return result
	 */
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

	/** 수신쪽지 갯수
	 * @param userNo
	 * @return msgCount
	 */
	public int getMsgCount(int mowner) {
		Connection conn = getConnection();
		int msgCount = new MessageDao().getMsgCount(conn, mowner);
		
		return msgCount;
	}


	/** 발신 쪽지 갯수
	 * @param userNo
	 * @return sendMsgCount
	 */
	public int sendMsgCount(int msender) {
		Connection conn = getConnection();
		int sendMsgCount = new MessageDao().sendMsgCount(conn, msender);
		return sendMsgCount;
	}





}
