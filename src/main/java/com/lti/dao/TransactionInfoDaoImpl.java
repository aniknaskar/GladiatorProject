package com.lti.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.TransactionInfo;



@Repository
public class TransactionInfoDaoImpl implements TransactionInfoDao {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public TransactionInfoDaoImpl() {
		
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<TransactionInfo> readAllTransactionsByAccountNumber(String accountNumber) {
		String jpql="Select t from TransactionInfo t where t.accountInfo.accountNumber=:accountNumber";
		TypedQuery<TransactionInfo> tQuery=entityManager.createQuery(jpql, TransactionInfo.class);
		tQuery.setParameter("accountNumber", accountNumber);
		List<TransactionInfo> transactionInfos=tQuery.getResultList();
		return transactionInfos;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<TransactionInfo> readTransactionsBetweenDate(String accountNumber, Date startDate, Date endDate) {
		String jpql="Select t from TransactionInfo t where (t.accountInfo.accountNumber=:accountNumber) and (t.transactionDate between :startDate and :endDate)";

		TypedQuery<TransactionInfo> tQuery=entityManager.createQuery(jpql, TransactionInfo.class);
		
		tQuery.setParameter("startDate",startDate);
		tQuery.setParameter("endDate", endDate);
		tQuery.setParameter("accountNumber", accountNumber);
		List<TransactionInfo> transactionInfos=tQuery.getResultList();
		return transactionInfos;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createTransaction(TransactionInfo transactionInfo) {
		entityManager.persist(transactionInfo);
		
	}

}
