package message.model.vo;

import java.sql.Date;


public class Message {
	private int mNo;
	private int mOwner; //쪽지함 주인
	private String mTitle; //쪽지제목
	private String mContent; //쪽지내용
	private int mSender; //쪽지발신인
	private String nickname;
	private Date mEnrollDate; //쪽지발신일자
	private char mDeleteYN; //삭제상태
	private char mCondition; //열람여부
	
	public Message() {}

	//수신함, 발신함
	public Message(int mNo, String mTitle, String mContent, String nickname, Date mEnrollDate, char mCondition) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.nickname = nickname;
		this.mEnrollDate = mEnrollDate;
		this.mCondition = mCondition;
	}
	
	//수신상세조회	
	public Message(String mTitle, String mContent, String nickname, Date mEnrollDate) {
		super();
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.nickname = nickname;
		this.mEnrollDate = mEnrollDate;
	}
	

	public int getmNo() {
		return mNo;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getmOwner() {
		return mOwner;
	}

	public void setmOwner(int mOwner) {
		this.mOwner = mOwner;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public int getmSender() {
		return mSender;
	}

	public void setmSender(int mSender) {
		this.mSender = mSender;
	}

	public Date getmEnrollDate() {
		return mEnrollDate;
	}

	public void setmEnrollDate(Date mEnrollDate) {
		this.mEnrollDate = mEnrollDate;
	}

	public char getmDeleteYN() {
		return mDeleteYN;
	}

	public void setmDeleteYN(char mDeleteYN) {
		this.mDeleteYN = mDeleteYN;
	}

	public char getmCondition() {
		return mCondition;
	}

	public void setmCondition(char mCondition) {
		this.mCondition = mCondition;
	}
	
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Message [mNo=" + mNo + ", mOwner=" + mOwner + ", mTitle=" + mTitle + ", mContent=" + mContent
				+ ", mSender=" + mSender + ", nickname=" + nickname + ", mEnrollDate=" + mEnrollDate + ", mDeleteYN="
				+ mDeleteYN + ", mCondition=" + mCondition + "]";
	}


	
}
