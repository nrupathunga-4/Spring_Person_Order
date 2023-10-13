package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.service.ApiService;

@RestController
public class Apicontroller {

	@Autowired
	private ApiService apiService;
	
	@PostMapping("/save")
	public ResponseEntity<Products> saveProduct(@RequestBody  Products products)
	{
		return new ResponseEntity<Products>(apiService.saveProduct(products),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{productid}")
	public ResponseEntity<Products> getProductById(@PathVariable  String productid)
	{
		return new ResponseEntity<Products>(apiService.getProductById(productid),HttpStatus.OK);   
	}
	
	@PutMapping("/update/{productid}")
	public ResponseEntity<Products> updateProduct(@RequestBody  Products products,@PathVariable  String productid)
	{
		return new ResponseEntity<Products>(apiService.updateProduct(products, productid),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable  String productid)
	{
		apiService.deleteProduct(productid);
		return new ResponseEntity<String>("Product is Deleted From Database",HttpStatus.OK); 
	}
}
