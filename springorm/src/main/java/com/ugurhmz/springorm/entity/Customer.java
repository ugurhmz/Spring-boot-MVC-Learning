package com.ugurhmz.springorm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer {

	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	private String customerName;
	
	private double totalCredit;
	
	
	public Customer() {
		
	}


	public Customer(long customerId, String customerName, double totalCredit) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalCredit = totalCredit;
	}
	
	
	// GETTER & SETTER
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}
	
	
	
	
}
