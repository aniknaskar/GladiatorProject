package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.AccountInfo;


@Repository
public class AccountInfoDaoImpl implements AccountInfoDao {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public AccountInfoDaoImpl() {
		
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createAccountInfo(AccountInfo accountInfo) {
		entityManager.persist(accountInfo);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public AccountInfo readAccountInfo(String accountNumber) {
		AccountInfo accountInfo=entityManager.find(AccountInfo.class, accountNumber);
		return accountInfo;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateAccountInfo(AccountInfo accountInfo) {
		entityManager.merge(accountInfo);
		
	}
	
	

}
