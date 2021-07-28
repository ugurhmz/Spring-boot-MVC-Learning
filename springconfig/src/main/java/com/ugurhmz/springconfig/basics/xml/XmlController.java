package com.ugurhmz.springconfig.basics.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugurhmz.springconfig.basics.bean.MyAgent;
import com.ugurhmz.springconfig.basics.bean.MyBean;
import com.ugurhmz.springconfig.basics.bean.MySpec;




@Controller
public class XmlController {
	
	
	@GetMapping("/xml/bean")
	@ResponseBody
	public String getBean() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");
		MyBean myBean =(MyBean) context.getBean("myBean");
		
		context.close();
				
		return " "+myBean.toString();
	}
	
	
	
	@GetMapping("/xml/reference")
	@ResponseBody
	public String getReference() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");
		MyAgent myAgent = (MyAgent) context.getBean("myAgent");
		context.close();
	
		return " "+myAgent.getAgentName()+" "+myAgent.getMyBean().toString();
	}
	
	
	@GetMapping("/xml/inversion")
	@ResponseBody
	public String getInversion() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");
		MySpec mySpec = (MySpec) context.getBean("mySpec");
		context.close();
		
		return "Inversion : "+mySpec.myMethod("input");
	}
	
	

}
