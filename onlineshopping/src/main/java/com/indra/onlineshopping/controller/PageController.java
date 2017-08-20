package com.indra.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.indra.shoppingbackend.dao.CategoryDAO;


@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickHome", true);
		return mv;
		
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
		
	}
	
	/**
	 * Show all products and category-wise products
	 */
	
	@RequestMapping(value={"/show/allProducts"})
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickShowAllProducts", true);
		return mv;
		
	}
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", categoryDao.getCategory(id).getName());
		mv.addObject("categories", categoryDao.list());
		mv.addObject("category", categoryDao.getCategory(id));
		mv.addObject("userClickShowCategoryProducts", true);
		return mv;
		
	}
	
	
	
	
	
}
