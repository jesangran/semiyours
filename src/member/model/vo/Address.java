package member.model.vo;

public class Address {
	private String attr;
	private String attrDetail;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String attr, String attrDetail) {
		super();
		this.attr = attr;
		this.attrDetail = attrDetail;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getAttrDetail() {
		return attrDetail;
	}
	public void setAttrDetail(String attrDetail) {
		this.attrDetail = attrDetail;
	}
	@Override
	public String toString() {
		return "Address [attr=" + attr + ", attrDetail=" + attrDetail + "]";
	}
	
	
	
 }
