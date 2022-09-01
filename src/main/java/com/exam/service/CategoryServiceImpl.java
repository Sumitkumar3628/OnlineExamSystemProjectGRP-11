package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.CategoryDao;
import com.exam.entity.exam.Category;
import com.exam.exceptions.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao c_dao;

	@Override
	public Category addCategory(Category category) {
		return this.c_dao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.c_dao.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<Category>(this.c_dao.findAll());
	}

	@Override
	public Category getCategory(int categoryId) {
		return this.c_dao.findById(categoryId).get(); //this returns optional so we do get to get category object as we need to return category
	}

	@Override
	public void deleteCategory(int categoryId) {
		 Category category = new Category();
	     category.setCid(categoryId);
		this.c_dao.deleteById(categoryId);
	}

	@Override
	public void deleteByTitle(String title) throws CategoryNotFoundException {
		Category c1=this.c_dao.findByTitle(title);
		this.c_dao.delete(c1);
		
	}
}
