package com.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ReportDao;
import com.exam.dao.UserDao;
import com.exam.entity.Report;
import com.exam.entity.User;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao rdao;
	
	@Autowired
	private UserDao udao;
	
	
	@Override
	public Report createReport(Report report) {
		return rdao.save(report);
	}

	@Override
	public List<Report> viewReport(int id) {
		User local = this.udao.findById(id);
		List<Report> report = this.rdao.findAllById(local.getId());
		return report;
		
	}

	@Override
	public List<Report> getAllByUserId(int id) {
		List<Report> lisRep = rdao.findAll();
		List<Report> repList = new ArrayList<>();
		for(Report r:lisRep) {
			if(r.getUser().getId() == id) {
				repList.add(r);
			}
		}
		
		return repList;
	}

	@Override
	public List<Report> findAllByTech(String tech) {
		return rdao.findAllByCategory(tech);
	}

	@Override
	public List<Report> getAll() {
		return rdao.findAll();
	}

}
