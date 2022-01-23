package com.trainingapps.forex.transactionms.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.trainingapps.forex.transactionms.dto.TransactionDetails;
import com.trainingapps.forex.transactionms.dto.TransactionRequest;
import com.trainingapps.forex.transactionms.entity.Transaction;
import com.trainingapps.forex.transactionms.exceptions.TransactionIdNotFoundException;
import com.trainingapps.forex.transactionms.repository.TransactionRepository;
import com.trainingapps.forex.transactionms.util.DateConverter;
import com.trainingapps.forex.transactionms.util.Utility;
//import com.trainingapps.forex.transactionms.vo.ResponseTemplateVO;
//import com.trainingapps.forex.transactionms.vo.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private DateConverter dateConverter;

	@Override
	public TransactionDetails createTransaction(TransactionRequest request) {
		validateDate(request);
		Transaction transaction = new Transaction();
		transaction.setUserId(request.getUserId());
		transaction.setTransactionDate(dateConverter.toDate(request.getTransactionDate()));
		transaction.setRecipientName(request.getRecipientName());
		transaction.setRecipientAccountNo(request.getRecipientAccountNo());
		transaction.setRecipientEmail(request.getRecipientEmail());
		transaction.setRecipientAddress(request.getRecipientAddress());
		transaction.setRecipientCountry(request.getRecipientCountry());
		transaction.setRecipientState(request.getRecipientState());
		transaction.setRecipientCity(request.getRecipientCity());
		transaction.setRecipientPincode(request.getRecipientPincode());
		transaction.setAmountTransferred(request.getAmountTransferred());
		transaction.setCurrencyExchangeFrom(utility.toCurrencyEnum(request.getCurrencyExchangeFrom()));
		transaction.setCurrencyExchangeTo(utility.toCurrencyEnum(request.getCurrencyExchangeTo()));
		transaction.setTransactionStatus(utility.toTransactionStatusEnum(request.getTransactionStatus()));
		transaction = transactionRepository.save(transaction);
		return utility.toTransactionDetails(transaction);
		
	
	}

	@Override
	public List<TransactionDetails> fetchAll() {
		
		List<Transaction> transactions = transactionRepository.findAll();
		return utility.toTransactionDetailsList(transactions);
	}

	@Override
	public List<TransactionDetails> fetchAllByUserId(Long userId) {
		
		List<Transaction> transactions = transactionRepository.findByUserId(userId);
		return utility.toTransactionDetailsList(transactions);
	}

	public Transaction findByTransactionId(Long transactionId) {
		Optional<Transaction> optional = transactionRepository.findById(transactionId);
		if (!optional.isPresent()) {
			throw new TransactionIdNotFoundException("Transaction Not Found for id= " + transactionId);
		}
		return optional.get();
	}
	
	@Override
	public TransactionDetails fetchAllByTransactionId(Long transactionId) {
		
		Transaction transaction = findByTransactionId(transactionId);
		
		return utility.toTransactionDetails(transaction);
	}

	@Override
	public List<TransactionDetails> findAllTransactionsInPeriod(String startDateText, String endDateText) {
		LocalDate startDate = dateConverter.toDate(startDateText);
		LocalDate endDate = dateConverter.toDate(endDateText);
		//System.out.println(startDate + " / " + endDate);
		List<Transaction> transactions = transactionRepository.findAllTransactionsInPeriod(startDate, endDate);
		return utility.toTransactionDetailsList(transactions);
	}

	@Override
	public List<TransactionDetails> findByUserIdInPeriod(Long userId, String startDateText, String endDateText) {
		LocalDate startDate = dateConverter.toDate(startDateText);
		LocalDate endDate = dateConverter.toDate(endDateText);
		List<Transaction> transactions = transactionRepository.findByUserIdInPeriod(userId, startDate, endDate);
		return utility.toTransactionDetailsList(transactions);
	}
	
	public Page<Transaction> findTransactionssWithPagination(int offset,int pageSize){
        Page<Transaction> transactions = transactionRepository.findAll(PageRequest.of(offset, pageSize));
        return  transactions;
    }
	
	public Page<Transaction> findTransactionssWithPaginationAndSorting(int offset,int pageSize, String field){
        Page<Transaction> transactions = transactionRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  transactions;
    }
	
	public boolean validateDate(TransactionRequest request) {
		try {
			dateConverter.toDate(request.getTransactionDate());
		} catch (RuntimeException e) {
			throw new DateTimeException("Please enter date in yyyy-MM-dd format");
		}
		return true;
	}

	
	
	
	public String exportReport(String reportFormat, Long userId) {
		//String path = "C:\\Users\\user\\Desktop\\Report";
		String path = "D:\\";
		List<TransactionDetails> transactions = fetchAllByUserId(userId);
		// load file and compile it
		File file;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		LocalDateTime date = LocalDateTime.now();
		String now = dtf.format(date);
		try {
			file = ResourceUtils.getFile("classpath:transaction.jrxml");

			JasperReport jasperReport;

			jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactions);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("createdBy", "Cash Catch");
			JasperPrint jasperPrint;

			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			if (reportFormat.equalsIgnoreCase("html")) {
				try {
					JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\transactions_"+now+".html");
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (reportFormat.equalsIgnoreCase("pdf")) {
				try {
					JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\transactions_"+now+".pdf");
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "report generated in path : " + path;
	}
	
	@Override
	public Set<Long> findTransactionIds(String startDate, String endDate) {
		LocalDate start = dateConverter.toDate(startDate);
		LocalDate end = dateConverter.toDate(endDate);
		List<TransactionDetails> transactionList = utility.toTransactionDetailsList(transactionRepository.findAllTransactionsInPeriod(start, end));
		return transactionList.stream().map(transaction -> transaction.getTransactionId()).collect(Collectors.toSet());

	}
	
//	@Override
//	public ResponseTemplateVO fetchUserWithTransaction(Long userId) {
//		
//		ResponseTemplateVO responseTemplateVO= new ResponseTemplateVO(); 
//		
//		User user = new User();
//		user.setUserId(1l);
//		user.setFirstName("Mohan");
//		user.setLastName("R");
//		user.setAddress("No:633/24, Main Street");
//		user.setCountry("India");
//		user.setCity("Chennai");
//		user.setMobileNumber("9840984696");
//		user.setState("TN");
//		
//		List<Transaction> transactions = transactionRepository.findByUserId(userId);
//		List<TransactionDetails> transactionDetails = utility.toTransactionDetailsList(transactions);
//		
//		responseTemplateVO.setUser(user);
//		responseTemplateVO.setTransactionDetails(transactionDetails);
//		
//		return responseTemplateVO;
//	}


}
