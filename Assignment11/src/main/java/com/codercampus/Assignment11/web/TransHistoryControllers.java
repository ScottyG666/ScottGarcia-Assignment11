package com.codercampus.Assignment11.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransRetrieval;

@Controller
public class TransHistoryControllers {

	
	@Autowired
	private TransRetrieval tR;
	
	@GetMapping("/transactions") 
	public String getTransactionHistory (ModelMap model){
		
		model.put("transList", tR.findAll());
		
		return "transactions";
	}
	
	
	@GetMapping("/transactions/{transId}")
	public String getSpecificTransactionInformation (@PathVariable Long transId ,ModelMap model) {
		
		
		model.put("retrievedTransaction", tR.findById(transId));
		return "transWithId";
	}
	
	

	
}
