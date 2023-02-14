package com.cetpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Product;
import com.cetpa.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;

	public void  saveRecord(Product product)
	{
		repo.save(product);
	}
	
	public List<Product>  getList()
	{
		List<Product> list=repo.findAll();
		return list;
	}
	public Product getRecord( int pid)
	{
		Product p=repo.findById(pid).orElse(null);
		return p;
	}
		
	public void getDeleted(int pid)
	{
		repo.deleteById(pid);
	}
	
	public void  updateProduct(Product product)
	{
		repo.save(product);
	}
	}


