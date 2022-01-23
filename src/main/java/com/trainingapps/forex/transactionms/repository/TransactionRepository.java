package com.trainingapps.forex.transactionms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trainingapps.forex.transactionms.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findByUserId(Long userId);
	Transaction findTransactionByTransactionId(Long transactionId);
	
	@Query("from Transaction where userId= :userId and transactionDate between :startDate and :endDate " )
	List<Transaction> findByUserIdInPeriod(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	
	@Query("from Transaction where transactionDate between :startDate and :endDate " )
	List<Transaction> findAllTransactionsInPeriod(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
}


