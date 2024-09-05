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
import linkcode.shop.cust.service.Custimp;
import linkcode.shop.cust.service.Custservice;

/**
 * Servlet implementation class Searchprod
 */
@WebServlet("/Searchprod")
public class Searchprod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchprod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String msg=null;
			int prodid=Integer.parseInt(request.getParameter("prodid"));
			Custservice pdao=new Custimp();
			List<Product>lstproduct=pdao.search(prodid);
			HttpSession session=request.getSession();
			if(lstproduct!=null)
			{
				session.setAttribute("prod", lstproduct);
			}
			else
			{
				msg="invalid prodid";
				session.setAttribute("prod", msg);
			}
			response.sendRedirect("search.jsp");
			
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
