package com.trainingapps.forex.transactionms;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import com.trainingapps.forex.transactionms.dto.TransactionDetails;
import com.trainingapps.forex.transactionms.dto.TransactionRequest;
import com.trainingapps.forex.transactionms.entity.Transaction;
import com.trainingapps.forex.transactionms.repository.TransactionRepository;
import com.trainingapps.forex.transactionms.service.TransactionServiceImpl;
import com.trainingapps.forex.transactionms.util.DateConverter;
import com.trainingapps.forex.transactionms.util.Utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionmsApplicationTests {
	
	@Mock
	TransactionRepository repository;

	@Mock
	DateConverter converter;
	
	@Mock
	Utility util;

	@Spy
	@InjectMocks
	TransactionServiceImpl service;

//	@Test
//	void contextLoads() {
//	}
	
	@Test
	public void createTransactionTest() {
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setAmountTransferred(1000);
		transactionRequest.setCurrencyExchangeFrom("USD");
		transactionRequest.setCurrencyExchangeTo("INR");
		transactionRequest.setRecipientAccountNo(1234567890l);
		transactionRequest.setRecipientAddress("address");
		transactionRequest.setRecipientCity("chennai");
		transactionRequest.setRecipientCountry("India");
		transactionRequest.setRecipientEmail("abc@g.c");
		transactionRequest.setRecipientName("mohan");
		transactionRequest.setRecipientPincode(600029l);
		transactionRequest.setRecipientState("TN");
		transactionRequest.setTransactionStatus("Successful");
		transactionRequest.setUserId(1l);
		DateConverter dateConverter = new DateConverter();
		LocalDate date = LocalDate.of(2021, 07, 20);
		String dateText = dateConverter.toText(date);
		transactionRequest.setTransactionDate(dateText);
		when(converter.toDate(dateText)).thenReturn(date);
		Transaction transaction = new Transaction();
		TransactionDetails details = mock(TransactionDetails.class);
		when(repository.save(transaction)).thenReturn(transaction);
		when(util.toTransactionDetails(transaction)).thenReturn(details);
		TransactionDetails result=service.createTransaction(transactionRequest);
        assertEquals(details,result);
        assertEquals(1000,transactionRequest.getAmountTransferred());
        verify(repository).save(transaction);
	}
	
	@Test
	public void fetchAllByTransactionId() {
		long id = 10;
		Transaction transaction = new Transaction();
		transaction.setTransactionId(id);
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setTransactionId(id);
		//doReturn(transaction).when(service).findByTransactionId(id);
		 doReturn(transaction).when(service).findByTransactionId(id);
	        when(util.toTransactionDetails(transaction)).thenReturn(transactionDetails);
	        TransactionDetails result =service.fetchAllByTransactionId(id);
	        assertEquals(transactionDetails,result);
	        verify(service).fetchAllByTransactionId(id);
	        verify(util).toTransactionDetails(transaction);
//        doReturn(transaction).when(repository).findById(id);
//        when(util.toTransactionDetails(transaction)).thenReturn(transactionDetails);
//        TransactionDetails result =service.fetchAllByTransactionId(id);
//        assertEquals(transactionDetails,result);
//        verify(service).fetchAllByTransactionId(id);
//        verify(util).toTransactionDetails(transaction);
	}
	
	@Test
	public void fetchAll() {

		List<Transaction> transaction = new ArrayList<>();
		when(repository.findAll()).thenReturn(transaction);
		List<TransactionDetails> transactionDetails = new ArrayList<>();
		when(util.toTransactionDetailsList(transaction)).thenReturn(transactionDetails);
		List<TransactionDetails> result = service.fetchAll();
		assertEquals(transactionDetails,result);
	}
	
	@Test
	public void findAllTransactionsInPeriod() {
		DateConverter dateConverter = new DateConverter();
		LocalDate startDate = LocalDate.of(2021, 07, 20);
		String startdateText = dateConverter.toText(startDate);
		LocalDate endDate = LocalDate.of(2021, 07, 20);
		String enddateText = dateConverter.toText(endDate);
		when(converter.toDate(startdateText)).thenReturn(startDate);
		when(converter.toDate(enddateText)).thenReturn(endDate);
		List<Transaction> transaction = new ArrayList<>();
		when(repository.findAllTransactionsInPeriod(startDate, endDate)).thenReturn(transaction);
		List<TransactionDetails> transactionDetails = new ArrayList<>();
		when(util.toTransactionDetailsList(transaction)).thenReturn(transactionDetails);
		List<TransactionDetails> result = service.findAllTransactionsInPeriod(startdateText, enddateText);
		assertEquals(transactionDetails,result);
		verify(repository).findAllTransactionsInPeriod(startDate, endDate);
		verify(util).toTransactionDetailsList(transaction);
	}

	@Test
	public void fetchAllByUserId() {
		long userId=1l;
		List<Transaction> transaction = new ArrayList<>();
		when(repository.findByUserId(userId)).thenReturn(transaction);
		List<TransactionDetails> transactionDetails = new ArrayList<>();
		when(util.toTransactionDetailsList(transaction)).thenReturn(transactionDetails);
		List<TransactionDetails> result = service.fetchAllByUserId(userId);
		assertEquals(transactionDetails,result);
	}

	@Test
	public void fetchAllTransactionByUserId()
	{
		long userId =1l;
		DateConverter dateConverter = new DateConverter();
		LocalDate startDate = LocalDate.of(2021, 07, 20);
		String startdateText = dateConverter.toText(startDate);
		LocalDate endDate = LocalDate.of(2021, 07, 20);
		String enddateText = dateConverter.toText(endDate);
		when(converter.toDate(startdateText)).thenReturn(startDate);
		when(converter.toDate(enddateText)).thenReturn(endDate);
		List<Transaction> transaction = new ArrayList<>();
		when(repository.findByUserIdInPeriod(userId, startDate, endDate)).thenReturn(transaction);
		List<TransactionDetails> transactionDetails = new ArrayList<>();
		when(util.toTransactionDetailsList(transaction)).thenReturn(transactionDetails);
		List<TransactionDetails> result = service.findByUserIdInPeriod(userId, startdateText, enddateText);
		assertEquals(transactionDetails,result);
		verify(repository).findByUserIdInPeriod(userId, startDate, endDate);
		verify(util).toTransactionDetailsList(transaction);
		
	}

}
