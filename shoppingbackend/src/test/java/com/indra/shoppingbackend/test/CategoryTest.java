package com.indra.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indra.shoppingbackend.dao.CategoryDAO;
import com.indra.shoppingbackend.dto.Category;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDao;
	private static Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.indra.shoppingbackend");
		context.refresh();
		
		categoryDao =(CategoryDAO) context.getBean("categoryDao");
		
	}
	
		
	@Test
	public void categoryCRUDOperation()
	{
		//adding objects
		category=new Category("Mobile", "This is Mobile Description", "Cat_1.jpg", 0);
		assertEquals("Successfully added",true,categoryDao.addCategory(category));
		
		category=new Category("Laptop", "This is laptop Description", "Cat_2.jpg", 0);
		assertEquals("successfully added",true,categoryDao.addCategory(category));
		
		category=new Category("Television", "This is Television Description", "Cat_3.jpg", 0);
		assertEquals("successfully added",true,categoryDao.addCategory(category));
		
		//update Category
		
		category=categoryDao.getCategory(36);
		category.setName("TV");
		assertEquals("Successfully Update",true,categoryDao.update(category));
		
		//delete Category
		category=categoryDao.getCategory(36);
		assertEquals("Successfully Deleted Entry",true,categoryDao.delete(category));
		
		//get all the active categories
		assertEquals("Fetched the List of categories", 2,categoryDao.list().size());
		
	}
	
}
