package deal.model.vo;

public class Category2 {
	private int cNo;
	private String cName;
	private int refC1No;
	public Category2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category2(int cNo, String cName, int refC1No) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.refC1No = refC1No;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getRefC1No() {
		return refC1No;
	}
	public void setRefC1No(int refC1No) {
		this.refC1No = refC1No;
	}
	@Override
	public String toString() {
		return "Category2 [cNo=" + cNo + ", cName=" + cName + ", refC1No=" + refC1No + "]";
	}
}
