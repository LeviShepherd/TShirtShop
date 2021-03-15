/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 14, 2021
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.TCustomer;
import model.TOrders;

/**
 * @author wuebk
 *
 */
public class TShirtShopDriver {
	
		static Scanner sc = new Scanner(System.in);
		static TCustomerHelper TCH = new TCustomerHelper();
		static TOrdersHelper TOH = new TOrdersHelper();
		
		private static void addACustomer() {
			System.out.println("Enter Customer Name: ");
			String name = sc.nextLine();
			System.out.println("Enter Customer Home Street Address, City, State, and ZipCode");
			String address = sc.nextLine();
			
			TCustomer c = new TCustomer(name, address);
			TCH.insertCustomer(c);
		}
		
		private static void editACustomer() {
			System.out.println("Enter the name of the customer to edit");
			String editName = sc.nextLine();
			List<TCustomer> foundC = TCH.searchForName(editName);
			
			if(!foundC.isEmpty()) {
				System.out.println("Found:");
				for(TCustomer tc : foundC) {
					System.out.println("ID: " + tc.getCustomerId() + ", " + tc.printCustomer());
				}
				
				System.out.println("Type in which id to edit: ");
				int idToEdit = sc.nextInt();
				TCustomer toEdit = TCH.searchForId(idToEdit);
				
				System.out.println("Re-enter Customer Name: ");
				String rename = sc.nextLine();
				System.out.println("Re-enter Customer Address: house number, street name, city, state, zip code");
				String readdress = sc.nextLine();
				
				toEdit.setName(rename);
				toEdit.setAddress(readdress);
		
				TCH.updateCustomer(toEdit);
			} else {
				System.out.println("NO RESULTS FOUND");
			}
		}
		
		private static void deleteACustomer() {
			System.out.println("Enter the name of the customer to delete");
			String deleteName = sc.nextLine();
			List<TCustomer> foundC = TCH.searchForName(deleteName);
			if(!foundC.isEmpty()) {
				
				TCH.deleteCustomer(foundC.get(0));
				
			}
		}
		
		private static void viewAllCustomers() {
			List<TCustomer> customerList = TCH.showAllCustomers();
			for(TCustomer tc : customerList) {
				System.out.println(tc.printCustomer());
			}
			
		}
		
		private static void createOrder() {
			System.out.println("Enter your Customer Id: ");
			int custId = sc.nextInt();
			System.out.println("Enter the T-Shirt Size: ");
			String shirtSize = sc.nextLine();
			System.out.println("Enter the Color");
			String color = sc.nextLine();
			System.out.println("Enter Quantity of shirt: ");
			int quant = sc.nextInt();
			LocalDate date = LocalDate.now();
			
			TOrders newOrder = new TOrders(custId, shirtSize, color, quant); newOrder.setOrderDate(date);
			
		}
		
		private static void viewAllOrders() {
			List<TOrders> orderList = TOH.showAllOrders();
			for(TOrders to : orderList) {
				System.out.println(to.display());
			}
		}
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a customer");
			System.out.println("*  2 -- Edit a customer");
			System.out.println("*  3 -- Delete a customer");
			System.out.println("*  4 -- View all customers");
			System.out.println("*  5 -- Create a T-Shirt Order");
			System.out.println("*  6 -- View all Orders");
			System.out.println("*  7 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = sc.nextInt();
			sc.nextLine();

			switch(selection) {
			case 1:
				addACustomer();
				break;
			case 2:
				editACustomer();
				break;
			case 3:
				deleteACustomer();
				break;
			case 4:
				viewAllCustomers();
				break;
			case 5:
				createOrder();
				break;
			case 6:
				viewAllOrders();
				break;
			case 7:
				goAgain = false;
				break;
			}
			}

		}
	}
