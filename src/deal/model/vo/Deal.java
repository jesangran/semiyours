package deal.model.vo;

import java.sql.Timestamp;

public class Deal {
	private int dealNo;
	private String dealWriter;
	private String dealTitle;
	private String dealContent;
	private Timestamp dealEnrollDate;
	private int dealCount;
	private int dealStatus;
	private Timestamp dealModifyDate;
	private String dept1;
	private String dept2;
	private char deleteYN;
	private String dealLocal;
	private int price;
	private int dealType;
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deal(int dealNo, String dealWriter, String dealTitle, String dealContent, Timestamp dealEnrollDate,
			int dealCount, int dealStatus, Timestamp dealModifyDate, String dept1, String dept2, char deleteYN,
			String dealLocal, int price, int dealType) {
		super();
		this.dealNo = dealNo;
		this.dealWriter = dealWriter;
		this.dealTitle = dealTitle;
		this.dealContent = dealContent;
		this.dealEnrollDate = dealEnrollDate;
		this.dealCount = dealCount;
		this.dealStatus = dealStatus;
		this.dealModifyDate = dealModifyDate;
		this.dept1 = dept1;
		this.dept2 = dept2;
		this.deleteYN = deleteYN;
		this.dealLocal = dealLocal;
		this.price = price;
		this.dealType = dealType;
	}
	
	public Deal(String dealWriter, String dealTitle, String dealContent, int dealCount, String dept1, String dept2,
			String dealLocal, int price, int dealType) {
		super();
		this.dealWriter = dealWriter;
		this.dealTitle = dealTitle;
		this.dealContent = dealContent;
		this.dealCount = dealCount;
		this.dept1 = dept1;
		this.dept2 = dept2;
		this.dealLocal = dealLocal;
		this.price = price;
		this.dealType = dealType;
	}
	
	
	public Deal(int dealNo, String dealTitle, int dealStatus, int price, int dealType) {
		super();
		this.dealNo = dealNo;
		this.dealTitle = dealTitle;
		this.dealStatus = dealStatus;
		this.price = price;
		this.dealType = dealType;
	}
	public int getDealNo() {
		return dealNo;
	}
	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}
	public String getDealWirter() {
		return dealWriter;
	}
	public void setDealWirter(String dealWriter) {
		this.dealWriter = dealWriter;
	}
	public String getDealTitle() {
		return dealTitle;
	}
	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}
	public String getDealContent() {
		return dealContent;
	}
	public void setDealContent(String dealContent) {
		this.dealContent = dealContent;
	}
	public Timestamp getDealEnrollDate() {
		return dealEnrollDate;
	}
	public void setDealEnrollDate(Timestamp dealEnrollDate) {
		this.dealEnrollDate = dealEnrollDate;
	}
	public int getDealCount() {
		return dealCount;
	}
	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}
	public int getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(int dealStatus) {
		this.dealStatus = dealStatus;
	}
	public Timestamp getDealModifyDate() {
		return dealModifyDate;
	}
	public void setDealModifyDate(Timestamp dealModifyDate) {
		this.dealModifyDate = dealModifyDate;
	}
	public String getDept1() {
		return dept1;
	}
	public void setDept1(String dept1) {
		this.dept1 = dept1;
	}
	public String getDept2() {
		return dept2;
	}
	public void setDept2(String dept2) {
		this.dept2 = dept2;
	}
	public char getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(char deleteYN) {
		this.deleteYN = deleteYN;
	}
	public String getDealLocal() {
		return dealLocal;
	}
	public void setDealLocal(String dealLocal) {
		this.dealLocal = dealLocal;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDealType() {
		return dealType;
	}
	public void setDealType(int dealType) {
		this.dealType = dealType;
	}
	@Override
	public String toString() {
		return "Deal [dealNo=" + dealNo + ", dealWirter=" + dealWriter + ", dealTitle=" + dealTitle + ", dealContent="
				+ dealContent + ", dealEnrollDate=" + dealEnrollDate + ", dealCount=" + dealCount + ", dealStatus="
				+ dealStatus + ", dealModifyDate=" + dealModifyDate + ", dept1=" + dept1 + ", dept2=" + dept2
				+ ", deleteYN=" + deleteYN + ", dealLocal=" + dealLocal + ", price=" + price + ", dealType=" + dealType + "]";
	}
}