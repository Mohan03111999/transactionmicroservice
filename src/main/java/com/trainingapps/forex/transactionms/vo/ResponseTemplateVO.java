package com.trainingapps.forex.transactionms.vo;

import java.util.List;

import com.trainingapps.forex.transactionms.dto.TransactionDetails;

public class ResponseTemplateVO {
	
	private User user;
	private List<TransactionDetails> transactionDetails;
	
	
	
	
	public ResponseTemplateVO() {
		super();
	}



	public ResponseTemplateVO(List<TransactionDetails> transactionDetails, User user) {
		super();
		this.user = user;
		this.transactionDetails = transactionDetails;
		
	}



	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}



	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "ResponseTemplateVO [transactionDetails=" + transactionDetails + ", user=" + user + "]";
	}
	
	
	

}
