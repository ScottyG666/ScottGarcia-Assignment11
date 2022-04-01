package com.codercampus.Assignment11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransRetrieval {

	
	@Autowired
	private TransactionRepository transRepo;
	
	
	//i added an additional service to organize the incoming ArrayList of transactions to 
	//reduce bloat in this class, and for future functionality
	@Autowired
	private TransOrganizer tO;

	public Object findAll() {
		return tO.reorganizeByDate(transRepo.findAll());
	}
	
	
	public Transaction findById (Long transId) {
		//iterating through entire list of transactions from the repository and single 
		//the Transaction with the matching ID, or Null if no ID matched
		for (Transaction trans : transRepo.findAll()) {
			if (trans.getId().equals(transId)) {
				return trans;
			}
		}
		 
		return null;
	}
	
	
}
