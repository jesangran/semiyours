
package deal.model.vo;

import java.sql.Timestamp;

public class Deal {
	private int dealNo;
	private int dealWriter;
	private String nickname;
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
	private int viewCount;
	private int rType;
	private String dealerGrade;
	
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Deal(int dealNo, int dealWriter,String nickname,String dealTitle, String dealContent, Timestamp dealEnrollDate,
			int dealCount, int dealStatus, String dept1, String dept2, String dealLocal, 
			int price, int dealType,int viewCount,int rType,String dealerGrade) {
		super();
		this.dealNo = dealNo;
		this.dealWriter = dealWriter;
		this.nickname = nickname;
		this.dealTitle = dealTitle;
		this.dealContent = dealContent;
		this.dealEnrollDate = dealEnrollDate;
		this.dealCount = dealCount;
		this.dealStatus = dealStatus;
		this.dept1 = dept1;
		this.dept2 = dept2;
		this.dealLocal = dealLocal;
		this.price = price;
		this.dealType = dealType;
		this.viewCount =viewCount;
		this.rType = rType;
		this.dealerGrade=dealerGrade;
	}
	
	public Deal(int dealNo, String dealTitle, String dealContent, int dealCount,
			String dept1, String dept2, String dealLocal, int price, int dealType) {
		super();
		this.dealNo = dealNo;
		this.dealTitle = dealTitle;
		this.dealContent = dealContent;
		this.dealCount = dealCount;
		this.dept1 = dept1;
		this.dept2 = dept2;
		this.dealLocal = dealLocal;
		this.price = price;
		this.dealType = dealType;
	}

	public Deal( String dealTitle,int dealWriter, String dealContent, int dealCount, String dept1, String dept2,
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
	
	public Deal(int dealNo, String dealTitle, int dealStatus, int price, int dealType,String dealLocal) {
		super();
		this.dealNo = dealNo;
		this.dealTitle = dealTitle;
		this.dealStatus = dealStatus;
		this.price = price;
		this.dealType = dealType;
		this.dealLocal=dealLocal;
		
	}
	
	public Deal(int dealNo, String dealTitle, int dealStatus, int price, int dealType,String dealLocal,String dept1, String dept2) {
		super();
		this.dealNo = dealNo;
		this.dealTitle = dealTitle;
		this.dealStatus = dealStatus;
		this.price = price;
		this.dealType = dealType;
		this.dealLocal=dealLocal;
		this.dept1 = dept1;
		this.dept2 = dept2;
	}

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	public int getDealWriter() {
		return dealWriter;
	}

	public void setDealWriter(int dealWriter) {
		this.dealWriter = dealWriter;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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


	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
  }
  

	public int getrType() {
		return rType;
	}

	public void setrType(int rType) {
		this.rType = rType;
	}

	public String getDealerGrade() {
		return dealerGrade;
	}

	public void setDealerGrade(String dealerGrade) {
		this.dealerGrade = dealerGrade;
	}

	@Override
	public String toString() {
		return "Deal [dealNo=" + dealNo + ", dealWriter=" + dealWriter + ", dealTitle=" + dealTitle + ", dealContent="
				+ dealContent + ", dealEnrollDate=" + dealEnrollDate + ", dealCount=" + dealCount + ", dealStatus="
				+ dealStatus + ", dealModifyDate=" + dealModifyDate + ", dept1=" + dept1 + ", dept2=" + dept2
				+ ", deleteYN=" + deleteYN + ", dealLocal=" + dealLocal + ", price=" + price + ", dealType=" + dealType
				+ ", viewCount=" + viewCount + ", rType=" + rType + ", dealerGrade=" + dealerGrade + "]";
	}
	

}