package com.ugurhmz.springapp.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ugurhmz.springapp.data.entity.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {

}
