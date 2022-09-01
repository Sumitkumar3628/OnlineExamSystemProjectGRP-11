package com.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.dao.QuizDao;
import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;


@SpringBootTest
class QuizServiceImplTest {
	
	@Autowired
	private QuizService qService;
	@Autowired
	private CategoryService cService;
	@Autowired
	private QuizDao qDao;

	@Test
	void testAddQuiz() {
		Category c1 = new Category();
		c1.setCid(1);
		c1.setDescription("Java");
		c1.setTitle("To Test");
		c1 = cService.addCategory(c1);
		Quiz q=new Quiz();
		q.setQid(1);
		q.setTitle("Java");
		q.setDescription("Java Quiz");
		q.setMaxMarks("100");
		q.setCategory(c1);
		q=qService.addQuiz(q);
		assertEquals("Java",q.getTitle());
	}

	@Test
	void testUpdateQuiz() {
		Category c1 = new Category();
		c1.setCid(1);
		c1.setDescription("Java");
		c1.setTitle("To Test");
		c1 = cService.addCategory(c1);
		Quiz q=new Quiz();
		q.setQid(1);
		q.setTitle("Java");
		q.setDescription("Java Quiz");
		q.setMaxMarks("100");
		q.setCategory(c1);
		q=qService.addQuiz(q);
		if(q.getMaxMarks()=="100") {
			q.setMaxMarks("150");
		}
		q=qService.updateQuiz(q);
		assertEquals("150",q.getMaxMarks());
	}

	@Test
	void testGetQuizzes() {
		Category c1 = new Category();
		c1.setCid(1);
		c1.setDescription("Java");
		c1.setTitle("To Test");
		c1 = cService.addCategory(c1);
		Quiz q=new Quiz();
		q.setQid(1);
		q.setTitle("Java");
		q.setDescription("Java Quiz");
		q.setMaxMarks("100");
		q.setCategory(c1);
		q=qService.addQuiz(q);
		Quiz q2=new Quiz();
		q2.setQid(2);
		q2.setTitle("C++");
		q2.setDescription("C++ Quiz");
		q2.setMaxMarks("100");
		q2.setCategory(c1);
		q2=qService.addQuiz(q);
		Set<Quiz> quizSet=new HashSet<Quiz>();
		quizSet.add(q);
		quizSet.add(q2);
		Assertions.assertTrue(qService.getQuizzes().size() > 1);
	}

	@Test
	void testGetQuizById() {
		Category c1 = new Category();
		c1.setCid(1);
		c1.setDescription("Java");
		c1.setTitle("To Test");
		c1 = cService.addCategory(c1);
		Quiz q=new Quiz();
		q.setQid(1);
		q.setTitle("Java");
		q.setDescription("Java Quiz");
		q.setMaxMarks("100");
		q.setCategory(c1);
		q=qService.addQuiz(q);
		Assertions.assertEquals("Java Quiz", qService.getQuizById(q.getQid()).getDescription());
	}

	@Test
	void testDeleteQuiz() {
		Category c1 = new Category();
		c1.setCid(1);
		c1.setDescription("Java");
		c1.setTitle("To Test");
		c1 = cService.addCategory(c1);
		Quiz q=new Quiz();
		q.setQid(1);
		q.setTitle("C++");
		q.setDescription("Java Quiz");
		q.setMaxMarks("100");
		q.setCategory(c1);
		q=qService.addQuiz(q);
		qService.deleteByTitle("C++");
		Quiz q2=qDao.findByTitle("C++");
		assertNull(q2);
	}

}