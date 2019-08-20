package customer.model.vo;

import java.sql.Date;

public class QnaVo {
	private int qNo;          // 문의번호
	private String qType;     // 문의유형
	private String qTitle;    // 문의제목
	private String qcontent;  // 문의내용
	private int qWriter;      // 문의자
	private Date qEnrolldate; // 문의일자
	private String qAnswer;   // 답변 내용
	private int qStatusNo;    // 문의 처리상태
	
	public QnaVo() {
		// TODO Auto-generated constructor stub
	}

	public QnaVo(int qNo, String qType, String qTitle, String qcontent, int qWriter, Date qRnrolldate, String qAnswer,
			int qStatusNo) {
		super();
		this.qNo = qNo;
		this.qType = qType;
		this.qTitle = qTitle;
		this.qcontent = qcontent;
		this.qWriter = qWriter;
		this.qEnrolldate = qRnrolldate;
		this.qAnswer = qAnswer;
		this.qStatusNo = qStatusNo;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public int getqWriter() {
		return qWriter;
	}

	public void setqWriter(int qWriter) {
		this.qWriter = qWriter;
	}

	public Date getqRnrolldate() {
		return qEnrolldate;
	}

	public void setqRnrolldate(Date qRnrolldate) {
		this.qEnrolldate = qRnrolldate;
	}

	public String getqAnswer() {
		return qAnswer;
	}

	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}

	public int getqStatusNo() {
		return qStatusNo;
	}

	public void setqStatusNo(int qStatusNo) {
		this.qStatusNo = qStatusNo;
	}

	@Override
	public String toString() {
		return "QnaVo [qNo=" + qNo + ", qType=" + qType + ", qTitle=" + qTitle + ", qcontent=" + qcontent + ", qWriter="
				+ qWriter + ", qEnrolldate=" + qEnrolldate + ", qAnswer=" + qAnswer + ", qStatusNo=" + qStatusNo + "]";
	}
}
