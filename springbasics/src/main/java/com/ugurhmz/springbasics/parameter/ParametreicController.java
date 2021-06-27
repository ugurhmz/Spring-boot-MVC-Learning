package com.ugurhmz.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class ParametreicController {
	
	// ONLY ID
	@GetMapping("/parametric/value/{myId}")
	public String getParametricValue(Model model, @PathVariable (name="myId") long myId) {
		model.addAttribute("message","Hello with my id : "+myId);
		return "parametric/variablePage";
	}
	
	
	// OPTIONAL
	@GetMapping({"/parametric/optional/{myId}","/parametric/optional/"})
	public String getParametricOptional(Model model, 
			@PathVariable(name="myId", required = false) Long myId) {
		
		if(myId == null) {
			model.addAttribute("message","There is a message ");
		}
		else {
			model.addAttribute("message","There is a message with my id : "+myId);
		}
		
		return "parametric/variablePage";
	}
	
	
	// PLURAL
	@GetMapping("/parametric/plural/{mytype}/{myid}")
	public String getMultiple(Model model, 
			@PathVariable(name="mytype") String mytype,
			@PathVariable(name="myid") long myid) 
	{
		model.addAttribute("message","my id : "+myid+" mytype : "+mytype);
		return "parametric/variablePage";
	}
	
	
	
}
