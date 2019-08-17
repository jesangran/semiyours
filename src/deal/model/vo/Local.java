package deal.model.vo;

public class Local {
	private int lNo;
	private String lName;
	private String fullName;
	public Local() {
	
	}
	public Local(int lNo, String lName,String fullName) {
		super();
		this.lNo = lNo;
		this.lName = lName;
		this.fullName=fullName;
	}
	public int getlNo() {
		return lNo;
	}
	public void setlNo(int lNo) {
		this.lNo = lNo;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "Local [lNo=" + lNo + ", lName=" + lName + ", fullName=" + fullName + "]";
	}
	
	
	
}
