package com.ugurhmz.springconfig.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugurhmz.springconfig.basics.bean.MyAgent;
import com.ugurhmz.springconfig.basics.bean.MyBean;
import com.ugurhmz.springconfig.basics.bean.MySpec;




@Controller
public class SourceController {

	@Autowired
	private MyBean myBean;
	
	
	@Autowired
	private MyBean anotherBean;
	
	@Autowired
	private MyAgent myAgent;
	
	
	@Autowired
	private MySpec mySpec;
	
	
	@Autowired
	private CommerceProperties commerceProperties;
	
	
	
	
	@GetMapping("/source/bean")
	@ResponseBody
	public String getBean() {
		return "Hello My Bean : "+myBean.toString();
	}
	
	
	@GetMapping("/source/scope")
	@ResponseBody
	public String getScope() {
		return "Bean : "+anotherBean.hashCode()+" "+myBean.hashCode();
	}
	
	
	@GetMapping("/source/reference")
	@ResponseBody
	public String getReference() {
		return "MyAgent : "+myAgent.getAgentName()+" "+myAgent.getMyBean().toString();
	}
	
	
	@GetMapping("/source/inversion")
	@ResponseBody
	public String getInversion() {
		return "Inversion : "+mySpec.myMethod("Input");
	}
	
	
	@GetMapping("/source/properties")
	@ResponseBody
	public String getCommerceProperties() {
		return "properties : "+commerceProperties.getSite()+
				" "+commerceProperties.getEmailAddress()+" "+
				"Bank "+commerceProperties.getBank().getName()+
				" Payment Time : "+commerceProperties.getBank().getPaymentTime();
				
	}
	
	
	
}











