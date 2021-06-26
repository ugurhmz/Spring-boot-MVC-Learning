package com.ugurhmz.springbasics.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ListController {

	
	@GetMapping("/models/list")
	public String getList(Model model) {
		List<Product> myProduct = new ArrayList<>();
		
		myProduct.add(new Product(120,"Iphone 6s PLUS",2400.0));
		myProduct.add(new Product(121,"Iphone 7s",2800.35));
		myProduct.add(new Product(122,"Iphone 7s PLUS",3500.0));
		
		model.addAttribute("message","Listelenen ürünler :");
		model.addAttribute("myProduct",myProduct);
		
		return "models/listpage";
	}
	
}
