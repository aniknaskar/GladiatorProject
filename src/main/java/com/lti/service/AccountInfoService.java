package com.lti.service;

import com.lti.dto.ChangeTransactionPasswordDTO;

public interface AccountInfoService {

	
	public double getAccountBalance(String accountNumber);
	public void updateTransactionPassword(ChangeTransactionPasswordDTO changeTransactionPasswordDTO);

}
