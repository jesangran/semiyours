package deal.model.vo;

import java.sql.Timestamp;

public class DealComment {
	private int dealCommNo ;
	private String dealCommWriter;
	private String dealCommContent;
	private Timestamp dealCommEnrolldate;
	private char dealCommStatus;
	private int refDealNo;
	private Timestamp dealCommModifydate;
	private int rType;
	public DealComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DealComment(int dealCommNo, String dealCommWriter, String dealCommContent, Timestamp dealCommEnrolldate,
			char dealCommStatus, int refDealNo, Timestamp dealCommModifydate, int rType) {
		super();
		this.dealCommNo = dealCommNo;
		this.dealCommWriter = dealCommWriter;
		this.dealCommContent = dealCommContent;
		this.dealCommEnrolldate = dealCommEnrolldate;
		this.dealCommStatus = dealCommStatus;
		this.refDealNo = refDealNo;
		this.dealCommModifydate = dealCommModifydate;
		this.rType = rType;
	}
	public DealComment(String dealCommWriter, String dealCommContent, int refDealNo) {
		super();
		this.dealCommWriter = dealCommWriter;
		this.dealCommContent = dealCommContent;
		this.refDealNo = refDealNo;
	}
	public int getDealCommNo() {
		return dealCommNo;
	}
	public void setDealCommNo(int dealCommNo) {
		this.dealCommNo = dealCommNo;
	}
	public String getDealCommWriter() {
		return dealCommWriter;
	}
	public void setDealCommWriter(String dealCommWriter) {
		this.dealCommWriter = dealCommWriter;
	}
	public String getDealCommContent() {
		return dealCommContent;
	}
	public void setDealCommContent(String dealCommContent) {
		this.dealCommContent = dealCommContent;
	}
	public Timestamp getDealCommEnrolldate() {
		return dealCommEnrolldate;
	}
	public void setDealCommEnrolldate(Timestamp dealCommEnrolldate) {
		this.dealCommEnrolldate = dealCommEnrolldate;
	}
	public char getDealCommStatus() {
		return dealCommStatus;
	}
	public void setDealCommStatus(char dealCommStatus) {
		this.dealCommStatus = dealCommStatus;
	}
	public int getRefDealNo() {
		return refDealNo;
	}
	public void setRefDealNo(int refDealNo) {
		this.refDealNo = refDealNo;
	}
	public Timestamp getDealCommModifydate() {
		return dealCommModifydate;
	}
	public void setDealCommModifydate(Timestamp dealCommModifydate) {
		this.dealCommModifydate = dealCommModifydate;
	}
	public int getrType() {
		return rType;
	}
	public void setrType(int rType) {
		this.rType = rType;
	}
	@Override
	public String toString() {
		return "DealComment [dealCommNo=" + dealCommNo + ", dealCommWriter=" + dealCommWriter + ", dealCommContent="
				+ dealCommContent + ", dealCommEnrolldate=" + dealCommEnrolldate + ", dealCommStatus=" + dealCommStatus
				+ ", refDealNo=" + refDealNo + ", dealCommModifydate=" + dealCommModifydate + ", rType=" + rType + "]";
	}
	
	
}
