package linkcode.shop.cust.model;

public class bill {
	private float total;
	private float gst;
	private float finaltotal;
	public bill(float total, float gst, float finaltotal) {
		super();
		this.total = total;
		this.gst = gst;
		this.finaltotal = finaltotal;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public float getFinaltotal() {
		return finaltotal;
	}
	public void setFinaltotal(float finaltotal) {
		this.finaltotal = finaltotal;
	}

}
