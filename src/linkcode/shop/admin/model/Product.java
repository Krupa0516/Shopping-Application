package linkcode.shop.admin.model;

public class Product {
	int prodid;
	String prodname;
	float prodprice;
	int prodqty;
	public Product(int prodid, String prodname, float prodprice, int prodqty) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodqty = prodqty;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public float getProdprice() {
		return prodprice;
	}
	public void setProdprice(float prodprice) {
		this.prodprice = prodprice;
	}
	public int getProdqty() {
		return prodqty;
	}
	public void setProdqty(int prodqty) {
		this.prodqty = prodqty;
	}


}
