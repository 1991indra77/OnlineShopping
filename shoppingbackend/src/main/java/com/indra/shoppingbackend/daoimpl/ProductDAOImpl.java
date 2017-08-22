package com.indra.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indra.shoppingbackend.dao.ProductDAO;
import com.indra.shoppingbackend.dto.Category;
import com.indra.shoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Product getProduct(int productId) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		Session session=sessionFactory.getCurrentSession();
		String selectActiveCategory="from Product";
		Query query=session.createQuery(selectActiveCategory);
		List<Product> list=query.getResultList();

		return list;
		
	}

	@Override
	public boolean addProduct(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().merge(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeProduct(Product product) {

		try
		{
			product.setIsActive(1);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getAllActiveProducts() {
		
		Session session=sessionFactory.getCurrentSession();
		String selectActiveCategory="from Product where isActive = :active";
		Query query=session.createQuery(selectActiveCategory);
		query.setParameter("active", 0);
		List<Product> list=query.getResultList();

		return list;
	}

	@Override
	public List<Product> getProductByCategory(int categoryId) {
		
		Session session=sessionFactory.getCurrentSession();
		String selectActiveCategory="from Product where categoryId = :categoryId and isActive= :active";
		Query query=session.createQuery(selectActiveCategory);
		query.setParameter("categoryId", categoryId);
		query.setParameter("active", 0);
		List<Product> list=query.getResultList();
		return list;
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		Session session=sessionFactory.getCurrentSession();
		String selectActiveCategory="from Product where isActive = :active order by id";
		Query query=session.createQuery(selectActiveCategory);
		query.setParameter("active", 0);
		query.setFirstResult(0);
		query.setMaxResults(count);
		List<Product> list=query.getResultList();

		return list;
	}

}
