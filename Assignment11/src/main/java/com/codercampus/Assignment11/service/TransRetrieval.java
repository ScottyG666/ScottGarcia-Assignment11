package com.codercampus.Assignment11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransRetrieval {

	
	@Autowired
	private TransactionRepository transRepo;
	
	@Autowired
	private TransOrganizer tO;

	public Object findAll() {
		List<Transaction> preOrganizedList =  transRepo.findAll() ;
		
		List<Transaction> postOrganizedList = tO.reorganizeByDate(preOrganizedList);
		
		return  postOrganizedList ;
	}
	
	
	public Transaction findById (Integer idForQuery) {
		
		return transRepo.findById(idForQuery );
	}
	
	
}
