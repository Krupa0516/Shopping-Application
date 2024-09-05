package linkcode.shop.cust.model;

public class Register {
	private int regno;
	private String fname;
	private String mobno;
	private String uname;
	private String password;

	public Register(int regno, String fname, String mobno, String uname, String password) {
		super();
		this.regno = regno;
		this.fname = fname;
		this.mobno = mobno;
		this.uname = uname;
		this.password = password;
	}
	public Register() {
		// TODO Auto-generated constructor stub
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

