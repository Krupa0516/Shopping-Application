package linkcode.shop.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import linkcode.shop.admin.model.Product;
import linkcode.shop.admin.service.Adminimp;
import linkcode.shop.admin.service.Adminservice;
/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		String prodname=request.getParameter("prodname");
		float prodprice=Float.parseFloat(request.getParameter("prodprice"));
		int prodqty=Integer.parseInt(request.getParameter("prodqty"));
	
		Product prodobj=new Product(prodid, prodname, prodprice, prodqty);
		List<Product> lstproduct=new ArrayList<Product>();
		lstproduct.add(prodobj);
		
		Adminservice proddao=new Adminimp();
		String str=proddao.createProduct(lstproduct);
		System.out.println("In Controller str is:"+str);
		HttpSession session=request.getSession();
		if(str.equals("Valid")){
			str="Product Added to db";
		}
		session.setAttribute("msg", str);
		response.sendRedirect("Product.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
