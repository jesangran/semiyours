package report.model.vo;

import java.sql.Date;

public class Report {
	private int reportNo; // 신고번호
	private String reportType; // 신고물유형
	private int reportReason; // 신고사유
	private String reportCon; // 신고상세내용
	private Date reportDate; // 신고일자
	private int reportStatus; // 신고처리상태
	private int no; // 신고 글번호
	private String reporter; // 신고자

	public Report() {
	}

	public Report(int reportNo, String reportType,int reportReason, String reportCon, Date reportDate, int no) {
		super();
		this.reportNo = reportNo;
		this.reportType = reportType;
		this.reportReason = reportReason;
		this.reportCon = reportCon;
		this.reportDate = reportDate;
		this.no = no;
	}

	public Report(int reportNo, String reportType, int reportReason, String reportCon, Date reportDate,
			int reportStatus, int no, String reporter) {
		super();
		this.reportNo = reportNo;
		this.reportType = reportType;
		this.reportReason = reportReason;
		this.reportCon = reportCon;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.no = no;
		this.reporter = reporter;
	}

	public Report(String reportType,int reportReason, String reportCon, int no) {
		super();
		this.reportType = reportType;
		this.reportReason = reportReason;
		this.reportCon = reportCon;
		this.no = no;

	}


	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public int getReportReason() {
		return reportReason;
	}

	public void setReportReason(int reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportCon() {
		return reportCon;
	}

	public void setReportCon(String reportCon) {
		this.reportCon = reportCon;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public int getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportType=" + reportType + ", reportReason=" + reportReason
				+ ", reportCon=" + reportCon + ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", no="
				+ no + ", reporter=" + reporter + "]";
	}
	

}
