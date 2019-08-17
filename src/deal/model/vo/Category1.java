package deal.model.vo;

public class Category1 {
	private int cNo;
	private String cName;

	public Category1() {
		super();
	}

	public Category1(int cNo, String cName) {
		super();
		this.cNo = cNo;
		this.cName = cName;
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

	@Override
	public String toString() {
		return "Category1 [cNo=" + cNo + ", cName=" + cName + "]";
	}

}
