package com.ugurhmz.springconfig.basics.bean;



public class MySpecImpl implements MySpec {

	
	@Override
	public String myMethod(String input) {
		return "input : "+input;
	}

}
