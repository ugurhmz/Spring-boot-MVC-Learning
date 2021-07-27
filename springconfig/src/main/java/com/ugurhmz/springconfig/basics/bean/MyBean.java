package com.ugurhmz.springconfig.basics.bean;




public class MyBean {

	
	private long myLong;
	private String myString;
	private double myDouble;
	
	
	
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public double getMyDouble() {
		return myDouble;
	}
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	
	
	public void initializeBean()  {
		System.out.println("initialize...");
	}
	
	public void finalizeBean() {
		System.out.println("Finalize...");
	}
	
	
	@Override
	public String toString() {
		return myLong + " "+myString+ " "+myDouble;
	}

}
