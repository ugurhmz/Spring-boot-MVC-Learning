package com.ugurhmz.springapp.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ugurhmz.springapp.business.dto.ProductDTO;
import com.ugurhmz.springapp.business.service.ProductService;



@RestController
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/rest/product/{id}")
	public ProductDTO getProduct(@PathVariable("id") Long productId) {
		
		ProductDTO productDto = productService.find(productId);
		return productDto;
	}
	
	
}
