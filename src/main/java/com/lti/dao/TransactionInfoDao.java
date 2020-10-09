package com.lti.dao;

import java.util.Date;
import java.util.List;

import com.lti.model.TransactionInfo;

public interface TransactionInfoDao {

	public List<TransactionInfo> readAllTransactionsByAccountNumber(String accountNumber);
	public List<TransactionInfo> readTransactionsBetweenDate(String accountNumber,Date startDate,Date endDate );
	public void createTransaction(TransactionInfo transactionInfo);
}
