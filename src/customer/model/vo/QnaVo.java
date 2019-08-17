package customer.model.vo;

import java.sql.Date;

public class QnaVo {
	private int qNo;
	private String qType;
	private String qTitle;
	private String qcontent;
	private int qWriter;
	private Date qRnrolldate;
	private String qAnswer;
	private int qStatusNo;
	
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
		this.qRnrolldate = qRnrolldate;
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
		return qRnrolldate;
	}

	public void setqRnrolldate(Date qRnrolldate) {
		this.qRnrolldate = qRnrolldate;
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
				+ qWriter + ", qRnrolldate=" + qRnrolldate + ", qAnswer=" + qAnswer + ", qStatusNo=" + qStatusNo + "]";
	}
	
}
