package com.trainingapps.forex.transactionms.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.forex.transactionms.constants.CurrencyEnum;
import com.trainingapps.forex.transactionms.constants.TransactionStatusEnum;
import com.trainingapps.forex.transactionms.dto.TransactionDetails;
import com.trainingapps.forex.transactionms.entity.Transaction;
import com.trainingapps.forex.transactionms.exceptions.CurrencyNotAvailableException;
import com.trainingapps.forex.transactionms.exceptions.InvalidStatusException;

@Component
public class Utility {
	
	@Autowired
	private DateConverter dateConverter;

	public TransactionDetails toTransactionDetails(Transaction transaction) {
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(transaction.getTransactionId());
		transactionDetails.setUserId(transaction.getUserId());
		transactionDetails.setTransactionDate(dateConverter.toText(transaction.getTransactionDate()));
		transactionDetails.setRecipientName(transaction.getRecipientName());
		transactionDetails.setRecipientAccountNo(transaction.getRecipientAccountNo());
		transactionDetails.setRecipientEmail(transaction.getRecipientEmail());
		transactionDetails.setRecipientAddress(transaction.getRecipientAddress());
		transactionDetails.setRecipientCountry(transaction.getRecipientCountry());
		transactionDetails.setRecipientState(transaction.getRecipientState());
		transactionDetails.setRecipientCity(transaction.getRecipientCity());
		transactionDetails.setRecipientPincode(transaction.getRecipientPincode());
		transactionDetails.setAmountTransferred(transaction.getAmountTransferred());
		transactionDetails.setCurrencyExchangeFrom(transaction.getCurrencyExchangeFrom().name());
		transactionDetails.setCurrencyExchangeTo(transaction.getCurrencyExchangeTo().name());
		transactionDetails.setTransactionStatus(transaction.getTransactionStatus().name());
		return transactionDetails;
	}
	
	public List<TransactionDetails> toTransactionDetailsList(List<Transaction> transactions) {

		return transactions.stream().map(transaction -> toTransactionDetails(transaction)).collect(Collectors.toList());

	}
	
	public CurrencyEnum toCurrencyEnum(String currencyText) {
		CurrencyEnum[] values = CurrencyEnum.values();
		for (CurrencyEnum type : values) {
			String currencytype = type.name();
			if (currencytype.equalsIgnoreCase(currencyText)) {
				return type;
			}
		}
		throw new CurrencyNotAvailableException("Conversion to '"+currencyText + "' is Invalid / Not Available");	
		
	}
	
	public TransactionStatusEnum toTransactionStatusEnum(String transactionStatusText) {
		TransactionStatusEnum[] values = TransactionStatusEnum.values();
		for (TransactionStatusEnum type : values) {
			String transactionStatustype = type.name();
			if (transactionStatustype.equalsIgnoreCase(transactionStatusText)) {
				return type;
			}
		}
		throw new InvalidStatusException("Transaction status '"+transactionStatusText + "' is Invalid");
	}
}
