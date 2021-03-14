/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 14, 2021
 */
package controller;

import java.util.Scanner;

import model.TCustomer;

/**
 * @author wuebk
 *
 */
public class TShirtShopDriver {
	
		static Scanner sc = new Scanner(System.in);
		static TCustomerHelper TCH = new TCustomerHelper();
		
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
			TCustomer foundC = TCH.searchForName(editName);
			
			TCH.editCustomer(foundC);
		}
		
		private static void deleteACustomer() {
			System.out.println("Enter the name of the customer to delete");
			String deleteName = sc.nextLine();
			TCustomer foundC = TCH.searchForName(deleteName);
			
			TCH.deleteCustomer(foundC);
		}
	
	public static void main(String[] args) {
		
	}
	
	public void menu() {
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
