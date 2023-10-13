package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ApiService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Products saveProduct(Products products)
	{
		return productRepository.save(products);
	}

	public Products getProductById(String productid)
	{
		return productRepository.findByProductid(productid);
	}
	
	public Products updateProduct(Products products,String productid)
	{
		Products products2=productRepository.findByProductid(productid);
		products2.setManufacturingdate(products.getManufacturingdate());
		products2.setExpirydate(products.getExpirydate());
		
		productRepository.save(products2);
		return products2;
		
	}

	public void deleteProduct(String productid)
	{
		productRepository.findByProductid(productid);
		productRepository.deleteById(productid);
	}
}
