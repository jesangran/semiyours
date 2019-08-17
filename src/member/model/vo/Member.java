package member.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	private int userNo;
	private String email;
	private String pwd;
	private String nickName;
	private String grade;
	private String address1;
	private String address2;
	private String snsId;
	private char status;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	private int blackCount;
	private char blackStatus;
	private Date bClearDate;

	public Member() {
		super();
	}
	
	public Member(int userNo, String email, String pwd, String nickName, String grade, String address1, String address2,
			String snsId, char status, Timestamp enrollDate, Timestamp modifyDate, int blackCount, char blackStatus,Date bClearDate) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.grade = grade;
		this.address1 = address1;
		this.address2 = address2;
		this.snsId = snsId;
		this.status = status;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.blackCount = blackCount;
		this.blackStatus = blackStatus;
		this.bClearDate=bClearDate;
	}
	
	

	public Member(String email, String pwd, String nickName) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
	}

	public Member(int userNo, String address1, String address2, String snsId) {
		super();
		this.userNo = userNo;
		this.address1 = address1;
		this.address2 = address2;
		this.snsId = snsId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getBlackCount() {
		return blackCount;
	}

	public void setBlackCount(int blackCount) {
		this.blackCount = blackCount;
	}

	public char getBlackStatus() {
		return blackStatus;
	}

	public void setBlackStatus(char blackStatus) {
		this.blackStatus = blackStatus;
	}
	
	public Date getbClearDate() {
		return bClearDate;
	}

	public void setbClearDate(Date bClearDate) {
		this.bClearDate = bClearDate;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", email=" + email + ", pwd=" + pwd + ", nickName=" + nickName + ", grade="
				+ grade + ", address1=" + address1 + ", address2=" + address2 + ", snsId=" + snsId + ", status="
				+ status + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", blackCount=" + blackCount
				+ ", blackStatus=" + blackStatus + ", bClearDate=" + bClearDate + "]";
	}

	
}

	