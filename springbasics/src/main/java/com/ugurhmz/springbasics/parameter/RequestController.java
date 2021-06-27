package com.ugurhmz.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RequestController {

	
	@GetMapping("/parametric/requestpage")
	public String  getRequestValue(Model model,  
			@RequestParam(name="myId", defaultValue = "0") long myId) 
	{
		model.addAttribute("message","With my id : "+myId);		
		return "parametric/requestPage";
	}


	@GetMapping("/parametric/multiple")
	public String getMultiple(Model model, 
			@RequestParam(name="mytype") String mytype, 
			@RequestParam(name="myid", defaultValue = "0") long myid)		
	{
		model.addAttribute("mymessage","Type : "+mytype+" myid : "+myid);
		return "parametric/multiplePage";
	}
	
	
}
