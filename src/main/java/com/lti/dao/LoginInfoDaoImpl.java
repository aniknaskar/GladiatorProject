package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.AccountInfo;
import com.lti.model.CustomerInfo;
import com.lti.model.LoginInfo;


@Repository
public class LoginInfoDaoImpl implements LoginInfoDao  {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public LoginInfoDaoImpl() {
		
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public LoginInfo readLoginInfo(String internetBankingId) {
		LoginInfo loginInfo=entityManager.find(LoginInfo.class, internetBankingId);
		return loginInfo;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateLoginPassword(String newLoginPassword,String internetBankingId) {
		LoginInfo loginInfo=entityManager.find(LoginInfo.class, internetBankingId);
		loginInfo.setLoginPassword(newLoginPassword);
		entityManager.merge(loginInfo);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createInternetBanking(LoginInfo loginInfo)
	{
		entityManager.persist(loginInfo);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateLogininfo(LoginInfo loginInfo) {
		entityManager.merge(loginInfo);
		
	}

	
	

	
}
