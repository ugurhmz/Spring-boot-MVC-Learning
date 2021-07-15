package com.ugurhmz.springclient.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springclient.business.dto.ProductDTO;
import com.ugurhmz.springclient.business.service.ProductService;
import com.ugurhmz.springclient.data.client.ProductClient;


@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductClient productClient;
	
	
	
	@Override
	public void save(ProductDTO productDto) {
		if(productDto.getProductId() == 0) {
			productClient.postProduct(productDto);
		}else {
			productClient.putProduct(productDto);
		}
		
	}

	
	@Override
	public ProductDTO find(Long productId) {
		ProductDTO productDto = null;
		
		if(productId != null) {
			productDto = productClient.getProduct(productId);
		}
		
		else {
			productDto = new ProductDTO(0,"",0.0);
		}
		
		return productDto;
	
	}

	@Override
	public List<ProductDTO> findAll() {
		return productClient.getAllProducts();
	}

	@Override
	public void delete(Long productId) {
		 productClient.deleteProduct(productId);
	}

}
