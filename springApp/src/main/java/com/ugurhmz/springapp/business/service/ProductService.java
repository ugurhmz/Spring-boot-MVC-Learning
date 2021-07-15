package com.ugurhmz.springapp.business.service;

import java.util.List;

import com.ugurhmz.springapp.business.dto.ProductDTO;




public interface ProductService {
	
	
	public void save(ProductDTO productDto);
	
	public ProductDTO find(long productId);
	
	public List<ProductDTO> findAll();
	
}
