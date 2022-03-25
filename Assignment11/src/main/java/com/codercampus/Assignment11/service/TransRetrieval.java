package com.codercampus.Assignment11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransRetrieval {

	
	@Autowired
	private TransactionRepository transRepo;

	public Object findAll() {
		
		return transRepo.findAll();
	}
	
	
}
