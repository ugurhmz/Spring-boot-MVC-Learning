package com.ugurhmz.springapp.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ugurhmz.springapp.data.entity.Product;
import com.ugurhmz.springapp.data.repository.ProductRepository;




@Controller
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/product/addproduct")
	public String getProduct(Model model) {
		Product product = new Product(0,"",0.0);		
		model.addAttribute("product",product);
		return "/inventory/addProduct";
		
		
	}
	
	
	@PostMapping("/product/addproduct")
	public String postAddProduct(Model model, Product product) {
		productRepository.save(product);
		return "/inventory/addProduct";
	}
	
	
	
}
