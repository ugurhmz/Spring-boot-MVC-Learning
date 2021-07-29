package com.ugurhmz.springconfigbeanvalid.data.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;




@Entity
public class Account {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountId;
	
	@NotEmpty(message="{account.accountName.notEmpty}")
	private String accountName;
	
	@Min(value=2,message="{account.totalBalance.min}")
	@Max(value=2000,message="{account.totalBalance.max}")
	private double totalBalance;
	
	
	
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
