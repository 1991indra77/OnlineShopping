package com.indra.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indra.shoppingbackend.dao.ProductDAO;
import com.indra.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	private ProductDAO productDao;

	public void setProdiuctDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.getAllActiveProducts();
	}
	
	@RequestMapping("/category/{categoryId}/products")
	@ResponseBody
	public List<Product> getProductsByCategoryId(@PathVariable("categoryId")String categoryId)
	{
		return productDao.getProductByCategory(Integer.valueOf(categoryId));
	}
}
