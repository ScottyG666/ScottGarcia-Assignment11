package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	
	private Map<Long, Transaction> transactionsMap = new LinkedHashMap<>();
	
	public TransactionRepository () {
		super();
		populateData();
	}
	
	public List<Transaction> findAll () {
		return transactions;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
			
			
//			this.transactions.stream().forEach(tranny -> this.transactionsMap.put(tranny.getId(), tranny));
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	public Transaction findById(Long transactionID) {
		
		 Transaction trans = transactions.stream().filter(bullShit -> bullShit.getId() == transactionID)
												  .collect(Collectors.toCollection(null));
		
		return null;
	}
}
