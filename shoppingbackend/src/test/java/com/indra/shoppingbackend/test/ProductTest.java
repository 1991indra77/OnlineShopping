package com.indra.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indra.shoppingbackend.dao.ProductDAO;
import com.indra.shoppingbackend.dto.Product;

public class ProductTest {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDao;
	private static Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.indra.shoppingbackend");
		context.refresh();
		
		productDao=context.getBean("productDao", ProductDAO.class);
	}
	
	@Test
	public void productCRUDOperation()
	{
		//adding objects
		product=new Product();
		product.setName("One Plus 3");
		product.setBrand("OnePlus");
		product.setDescription("This is the flagship killer phone");
		product.setIsActive(0);
		product.setQuantity(20);
		product.setSupplierId(2);
		product.setUnitPrice(26999.00);
		product.setCategoryId(3);
		
		//Insert a new Product
		assertEquals("successfully added",true,productDao.addProduct(product));
		
		//get Product by Product Id
		
		assertEquals("Get Product Successfully", "Lenevo K5 Note",productDao.getProduct(3).getName());
		
		//get all the products
		
		assertEquals("Get all the products successfully", 8,productDao.getAllProducts().size());
		
		//update Product
		
		product=productDao.getProduct(4);
		product.setName("Lenevo Ideapad Core i5");
		assertEquals("Updation success", true,productDao.updateProduct(product));
		
		//delete Product
		
		product=productDao.getProduct(4);
		assertEquals("Successfully Deleted Entry",true,productDao.removeProduct(product));
		
		//get all the active products
		
		assertEquals("Fetched the List of products",7,productDao.getAllActiveProducts().size());
		
		//get product by category Id
		
		assertEquals("Fetched Products by category Id", 4,productDao.getProductByCategory(3).size());
		
		//get latest Products
		
		assertEquals("Fetched latest products",4,productDao.getLatestActiveProducts(4).size());
	}

}
