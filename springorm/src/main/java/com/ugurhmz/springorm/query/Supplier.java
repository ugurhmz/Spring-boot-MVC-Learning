package com.ugurhmz.springorm.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Supplier {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	private String supplierName;
	private double totalDebit;	
	
	
	public Supplier() {
	}

	public Supplier(long supplierId, String supplierName, double totalDebit) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.totalDebit = totalDebit;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public double getTotalDebit() {
		return totalDebit;
	}
	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}
	
}
