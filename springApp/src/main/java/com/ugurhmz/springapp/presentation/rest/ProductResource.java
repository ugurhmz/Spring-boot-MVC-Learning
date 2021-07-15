package com.ugurhmz.springapp.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ugurhmz.springapp.business.dto.ProductDTO;
import com.ugurhmz.springapp.business.service.ProductService;



@RestController
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	// find by id
	@GetMapping("/rest/product/{id}")
	public ProductDTO getProduct(@PathVariable("id") long productId) {
		ProductDTO productDto = productService.find(productId);
		return productDto;
	}
	
	
	// find all
	@GetMapping("/rest/products")
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> products = productService.findAll();
		return products;
	}
	
	
	// create 
	@PostMapping("/rest/product")
	public ProductDTO postProduct(@RequestBody ProductDTO product) {
		productService.save(product);
		return product;
	}
	
	
	//update
	@PutMapping("/rest/product")
	public void editProduct(@RequestBody ProductDTO product) {
		productService.save(product);		
		
	}
	
	//delete
	@DeleteMapping("/rest/product/{id}")
	public void deleteProduct(@PathVariable("id") long productId) {
		productService.delete(productId);
	}
	
}









