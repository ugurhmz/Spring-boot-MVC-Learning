package com.ugurhmz.springapp.presentation.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ugurhmz.springapp.business.dto.ProductDTO;
import com.ugurhmz.springapp.business.service.ProductService;
import com.ugurhmz.springapp.data.entity.Product;
import com.ugurhmz.springapp.data.repository.ProductRepository;





@Controller
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/product/addproduct")
	public String getProduct(Model model) {
		Product product = new Product(0,"",0.0);		
		model.addAttribute("product",product);
		return "/inventory/addProduct";
		
		
	}
	
	
	// CREATE 
	@PostMapping(path= {"/product/addproduct", "/product/update/{id}"})
	public String postAddProduct(Model model, ProductDTO product, BindingResult result) {
		
		productService.save(product);
			
		if(result.hasErrors()) {
			result.addError(new ObjectError("product","The product could not be added"));
			return "/inventory/addProduct";
		}	
		
		model.addAttribute("message","The Product has been successfully added");
		return "/inventory/successProduct";
	}
	
	
	
	
	// READ PRODUCT LIST
	@GetMapping("/product/productList")
	public String getProductList(Model model) {
		
		model.addAttribute("message","PRODUCT LIST");
		model.addAttribute("productlist",productRepository.findAll());
		return "inventory/productList";
	}
	
	
	
	
	//DELETE
	@GetMapping("/product/delete/{id}")
	public String deleteProductWithId(@PathVariable("id") Long productId, Model model) {
		productRepository.deleteById(productId);
		
		model.addAttribute("message","Product Deleted id : "+productId);
		model.addAttribute("productlist",productRepository.findAll()); //Silindikten sonra listenin tekrar gözükmesi için .findAll() kullan çünkü productlist gidiyor .jsp'ye
		return "/inventory/productList";
	}
	
	
	
	// UPDATE
	@GetMapping("/product/update/{id}")
	public String updateProductWithId(Model model, @PathVariable("id") Long productId) {
		
		ProductDTO product = productService.find(productId);
		model.addAttribute("product",product);	
		return "/inventory/addProduct";
		
	}
	

	


		
	
	
	
	
	
	
}
