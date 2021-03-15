/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 9, 2021
 */
package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Able to add, delete orders
 */
@Entity
@Table(name="orders")
public class TOrders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDERID")
	private int orderId;
	@Column(name="CUSTOMERID")
	private int customerId;
	@Column(name="SIZE")
	private String size;
	@Column(name="COLOR")
	private String color;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="ORDERDATE")
	private LocalDate orderDate;
	
	//gets sets
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	//construct
	
	public TOrders() {
		super();
	}
	
	public TOrders(int customerId, String size, String color, int quantity) {
		super();
		setCustomerId(customerId);
		setSize(size);
		setColor(color);
		setQuantity(quantity);
	}
	
	/**
	 * @param customerId
	 * @param size
	 * @param color
	 * @param quantity
	 * @param orderDate
	 */
	public TOrders(int customerId, String size, String color, int quantity, LocalDate orderDate) {
		super();
		this.customerId = customerId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public String display() {
		return this.getCustomerId() + " : " + this.getSize() + ", " + this.getColor() + ", " + this.getQuantity() + ", " + this.getOrderDate();
	}

	@Override
	public String toString() {
		return "TOrders [orderId=" + orderId + ", customerId=" + customerId + ", size=" + size + ", color=" + color
				+ ", quantity=" + quantity + ", orderDate=" + orderDate + "]";
	}
	
}
