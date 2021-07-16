package com.ugurhmz.springclient.data.client.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ugurhmz.springclient.business.dto.ProductDTO;
import com.ugurhmz.springclient.data.client.ProductClient;


@Component
public class ProductClientImpl implements ProductClient {

	private final static String BASE_URL ="http://localhost:8080/rest/product";
	private RestTemplate restTemplate = new RestTemplate();
	
	
	//GET PRODUCT
	@Override
	public ProductDTO getProduct(long productId) {
		String url = BASE_URL +"/"+productId;
		ProductDTO productDto = restTemplate.getForObject(url, ProductDTO.class);
		return productDto;
	}

	
	//LIST
	@Override
	public List<ProductDTO> getAllProducts() {
		String url = BASE_URL +"s";
		ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
				url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<ProductDTO>>() {});
					
		List<ProductDTO>  productDtoList  = response.getBody();
		return productDtoList;			
	}
	

	//POST
	@Override
	public ProductDTO postProduct(ProductDTO productDto) {
		String url = BASE_URL;
		ProductDTO result = restTemplate.postForObject(url, productDto, ProductDTO.class);
		return result;
	}

	
	//PUT
	@Override
	public void putProduct(ProductDTO productDto ) {
		String url = BASE_URL;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(
				url, HttpMethod.PUT, new HttpEntity<ProductDTO>(productDto), Void.class	);
		
	}

	
	//DELETE
	@Override
	public void deleteProduct(long productId) {
		String url = BASE_URL+"/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
		
	}

}









