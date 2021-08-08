package ua.lviv.lgs.domain;

import java.util.Date;
import java.util.Objects;

public class Bucket {
	private Integer id;
	private Integer userid;
	private Integer productid;
	private Date purchasetime;
	public Bucket(Integer id, Integer userid, Integer productid, Date purchasetime) {
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.purchasetime = purchasetime;
	}
	public Bucket(Integer userid, Integer productid, Date purchasetime) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.purchasetime = purchasetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Date getPurchasetime() {
		return purchasetime;
	}
	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}
	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userid=" + userid + ", productid=" + productid + ", purchasetime=" + purchasetime
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, productid, purchasetime, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		return Objects.equals(id, other.id) && Objects.equals(productid, other.productid)
				&& Objects.equals(purchasetime, other.purchasetime) && Objects.equals(userid, other.userid);
	}
	
	
}
