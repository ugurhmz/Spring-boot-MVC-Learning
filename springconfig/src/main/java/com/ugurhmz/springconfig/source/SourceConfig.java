package com.ugurhmz.springconfig.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ugurhmz.springconfig.basics.bean.MyAgent;
import com.ugurhmz.springconfig.basics.bean.MyBean;
import com.ugurhmz.springconfig.basics.bean.MySpec;
import com.ugurhmz.springconfig.basics.bean.MySpecImpl;




@Configuration
public class SourceConfig {

	
	@Bean(initMethod="initializeBean", destroyMethod="finalizeBean")
	//@Scope("prototype")
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyString("My Bean ...");
		myBean.setMyLong(100);
		myBean.setMyDouble(312.34);
		
		return myBean;
	}
	
	
	@Bean
	public MyAgent myAgent() {
		MyAgent myAgent = new MyAgent();
		myAgent.setAgentName("My Agent");
		myAgent.setMyBean( myBean() );
		return myAgent;
	}
	
	
	@Bean
	public MySpec mySpec( ) {
		MySpec mySpec = new MySpecImpl();
		return mySpec;
	}
	
	
	
}








