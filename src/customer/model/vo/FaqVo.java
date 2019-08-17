package customer.model.vo;

public class FaqVo {
	private int faqNo; // FAQ 글번호
	private String faqTitle; // FAQ 제목
	private String faqContent; // FAQ 내용
	private String faqType; // FAQ 분류
	private int managerNo; // 관리자 번호
	
	public FaqVo() {
		// TODO Auto-generated constructor stub
	}
	
	// FAQ 전체 리스트용
	public FaqVo(int faqNo, String faqTitle, String faqContent, String faqType, int managerNo) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqType = faqType;
		this.managerNo = managerNo;
	}
	
	// FAQ 리스트용
	public FaqVo(int faqNo, String faqTitle, String faqType) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqType = faqType;
	}
	
	
	// FAQ 상세페이지용
	public FaqVo(int faqNo, String faqTitle, String faqContent, String faqType) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqType = faqType;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public String getFaqType() {
		return faqType;
	}

	public void setFaqType(String faqType) {
		this.faqType = faqType;
	}

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	@Override
	public String toString() {
		return "FaqVo [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", faqType="
				+ faqType + ", managerNo=" + managerNo + "]";
	}
	
}
