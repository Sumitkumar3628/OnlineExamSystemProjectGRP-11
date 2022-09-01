package com.exam.service;

import java.util.List;

import com.exam.entity.Report;

public interface ReportService {
	
	public Report createReport(Report report);
	public List<Report> viewReport(int id);
	public List<Report> getAllByUserId(int id);
	public List<Report> findAllByTech(String tech);
	public List<Report> getAll();

}
