package com.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.dao.ReportDao;
import com.exam.entity.Report;

@SpringBootTest
class ReportServiceImplTest {
	
	@Autowired
	private ReportService rService;
	@Autowired
	private ReportDao rDao;
	
	@Autowired
	private UserServiceImpl userv;
	

	@Test
	void testCreateReport() 
	{
		Report rep1 = new Report();
		rep1.setId(1);
		rep1.setName("Report8");
		rep1.setResult("Pass");
		rep1.setScore(80);
		rep1.setCategory("C++");
		//rep1.setLev(2);
		rep1.setUser(userv.getById(10));
		Report createReport = rService.createReport(rep1);
//		assertEquals("Report1", createReport.getName());
	}

//	@Test
//	void testViewReport() 
//	{
//		Report rep3=rService.viewReport(1);
//		assertEquals("Report1",rep3.getName());
//	}
//
//	@Test
//	void testGetAll() 
//	{
//		Report rep2 = new Report();
//		rep2.setId(2);
//		rep2.setName("Report2");
//		rep2.setResult("pass");
//		rep2.setScore(100);
//		Report createReport = rService.createReport(rep2);
//		List<Report> rList = rService.getAll();
//		assertTrue(rList.size()>1);
//		
//		
//		
//	}

}