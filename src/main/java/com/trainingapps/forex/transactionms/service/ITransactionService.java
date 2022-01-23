package com.trainingapps.forex.transactionms.service;




import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import com.trainingapps.forex.transactionms.dto.TransactionDetails;
import com.trainingapps.forex.transactionms.dto.TransactionRequest;
//import com.trainingapps.forex.transactionms.vo.ResponseTemplateVO;

@Validated
public interface ITransactionService {
	
	TransactionDetails createTransaction(@Valid TransactionRequest request);
	
	List<TransactionDetails> fetchAll();

	List<TransactionDetails> fetchAllByUserId(@Min(1) Long userId);
	
	TransactionDetails fetchAllByTransactionId(@Min(1) Long transactionId);
	
	List<TransactionDetails> findAllTransactionsInPeriod(@Length(min=1, max=20) String startDate, String endDate);
	
	List<TransactionDetails> findByUserIdInPeriod(@Min(1) Long userId,@Length(min=1, max=20) String startDate, @Length(min=1, max=20) String endDate);

	Set<Long> findTransactionIds(String startDate, String endDate);

	
	//ResponseTemplateVO fetchUserWithTransaction(@Min(1) Long userId);
	
}
