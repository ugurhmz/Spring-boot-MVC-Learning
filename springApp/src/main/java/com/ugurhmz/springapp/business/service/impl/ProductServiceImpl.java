package com.ugurhmz.springapp.business.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springapp.business.dto.ProductDTO;
import com.ugurhmz.springapp.business.service.ProductService;
import com.ugurhmz.springapp.data.entity.Product;
import com.ugurhmz.springapp.data.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	// SAVE 
	@Override
	public void save(ProductDTO productDto) {
		
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setSalesPrice(productDto.getSalesPrice());
		
		
		productRepository.save(product);
		
	}

	
	
	// İŞ MANTIĞINI VERİ TABANINDAN KOPARTIYOR 
	@Override
	public ProductDTO find(long productId) {
		ProductDTO productDto = new ProductDTO();
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
		} else {
			productDto = new ProductDTO(0,"",0.0);	
		}
		
		return productDto;	
	}
	
	
	

}
