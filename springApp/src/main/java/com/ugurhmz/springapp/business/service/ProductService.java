package com.ugurhmz.springapp.business.service;

import com.ugurhmz.springapp.business.dto.ProductDTO;




public interface ProductService {
	
	
	public void save(ProductDTO productDto);
	
	
	public ProductDTO find(long productId);
	
	
}
