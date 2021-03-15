package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCustomer;
import model.TOrders;

/**
 * STUBBED - NOT IMPLEMENTED
 */


/**
 * Servlet implementation class CreateNewOrderServlet
 */
@WebServlet("/createNewOrderServlet")
public class CreateNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewOrderServlet() {
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
		TOrdersHelper toh = new TOrdersHelper();
		int custID = Integer.parseInt((request.getParameter("custID")));
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		int quantity = Integer.parseInt((request.getParameter("quantity")));
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
				Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		

		TOrders order = new TOrders(custID, size, color, quantity, ld);
		toh.insertOrders(order);
		
		System.out.println("Order created");
		System.out.println(order.toString());
		
		getServletContext().getRequestDispatcher("/new-order.jsp").forward(request, response);
	}

}
