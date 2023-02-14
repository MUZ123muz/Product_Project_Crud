package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Product;
import com.cetpa.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
    
	@RequestMapping("")
	public String getHomeView()
	{
		return "Home";
	}
	
	@RequestMapping("insert")
	public String getInsertView()
	{
		return "insert";
	}
	
	@RequestMapping("save-record")
	public String getProductRecord(Product product)
	{
		service.saveRecord(product);
		return "save";
	}

	@RequestMapping("product-list")
	public String getProductList(Model model)
	{
		List<Product> list=service.getList();
		model.addAttribute("list",list);
		return "product-list";
	}

	@RequestMapping("search")
	public String getSearchRecord()
	{
		
		return "search";
	}
	
	@RequestMapping("search-record")
	public String getSearchProductRecord(int pid,Model model)
	{
		Product product =service.getRecord(pid);
		if(product==null)
		{
			model.addAttribute("msg","product with id "+pid+" not found");
			return "search";
		}
		model.addAttribute("p",product);
		
		return "show-record";
	}
	@RequestMapping("delete")
	public String getDeleteView()
	{
		
		return "delete";
	}
	
	@RequestMapping("delete-record")
	public String getDeleteProductRecord(int pid,Model model)
	{
		Product product =service.getRecord(pid);
		if(product==null)
		{
			model.addAttribute("msg","product with id "+pid+" not found");
			return "delete";
		}
		
		service.getDeleted(pid);
		model.addAttribute("msg","product with id "+pid+" has been deleted");
		return "delete";
	}
	
	@RequestMapping("edit")
	public String getEditRecord()
	{
		
		return "editview";
	}
	
	@RequestMapping("edit-record")
	public String getEditProductRecord(int pid,Model model)
	{
		Product product =service.getRecord(pid);
		if(product==null)
		{
			model.addAttribute("msg","product with id "+pid+" not found");
			return "search";
		}
		model.addAttribute("product",product);
		
		
		return "edit";
	}

	@RequestMapping("update-record")
	public String getUpdateRecord(Product product)
	{
		service.updateProduct(product);
		
		return "updateview";
	}
}
