package deal.model.vo;

public class DealAttachment {
	private int daNo;
	private String daOrigin;
	private String daChange;
	private String daPath;
	private int refDealNo;
	private char daStatus;
	private int fileLevel;
	
	public int getFileLevel() {
		return fileLevel;
	}

	
	public DealAttachment(int daNo, String daOrign, String daChagne, String daPath, int refDealNo, char daStatus) {
		super();
		this.daNo = daNo;
		this.daOrigin = daOrign;
		this.daChange = daChagne;
		this.daPath = daPath;
		this.refDealNo = refDealNo;
		this.daStatus = daStatus;
	}

	
	public DealAttachment(String daOrigin, String daChage, String daPath) {
		super();
		this.daOrigin = daOrigin;
		this.daChange = daChage;
		this.daPath = daPath;
	}
	
	public DealAttachment(String daChange, String daPath, int refDealNo) {
		super();
		this.daChange = daChange;
		this.daPath = daPath;
		this.refDealNo = refDealNo;
	}

	public int getDaNo() {
		return daNo;
	}
	public void setDaNo(int daNo) {
		this.daNo = daNo;
	}
	public String getDaOrigin() {
		return daOrigin;
	}
	public void setDaOrigin(String daOrigin) {
		this.daOrigin = daOrigin;
	}
	public String getDaChange() {
		return daChange;
	}
	public void setDaChange(String daChange) {
		this.daChange = daChange;
	}
	public int getRefDealNo() {
		return refDealNo;
	}
	public void setRefDealNo(int refDealNo) {
		this.refDealNo = refDealNo;
	}
	public char getDaStatus() {
		return daStatus;
	}
	public void setDaStatus(char daStatus) {
		this.daStatus = daStatus;
	}
	public String getDaPath() {
		return daPath;
	}
	public void setDaPath(String daPath) {
		this.daPath = daPath;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public DealAttachment() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "DealAttachment [daNo=" + daNo + ", daOrigin=" + daOrigin + ", daChange=" + daChange + ", daPath="
				+ daPath + ", refDealNo=" + refDealNo + ", daStatus=" + daStatus + ", fileLevel=" + fileLevel + "]";
	}
	

	
}
