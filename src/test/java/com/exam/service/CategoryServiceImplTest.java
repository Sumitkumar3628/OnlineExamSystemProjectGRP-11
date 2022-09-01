package com.exam.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.dao.CategoryDao;
import com.exam.entity.exam.Category;
import com.exam.exceptions.CategoryNotFoundException;

@SpringBootTest
class CategoryServiceImplTest {
	
	@Autowired
	private CategoryService cService;
	@Autowired
	private CategoryDao cDao;

	@Test
	void testAddCategory() {
		Category c1=new Category();
		c1.setCid(2);
		c1.setDescription("Java");
		c1.setTitle("suraj");
		Category c2 = cService.addCategory(c1);
		assertThat(c2.getTitle()).isEqualTo("suraj");
	}

	@Test
	void testUpdateCategory() {
		Category c1=new Category();
		c1.setCid(2);
		c1.setDescription("Java");
		c1.setTitle("suraj");
		Category c2 = cService.addCategory(c1);
		if(c2.getTitle()=="suraj") {
			c2.setTitle("soni");
		}
		c2=cService.updateCategory(c2);
		assertThat(c2.getTitle()).isEqualTo("soni");
	}

	@Test
	void testGetCategories() {
		
		Category c1=new Category();
		c1.setCid(6);
		c1.setDescription("Java");
		c1.setTitle("shashikant");
		c1=cService.addCategory(c1);
		Category c2=new Category();
		c2.setCid(7);
		c2.setDescription("Java");
		c2.setTitle("Mirzapur");
		c2=cService.addCategory(c2);
		
		assertTrue(cService.getCategories().size()>1);
		
	}

	@Test
	void testGetCategory() {
		Category c1=new Category();
		c1.setCid(2);
		c1.setDescription("Java");
		c1.setTitle("Sassy");
		c1=cService.addCategory(c1);
		Category c2=cDao.findByTitle("Sassy");
		cDao.delete(c2);
		assertEquals( "Sassy",c2.getTitle());
	}

	@Test
	void testDeleteCategory() throws CategoryNotFoundException {
		Category c1=new Category();
		c1.setCid(2);
		c1.setDescription("Java");
		c1.setTitle("surya");
		c1=cService.addCategory(c1);
		Category c2=cDao.findByTitle("surya");
		cService.deleteCategory(c2.getCid());
		Category c3=cDao.findByTitle("surya");
		assertNull(c3);
		
	}

}
