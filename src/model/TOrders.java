/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 9, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wuebk
 *
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
	private String orderDate;
	
	//gets sets
	
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
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
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
	
}
