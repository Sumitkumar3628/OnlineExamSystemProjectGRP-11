package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Report;
import com.exam.service.ReportService;

@RestController
@CrossOrigin("*")
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService rserv;
	
	@PostMapping("/add")
	public Report createReport(@RequestBody Report report){
		rserv.createReport(report);
		return report;
	}
	
	@GetMapping("/{id}")//not in use
	public List<Report> showReport(@PathVariable int id){
		List<Report> rlist = rserv.viewReport(id);
		return rlist;
	}
	
	@GetMapping("/showAll/{id}")
	public List<Report> showAllReport(@PathVariable int id){
		List<Report> rlist = rserv.getAllByUserId(id);
		return rlist;
	}
	

}
