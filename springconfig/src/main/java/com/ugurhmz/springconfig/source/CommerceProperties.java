package com.ugurhmz.springconfig.source;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;



@ConfigurationProperties(prefix = "commerce")
@Configuration
@Validated
public class CommerceProperties {

	private String site="sanayazilarim.blogspot.com";
	
	
	@Email
	private String emailAddress;
	
	@Min(1)
	@Max(10)
	private int returnDays;
	
	
	private Bank bank;
	
	
	
	// GETTER & SETTER
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
	
	public int getReturnDays() {
		return returnDays;
	}
	
	public void setReturnDays(int returnDays) {
		this.returnDays = returnDays;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	
}
