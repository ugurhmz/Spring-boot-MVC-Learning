package com.ugurhmz.springclient.business.service;

import java.util.List;

import com.ugurhmz.springclient.business.dto.ProductDTO;

public interface ProductService {

	
	public void save(ProductDTO productDto);
	
	public ProductDTO find(Long productId);
	
	public List<ProductDTO> findAll();
	
	public void delete(Long productId);
	
}
