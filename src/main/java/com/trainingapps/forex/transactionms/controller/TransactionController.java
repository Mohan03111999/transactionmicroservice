package com.trainingapps.forex.transactionms.controller;


//import java.time.LocalDate;
import java.util.List;
import java.util.Set;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.forex.transactionms.dto.TransactionDetails;
import com.trainingapps.forex.transactionms.dto.TransactionRequest;
import com.trainingapps.forex.transactionms.entity.Transaction;
import com.trainingapps.forex.transactionms.service.TransactionServiceImpl;
//import com.trainingapps.forex.transactionms.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	
	@PostMapping("/create")
	public TransactionDetails createTransaction(@RequestBody TransactionRequest request) {
		return transactionServiceImpl.createTransaction(request);
	}
	
	@GetMapping("/")
	public List<TransactionDetails> fetchAll(){
		return transactionServiceImpl.fetchAll();
	}
	
	@GetMapping("/paginationAndSort/{offset}/{pageSize}")
    private Page<Transaction> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Transaction> transactionsWithPagination = transactionServiceImpl.findTransactionssWithPagination(offset, pageSize);
        return transactionsWithPagination;
    }
	
	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private Page<Transaction> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Transaction> transactionsWithPaginationAndSort = transactionServiceImpl.findTransactionssWithPaginationAndSorting(offset, pageSize, field);
        return transactionsWithPaginationAndSort;
    }


	@GetMapping("/userid/{userId}")
	public List<TransactionDetails> fetchAllByUserId(@PathVariable Long userId){
		return transactionServiceImpl.fetchAllByUserId(userId);
	}
	
	@GetMapping("/transactionid/{transactionId}")
	public TransactionDetails fetchAllByTransactionId(@PathVariable Long transactionId){
		return transactionServiceImpl.fetchAllByTransactionId(transactionId);
	}
	
	@GetMapping("/startDate/{startDate}/endDate/{endDate}")
	public List<TransactionDetails> findAllTransactionsInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
		//System.out.println(startDate + " / " + endDate);
		return transactionServiceImpl.findAllTransactionsInPeriod(startDate, endDate);
		
	}
	
	@GetMapping("/userId/{userId}/startDate/{startDateText}/endDate/{endDateText}")
	public List<TransactionDetails> findByUserIdInPeriod(@PathVariable Long userId, @PathVariable String startDateText, @PathVariable String endDateText) {
		return transactionServiceImpl.findByUserIdInPeriod(userId, startDateText, endDateText);
	}
	
	
	@GetMapping("/report/{reportFormat}/{userId}")
	public String exportReport(@PathVariable String reportFormat,@PathVariable Long userId){
		return transactionServiceImpl.exportReport(reportFormat, userId);
	}
	
	@GetMapping("/findIds/startDate/{startDate}/endDate/{endDate}")
	public Set<Long> findTransactionIds(@PathVariable String startDate,@PathVariable String endDate) {
		return transactionServiceImpl.findTransactionIds(startDate, endDate);
	}
	
//	@GetMapping("/UserWithTransactions/{userId}")
//	public ResponseTemplateVO fetchUserWithTransaction(@PathVariable Long userId) {
//		return transactionServiceImpl.fetchUserWithTransaction(userId);
//	}
	
} 
