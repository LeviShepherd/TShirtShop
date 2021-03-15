package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCustomer;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/editCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TCustomerHelper tch = new TCustomerHelper();
		
		String name = request.getParameter("custName");
		String address = request.getParameter("address");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		TCustomer customerToUpdate = tch.searchForId(tempId);
		customerToUpdate.setName(name);
		customerToUpdate.setAddress(address);
		tch.updateCustomer(customerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCustomersServlet").forward(request, response);
	}

}
