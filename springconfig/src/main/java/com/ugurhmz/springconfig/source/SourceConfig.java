package com.ugurhmz.springconfig.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ugurhmz.springconfig.basics.bean.MyBean;




@Configuration
public class SourceConfig {

	
	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyString("My Bean ...");
		myBean.setMyLong(100);
		myBean.setMyDouble(312.34);
		
		return myBean;
	}
	
	
	
}
