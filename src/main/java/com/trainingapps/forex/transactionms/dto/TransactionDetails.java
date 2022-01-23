package com.trainingapps.forex.transactionms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TransactionDetails {
	
	@NotNull
	@Min(1)
	private Long transactionId;
	@NotNull
	@Min(1)
	private Long userId;
	@NotNull
	@Length(min = 1, max = 20)
	private String transactionDate;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientName;
	@NotNull
	@Min(1000000000)
	private Long recipientAccountNo;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientEmail;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientCountry;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientAddress;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientState;
	@NotNull
	@Length(min = 1, max = 20)
	private String recipientCity;
	@NotNull
	@Min(100000)
	private Long recipientPincode;
	@NotNull
	@Min(1)
	private double amountTransferred;
	@NotNull
	@Length(min = 1, max = 20)
	private String  currencyExchangeFrom;
	@NotNull
	@Length(min = 1, max = 20)
	private String  currencyExchangeTo;
	@NotNull
	@Length(min = 1, max = 20)
	private String transactionStatus;
	

	
	public TransactionDetails() {
		super();
	}



	public TransactionDetails(Long transactionId, Long userId, String transactionDate, String recipientName, Long recipientAccountNo,
			String recipientEmail, String recipientCountry, String recipientAddress, String recipientState,
			String recipientCity, Long recipientPincode, double amountTransferred, String currencyExchangeFrom,
			String currencyExchangeTo, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionDate=transactionDate;
		this.recipientName = recipientName;
		this.recipientAccountNo = recipientAccountNo;
		this.recipientEmail = recipientEmail;
		this.recipientCountry = recipientCountry;
		this.recipientAddress = recipientAddress;
		this.recipientState = recipientState;
		this.recipientCity = recipientCity;
		this.recipientPincode = recipientPincode;
		this.amountTransferred=amountTransferred;
		this.currencyExchangeFrom = currencyExchangeFrom;
		this.currencyExchangeTo = currencyExchangeTo;
		this.transactionStatus = transactionStatus;
	}



	public Long getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getRecipientName() {
		return recipientName;
	}



	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}



	public Long getRecipientAccountNo() {
		return recipientAccountNo;
	}



	public void setRecipientAccountNo(Long recipientAccountNo) {
		this.recipientAccountNo = recipientAccountNo;
	}



	public String getRecipientEmail() {
		return recipientEmail;
	}



	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}



	public String getRecipientCountry() {
		return recipientCountry;
	}



	public void setRecipientCountry(String recipientCountry) {
		this.recipientCountry = recipientCountry;
	}



	public String getRecipientAddress() {
		return recipientAddress;
	}



	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}



	public String getRecipientState() {
		return recipientState;
	}



	public void setRecipientState(String recipientState) {
		this.recipientState = recipientState;
	}



	public String getRecipientCity() {
		return recipientCity;
	}



	public void setRecipientCity(String recipientCity) {
		this.recipientCity = recipientCity;
	}



	public Long getRecipientPincode() {
		return recipientPincode;
	}



	public void setRecipientPincode(Long recipientPincode) {
		this.recipientPincode = recipientPincode;
	}



	public String getCurrencyExchangeFrom() {
		return currencyExchangeFrom;
	}



	public void setCurrencyExchangeFrom(String currencyExchangeFrom) {
		this.currencyExchangeFrom = currencyExchangeFrom;
	}



	public String getCurrencyExchangeTo() {
		return currencyExchangeTo;
	}



	public void setCurrencyExchangeTo(String currencyExchangeTo) {
		this.currencyExchangeTo = currencyExchangeTo;
	}



	public String getTransactionStatus() {
		return transactionStatus;
	}



	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getAmountTransferred() {
		return amountTransferred;
	}



	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}



	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", userId=" + userId + ", transactionDate="
				+ transactionDate + ", recipientName=" + recipientName + ", recipientAccountNo=" + recipientAccountNo
				+ ", recipientEmail=" + recipientEmail + ", recipientCountry=" + recipientCountry
				+ ", recipientAddress=" + recipientAddress + ", recipientState=" + recipientState + ", recipientCity="
				+ recipientCity + ", recipientPincode=" + recipientPincode + ", amountTransferred=" + amountTransferred
				+ ", currencyExchangeFrom=" + currencyExchangeFrom + ", currencyExchangeTo=" + currencyExchangeTo
				+ ", transactionStatus=" + transactionStatus + "]";
	}

	
	

}
