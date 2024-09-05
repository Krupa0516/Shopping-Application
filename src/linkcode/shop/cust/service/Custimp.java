package linkcode.shop.cust.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import linkcode.shop.admin.model.Product;
import linkcode.shop.cust.model.Register;
import linkcode.shop.cust.model.login;
import linkcode.shop.db.Shopdb;


public class Custimp implements Custservice{
	 Shopdb db=new Shopdb();
    
	@Override
	public int create(List<Register> lst) {
		Register reg=lst.get(0);
		int i=0;
		Connection con=db.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into cust values (?,?,?,?,?)");
			pstate.setInt(1, reg.getRegno());
			pstate.setString(2, reg.getFname());
			pstate.setString(3, reg.getUname());
			pstate.setString(4, reg.getPassword());
			pstate.setString(5, reg.getMobno());
			i=pstate.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;	
	}

	@Override
	public boolean validateUser(login lobj) {
		boolean b=false;
		Connection con=db.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from cust where user_name=? and password=?");
			ps.setString(1, lobj.getUname());
			ps.setString(2, lobj.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				b=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

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
}
