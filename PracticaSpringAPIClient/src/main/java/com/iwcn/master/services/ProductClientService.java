package com.iwcn.master.services;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestTemplate;

import com.iwcn.master.entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpMethod;

@Service
public class ProductClientService {
	
	private RestTemplate restTemplate;
	public ProductClientService()
	{
		this.restTemplate=new RestTemplate();
	}

    public void AddProduct(Product product) {
    	String url = "http://localhost:1234/addProduct";
    	this.restTemplate.postForObject(url, product, String.class);
    }
    public void EditProduct(Product product) {
    	String url = "http://localhost:1234/editProduct";
    	this.restTemplate.put(url, product);
    }
    public void DeleteProduct(Long index) {
    	String url="http://localhost:1234/deleteProduct?index="+index;
    	this.restTemplate.execute(url, HttpMethod.DELETE, null, null);
    }
    public Iterable<Product> GetAll(){
    	String url = "http://localhost:1234/productList";
    	Product[] ProductArray = this.restTemplate.getForObject(url, Product[].class);
    	return Arrays.asList(ProductArray);
    }
    public Product GetProduct(long index) {
    	String url="http://localhost:1234/showProduct?index="+index;
    	return this.restTemplate.getForObject(url, Product.class);
    }
}
