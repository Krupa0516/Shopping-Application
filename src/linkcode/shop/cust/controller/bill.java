package linkcode.shop.cust.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import linkcode.shop.admin.model.Product;

/**
 * Servlet implementation class bill
 */
@WebServlet("/bill")
public class bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bill() {
        super();
        // TODO Auto-generated constructor stub
    }

	public bill(float total, float gst, float finaltotal) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float total=0,gst,finaltotal;
		 
		HttpSession session=request.getSession();
		List<Product> lstproduct=(List<Product>)session.getAttribute("lstproduct");
		
		for(Product p:lstproduct){
			total=total+(p.getProdprice()*p.getProdqty());
		}
		gst=total*0.06f;
		finaltotal=total+gst;
		
		bill bobj=new bill(total, gst, finaltotal);
		session.setAttribute("bill", bobj);
		response.sendRedirect("bill.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
