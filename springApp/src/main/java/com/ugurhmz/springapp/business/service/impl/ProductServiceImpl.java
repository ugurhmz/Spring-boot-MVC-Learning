package com.ugurhmz.springapp.business.service.impl;

import java.util.ArrayList;
import java.util.List;
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
		convertToEntity(productDto, product);
		productRepository.save(product);
		
	}

	
	
	// FIND BY ID İŞ MANTIĞINI VERİ TABANINDAN KOPARTIYOR 
	@Override
	public ProductDTO find(long productId) {
		ProductDTO productDto = new ProductDTO();
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			
			Product product = optional.get();
			convertToDto(product, productDto);
			
			
		} else {
			productDto = new ProductDTO(0,"",0.0);	
		}
		
		return productDto;	
	}



	//GET FIND ALL
	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> productDtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findAll();
		
		for(Product prd : products) {
			ProductDTO productDto = new ProductDTO();
			convertToDto(prd, productDto);
			productDtos.add(productDto);
		}
		
		return productDtos;
	}
	
	
	// Convert To DTO
	private void convertToDto(Product product, ProductDTO productDto) {
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
	
	}
	
	
	
	// Convert To Entity
	private void convertToEntity(ProductDTO productDto, Product product) {
			product.setProductId(productDto.getProductId());
			product.setProductName(productDto.getProductName());
			product.setSalesPrice(productDto.getSalesPrice());
	}
	

}











