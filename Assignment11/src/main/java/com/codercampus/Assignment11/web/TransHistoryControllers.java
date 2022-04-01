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

	/*
	 * this class is the service for fetching things from the Repository as well as reaching into 
	 * the TransOrganizer class for any sorting or organization
	 */
	@Autowired
	private TransRetrieval tR;
	
	//this mapping is for the root transaction page listing the transactions inside a table
	@GetMapping("/transactions") 
	public String getTransactionHistory (ModelMap model){
		
		//adding the ArrayList to the MVC under the key "transList"
		model.put("transList", tR.findAll());
		
		return "transactions";
	}
	
	
	/*
		getMapping for reaching into the transactions information by fetching it from the ArrayList
		and placing it into the MVC under the Key retrievedTransaction
		
		 --Directs to the HTML page *transWithId* to separate the code from the root page, displaying
		 the specified information instead of the entire list
		 
	 */
	@GetMapping("/transactions/{transId}")
	public String getSpecificTransactionInformation (@PathVariable Long transId ,ModelMap model) {
		
		
		model.put("retrievedTransaction", tR.findById(transId));
		
		
		return "transWithId";
	}
	
	

	
}
