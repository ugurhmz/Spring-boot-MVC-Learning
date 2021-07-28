package com.ugurhmz.springconfigbeanvalid.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Account {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountId;
	@Column(name="account_name")
	private String accountName;
	@Column(name="total_balance")
	private double totalBalance;
	
	
	public Account() {
	}
	
	public Account(long accountId, String accountName, double totalBalance) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.totalBalance = totalBalance;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	
}
