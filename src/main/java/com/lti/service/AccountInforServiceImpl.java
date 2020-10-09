package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AccountInfoDao;
import com.lti.dto.ChangeTransactionPasswordDTO;
import com.lti.model.AccountInfo;

@Service
public class AccountInforServiceImpl implements AccountInfoService
{
	@Autowired
	private AccountInfoDao accountInfoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public double getAccountBalance(String accountNumber)
	{
		AccountInfo accountInfo=accountInfoDao.readAccountInfo(accountNumber);
		return accountInfo.getAccountBalance();
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTransactionPassword(ChangeTransactionPasswordDTO changeTransactionPasswordDTO)
	{
		AccountInfo accountInfo=accountInfoDao.readAccountInfo(changeTransactionPasswordDTO.getAccountNumber());
		accountInfo.setTransactionPassword(changeTransactionPasswordDTO.getTransactionPassword());
		accountInfoDao.updateAccountInfo(accountInfo);
		
	}
	
}
