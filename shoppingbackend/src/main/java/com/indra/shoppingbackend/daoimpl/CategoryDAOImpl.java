package com.indra.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indra.shoppingbackend.dao.CategoryDAO;
import com.indra.shoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	/**
	 * To get the list of categories
	 */
	@Override
	public List<Category> list() {
		
		Session session=sessionFactory.getCurrentSession();
		String selectActiveCategory="from Category where is_active = :active";
		Query query=session.createQuery(selectActiveCategory);
		query.setParameter("active", 0);
		List<Category> list=query.getResultList();

		return list;

	}

	/**
	 * To get a particular category using Id
	 */
	@Override
	public Category getCategory(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean addCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		
		Session session =sessionFactory.getCurrentSession();
		try
		{
			session.update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		Session session=sessionFactory.getCurrentSession();
		try
		{
			category.setActive(1);
			session.update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

}
