package com.lti.dao;

import com.lti.model.AccountInfo;

public interface AccountInfoDao {

	public void createAccountInfo(AccountInfo accountInfo);
	public AccountInfo readAccountInfo(String accountNumber);
	public void updateAccountInfo(AccountInfo accountInfo);
}
