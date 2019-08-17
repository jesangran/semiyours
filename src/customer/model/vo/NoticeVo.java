package customer.model.vo;

import java.sql.Date;

public class NoticeVo {
	private int noticeNo; // 공지사항 글번호
	private String noticeTitle; // 공지사항 제목
	private String noticeContent; // 공지사항 내용
	private Date noticeEnrolldate; // 공지사항 작성일 // 다른곳에서 불러오기도 고려
	private int noticeCount; // 조회수
	private int managerNo; // 관리자 번호
	// 작성자 즉, 관리자이므로 불러오는걸로 고려

	public NoticeVo() {
		// TODO Auto-generated constructor stub
	}

	
	
	// 공지사항 리스트용
	public NoticeVo(int noticeNo, String noticeTitle, Date noticeEnrolldate, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeEnrolldate = noticeEnrolldate;
		this.noticeCount = noticeCount;
	}



	// 공지사항 상세조회용
	public NoticeVo(int noticeNo, String noticeTitle, String noticeContent, Date noticeEnrolldate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeEnrolldate = noticeEnrolldate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}



	public String getNoticeTitle() {
		return noticeTitle;
	}



	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}



	public String getNoticeContent() {
		return noticeContent;
	}



	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}



	public Date getNoticeEnrolldate() {
		return noticeEnrolldate;
	}



	public void setNoticeEnrolldate(Date noticeEnrolldate) {
		this.noticeEnrolldate = noticeEnrolldate;
	}



	public int getNoticeCount() {
		return noticeCount;
	}



	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}



	public int getManagerNo() {
		return managerNo;
	}



	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}



	@Override
	public String toString() {
		return "Norice_vo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeEnrolldate=" + noticeEnrolldate + ", noticeCount=" + noticeCount + "]";
	}

}
