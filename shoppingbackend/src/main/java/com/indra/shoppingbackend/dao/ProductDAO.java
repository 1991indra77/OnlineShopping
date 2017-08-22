package com.indra.shoppingbackend.dao;

import java.util.List;

import com.indra.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	public Product getProduct(int productId);
	public List<Product> getAllProducts();
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean removeProduct(Product product);
	
	//business Methods
	public List<Product> getAllActiveProducts();
	public List<Product> getProductByCategory(int categoryId);
	public List<Product> getLatestActiveProducts(int count);
	

}
