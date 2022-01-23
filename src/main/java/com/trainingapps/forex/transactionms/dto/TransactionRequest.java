package com.trainingapps.forex.transactionms.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TransactionRequest {

	@NotNull(message="USER ID should not be empty")
	@Min(value=1, message="Enter valid User Id")
	private Long userId;
	@NotNull(message="TRANSACTION DATE should not be empty")
	@Length(min = 1, max = 20)
	private String transactionDate;
	@NotNull(message="RECIPIENT NAME should not be empty")
	@Length(min = 1,message="Enter Name")
	private String recipientName;
	@NotNull(message="ACCOUNT NUMBER should not be empty")
	@Min(value=1000000000, message="Please enter valid Account Number")
	private Long recipientAccountNo;
	@NotNull(message="EMAIL should not be empty")
	@Length(min = 1,message="Enter Name")
	@Email(message="Enter a valid email Id")
	private String recipientEmail;
	@NotNull(message="COUNTRY should not be empty")
	@Length(min = 1,message="Enter Country")
	private String recipientCountry;
	@NotNull(message="ADDRESS should not be empty")
	@Length(min = 1,message="Enter Address")
	private String recipientAddress;
	@NotNull(message="STATE should not be empty")
	@Length(min = 1,message="Enter State")
	private String recipientState;
	@NotNull(message="CITY should not be empty")
	@Length(min = 1,message="Enter City")
	private String recipientCity;
	@NotNull(message="PINCODE should not be empty")
	@Min(value=100000,message="Please enter valid pincode")
	private Long recipientPincode;
	@NotNull(message="AMOUNT should not be empty")
	@Min(value=1, message="Amount cannot be zero")
	private double amountTransferred;
	@NotNull(message="ENTER CURRENCY")
	@Length(min = 1, max = 20)
	private String currencyExchangeFrom;
	@NotNull(message="ENTER CURRENCY")
	@Length(min = 1, max = 20)
	private String currencyExchangeTo;
	@NotNull(message="ENTER TRANSACTION STATUS")
	@Length(min = 1, max = 20)
	private String transactionStatus;
	
	
	public TransactionRequest() {
		super();
	}


	public TransactionRequest(Long userId, String transactionDate, String recipientName, Long recipientAccountNo, String recipientEmail,
			String recipientCountry, String recipientAddress, String recipientState, String recipientCity,
			Long recipientPincode, double amountTransferred, String currencyExchangeFrom, String currencyExchangeTo,
			String transactionStatus) {
		super();
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
		return "TransactionRequest [userId=" + userId + ", transactionDate=" + transactionDate + ", recipientName="
				+ recipientName + ", recipientAccountNo=" + recipientAccountNo + ", recipientEmail=" + recipientEmail
				+ ", recipientCountry=" + recipientCountry + ", recipientAddress=" + recipientAddress
				+ ", recipientState=" + recipientState + ", recipientCity=" + recipientCity + ", recipientPincode="
				+ recipientPincode + ", amountTransferred=" + amountTransferred + ", currencyExchangeFrom="
				+ currencyExchangeFrom + ", currencyExchangeTo=" + currencyExchangeTo + ", transactionStatus="
				+ transactionStatus + "]";
	}


	
}
