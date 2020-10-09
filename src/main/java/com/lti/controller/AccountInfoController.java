package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ChangeTransactionPasswordDTO;
import com.lti.service.AccountInfoService;

@RestController
@RequestMapping(path = "accountinfo")
@CrossOrigin
public class AccountInfoController 
{
	@Autowired
	private AccountInfoService accountInfoService;
	
	
	//http://localhost:9091/Digiseva/accountinfo/getaccountbalance
	@PostMapping(path="/getaccountbalance")
	public double getAccountBalance(@RequestBody String accountNumber)
	{
		return accountInfoService.getAccountBalance(accountNumber);
	}
	
	//http://localhost:9091/Digiseva/accountinfo/changetransactionpassword
	@PostMapping(path = "/changetransactionpassword")
	public void changeTransactionPassword(@RequestBody ChangeTransactionPasswordDTO changeTransactionPasswordDTO)
	{
		accountInfoService.updateTransactionPassword(changeTransactionPasswordDTO);
	}
	
	
}
