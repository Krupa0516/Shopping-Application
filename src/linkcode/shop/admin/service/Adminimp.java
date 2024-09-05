package linkcode.shop.admin.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import linkcode.shop.admin.model.Product;
import linkcode.shop.db.Shopdb;
public class Adminimp implements Adminservice {
	
    Shopdb db=new Shopdb();
	@Override
	//To insert product
	public String createProduct(List<Product> lstproduct) {
		Connection con=db.getConnection();
		String str=null;
		Product prodobj=lstproduct.get(0);
		int i=0;
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Prodapp values(?,?,?,?)");
			pstate.setInt(1, prodobj.getProdid());
			pstate.setString(2, prodobj.getProdname());
			pstate.setFloat(3, prodobj.getProdprice());
			pstate.setInt(4, prodobj.getProdqty());
			i=pstate.executeUpdate();
			
			if(i>0)
			{
				str="Valid";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			str=e.getMessage();
			e.printStackTrace();
		}
		return str;
	}

	@Override
	//To search product
	public List<Product> search(int prodid) {
		ResultSet rs=null;
		Product p=null;
		List<Product> lstproduct=null;
		Connection con=db.getConnection();
		int i=0;
	
		try {
			PreparedStatement pstate=con.prepareStatement("select * from Prodapp where prod_id=?");
			pstate.setInt(1, prodid);
			rs=pstate.executeQuery();
		
			if(rs.next()){
				lstproduct=new ArrayList<Product>();
				Product prod=new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
				lstproduct.add(prod);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return lstproduct;
	}

	@Override
	//To display products
	public List<Product> displayprod() {
		ResultSet rs=null;
		Product p=null;
		List<Product> lstproduct=new LinkedList<Product>();
		Connection con=db.getConnection();
		Statement state=null;
		String str="select * from Prodapp";
	
		try {
			state=con.createStatement();
			rs=state.executeQuery(str);
		    lstproduct= new ArrayList<Product>();
			while(rs.next()){
				Product prod=new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
				lstproduct.add(prod);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return lstproduct;
	}
}
