package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.exam.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	public Category findByTitle(String title);

}
