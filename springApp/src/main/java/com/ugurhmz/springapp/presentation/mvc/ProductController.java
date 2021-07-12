package com.ugurhmz.springapp.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	public String postAddProduct(Model model, Product product, BindingResult result) {
		productRepository.save(product);
		
		if(result.hasErrors()) {
			result.addError(new ObjectError("product","The product could not be added"));
			return "/inventory/addProduct";
		}
		
		
		model.addAttribute("message","The Product has been successfully added");
		return "/inventory/successProduct";
		
	}
	
	
	
}
