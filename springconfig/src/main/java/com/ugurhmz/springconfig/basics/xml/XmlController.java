package com.ugurhmz.springconfig.basics.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugurhmz.springconfig.basics.bean.MyBean;




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
	

}
