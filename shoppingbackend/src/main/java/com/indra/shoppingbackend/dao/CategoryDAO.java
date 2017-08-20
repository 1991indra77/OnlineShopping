package com.indra.shoppingbackend.dao;

import java.util.List;

import com.indra.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	public List<Category> list();
	public Category getCategory(int id);
	public boolean addCategory(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);

}
