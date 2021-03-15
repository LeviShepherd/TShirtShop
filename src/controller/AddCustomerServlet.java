package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCustomer;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/addCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TCustomerHelper tch = new TCustomerHelper();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		TCustomer customer = new TCustomer(name, address);
		tch.insertCustomer(customer);
		
		System.out.println("Customer created.");
		System.out.println(customer.toString());
		
		getServletContext().getRequestDispatcher("/new-customer.jsp").forward(request, response);
	}

}
