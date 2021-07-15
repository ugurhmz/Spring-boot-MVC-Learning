package com.ugurhmz.springapp.business.service;

import java.util.List;

import com.ugurhmz.springapp.business.dto.ProductDTO;




public interface ProductService {
	
	// CREATE
	public void save(ProductDTO productDto);
	
	
	// FIND BY ID
	public ProductDTO find(Long productId);
	
	
	// FIND ALL
	public List<ProductDTO> findAll();
	
	
	// DELETE BY ID
	public void delete(long productId);
	
}
