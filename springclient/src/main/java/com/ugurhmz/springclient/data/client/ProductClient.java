package com.ugurhmz.springclient.data.client;

import java.util.List;

import com.ugurhmz.springclient.business.dto.ProductDTO;

public interface ProductClient {
	
	public ProductDTO getProduct(long productId);
	public List<ProductDTO> getAllProducts();
	public ProductDTO postProduct(ProductDTO product);
	public void putProduct(ProductDTO product);
	public void deleteProduct(long productId);
	
	
	
	
	
}
