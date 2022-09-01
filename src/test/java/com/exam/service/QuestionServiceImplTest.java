package com.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.dao.QuestionDao;
import com.exam.dao.QuizDao;
import com.exam.entity.exam.Category;
import com.exam.entity.exam.Questions;
import com.exam.entity.exam.Quiz;

@SpringBootTest
class QuestionServiceImplTest {
	
	@Autowired
	private QuestionService quService;
	@Autowired
	private QuizService qService;
	@Autowired
	private CategoryService cService;
	@Autowired
	private QuizDao qDao;
	@Autowired
	private QuestionDao quDao;

	@Test
	void testAddQuestion() {		
		Quiz q=qService.getQuizById(6);
		Category c=q.getCategory();		
		Questions q1=new Questions();
		q1.setQuesId(1);
		q1.setContent("Java");
		q1.setAnswer("OOPs");
		q1.setQuiz(q);
		Questions q2=quService.addQuestion(q1);
		assertEquals("OOPs",q2.getAnswer());
		
	}

	@Test
	void testUpdateQuestion() {
		Quiz q=qService.getQuizById(6);
		Category c=q.getCategory();		
		Questions q1=new Questions();
		q1.setQuesId(2);
		q1.setContent("C++");
		q1.setAnswer("OOPs");
		q1.setQuiz(q);
		Questions q2=quService.addQuestion(q1);
		if(q2.getAnswer()=="OOPs") {
			q2.setAnswer("MultiThreading");
		}
		Questions q3=quService.updateQuestion(q2);
		assertEquals(q2.getQuesId(),q3.getQuesId());
	}

	@Test
	void testGetQuestions() {
		Set<Questions> quSet=quService.getQuestions();
		assertTrue(quSet.size()>1);		
		
	}

	@Test
	void testGetQuestionById() {
		Questions ques=quService.getQuestionById(7);
		assertEquals("OOPs",ques.getAnswer());
		
	}

	@Test
	void testGetQuestionsOfQuiz() {
		Quiz q=qService.getQuizById(6);
		Set<Questions> quizSet=quService.getQuestionsOfQuiz(q);
		assertTrue(quizSet.size()>1);
	}

	@Test
	void testDeleteQuestion() {
		quService.deleteQuestion(8);
	//	Questions q2=quService.addQuestion(ques);
		Quiz q=qService.getQuizById(6);
		Questions ques1=quService.getQuestionById(8);
		assertNull(ques1);
		
	}

}