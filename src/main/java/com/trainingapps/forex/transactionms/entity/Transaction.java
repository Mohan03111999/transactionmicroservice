package com.trainingapps.forex.transactionms.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.trainingapps.forex.transactionms.constants.CurrencyEnum;
import com.trainingapps.forex.transactionms.constants.TransactionStatusEnum;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private Long userId;
	private LocalDate transactionDate;
	private String recipientName;
	private Long recipientAccountNo;
	private String recipientEmail;
	private String recipientCountry;
	private String recipientAddress;
	private String recipientState;
	private String recipientCity;
	private Long recipientPincode;
	private double amountTransferred;
	private CurrencyEnum currencyExchangeFrom;
	private CurrencyEnum currencyExchangeTo;
	private TransactionStatusEnum transactionStatus;
	
	
	
	public Transaction() {
		super();
	}



	public Transaction(Long transactionId, Long userId,LocalDate transactionDate, String recipientName, Long recipientAccountNo,
			String recipientEmail, String recipientCountry, String recipientAddress, String recipientState,
			String recipientCity, Long recipientPincode, double amountTransferred, CurrencyEnum currencyExchangeFrom,
			CurrencyEnum currencyExchangeTo, TransactionStatusEnum transactionStatus) {
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


	

	public LocalDate getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(LocalDate transactionDate) {
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



	public CurrencyEnum getCurrencyExchangeFrom() {
		return currencyExchangeFrom;
	}



	public void setCurrencyExchangeFrom(CurrencyEnum currencyExchangeFrom) {
		this.currencyExchangeFrom = currencyExchangeFrom;
	}



	public CurrencyEnum getCurrencyExchangeTo() {
		return currencyExchangeTo;
	}



	public void setCurrencyExchangeTo(CurrencyEnum currencyExchangeTo) {
		this.currencyExchangeTo = currencyExchangeTo;
	}



	public TransactionStatusEnum getTransactionStatus() {
		return transactionStatus;
	}



	public void setTransactionStatus(TransactionStatusEnum transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public double getAmountTransferred() {
		return amountTransferred;
	}



	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}


	@Override
	public int hashCode() {
		return Objects.hash(transactionId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(transactionId, other.transactionId);
	}



	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", transactionDate="
				+ transactionDate + ", recipientName=" + recipientName + ", recipientAccountNo=" + recipientAccountNo
				+ ", recipientEmail=" + recipientEmail + ", recipientCountry=" + recipientCountry
				+ ", recipientAddress=" + recipientAddress + ", recipientState=" + recipientState + ", recipientCity="
				+ recipientCity + ", recipientPincode=" + recipientPincode + ", amountTransferred=" + amountTransferred
				+ ", currencyExchangeFrom=" + currencyExchangeFrom + ", currencyExchangeTo=" + currencyExchangeTo
				+ ", transactionStatus=" + transactionStatus + "]";
	}




	
	
	


}
