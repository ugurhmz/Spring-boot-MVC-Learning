package com.ugurhmz.springbasics.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class BeanController {

	
	@GetMapping("/models/beanpage")
	public String getMyProduct(Model model) {
		
		model.addAttribute("productMessage","Satışta olan ürün");
		Product p = new Product(312,"Iphone 6s Plus",2500.40);
		model.addAttribute("product", p);
		
		return "models/beanpage";
	}
}
