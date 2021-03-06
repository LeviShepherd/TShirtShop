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
 * Allow editing, adding and deletion of customer details
 */
@Entity
@Table(name="customers")
public class TCustomer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int customerId;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	
	//gets sets
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//construct
	
	public TCustomer() {
		super();
	}
	
	public TCustomer(String name, String address) {
		super();
		setName(name);
		setAddress(address);
	}
	
	//methods
	
	public String printCustomer() {
		return this.name + ", " + this.address;
	}

	@Override
	public String toString() {
		return "TCustomer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
}
