package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCustomer;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToCustomer");
		
		String path = "/viewAllCustomersServlet";
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllCustomersServlet").forward(request, response);
			
		} else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TCustomer customerToDelete = tch.searchForId(tempId);
				tch.deleteCustomer(customerToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a customer");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TCustomer customerToEdit = tch.searchForId(tempId);
				request.setAttribute("customerToEdit", customerToEdit);
				path = "/edit-customer.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a customer");
			}
		} else if(act.equals("add")) {
			path = "new-customer.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
