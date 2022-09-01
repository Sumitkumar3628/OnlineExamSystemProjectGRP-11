package com.exam.service;

import java.util.Set;

import com.exam.entity.exam.Category;
import com.exam.exceptions.CategoryNotFoundException;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(int categoryId);
	public void deleteCategory(int categoryId)throws CategoryNotFoundException ;
	public void deleteByTitle(String title)throws CategoryNotFoundException;

}
