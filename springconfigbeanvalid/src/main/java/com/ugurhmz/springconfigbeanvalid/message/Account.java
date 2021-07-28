package com.ugurhmz.springconfigbeanvalid.message;




public class Account {

	private long accountId;
	private String accountName;
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
