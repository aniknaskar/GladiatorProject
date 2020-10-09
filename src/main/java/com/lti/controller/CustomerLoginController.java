package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ChangeLoginPasswordDTO;
import com.lti.dto.InternetBankingRegistrationDTO;
import com.lti.dto.LoginDTO;
import com.lti.dto.OTP;
import com.lti.dto.OTPVerficationDTO;
import com.lti.model.LoginInfo;
import com.lti.service.LoginInfoService;

@RestController
@RequestMapping(path = "customerlogin")
@CrossOrigin
public class CustomerLoginController {

	@Autowired
	private LoginInfoService loginInfoService;
	
	//http://localhost:9091/Digiseva/customerlogin/getlogin
	@PostMapping(path = "/getlogin")
	public LoginDTO getLogin(@RequestBody String internetBankingId)
	{
		LoginDTO loginDTO= loginInfoService.getLoginInfo(internetBankingId);
		return loginDTO;
	}
	
	
	//http://localhost:9091/Digiseva/customerlogin/createlogin
	@PostMapping(path="/createlogin")
	public OTP createLoginInfo(@RequestBody InternetBankingRegistrationDTO internetBankingRegistrationDTO)
	{
		return loginInfoService.addLoginInfo(internetBankingRegistrationDTO);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/unlockaccount
	@PostMapping(path = "/unlockaccount")
	public void unlockAccount(@RequestBody String internetBankingId)
	{
		loginInfoService.unlockLoginInfo(internetBankingId);
	}
	
	
	//http://localhost:9091/Digiseva/customerlogin/changeloginpassword
	@PostMapping(path = "/changeloginpassword")
	public void changeLoginPassword(@RequestBody ChangeLoginPasswordDTO changeLoginPasswordDTO)
	{
		loginInfoService.updateLoginPassword(changeLoginPasswordDTO);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/forgotpassword
	@PostMapping(path = "/forgotpassword")
	public String forgotLoginPassword(@RequestBody String internetBankingId)
	{
		return loginInfoService.forgotLoginPassword(internetBankingId);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/forgotid
	@PostMapping(path = "/forgotid")
	public String forgotInternetBankingId(@RequestBody String accountNumber)
	{
		return loginInfoService.forgotInternetBankingId(accountNumber);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/sendid
	@PostMapping(path = "/sendid")
	public void sendInternetBankingId(@RequestBody String accountNumber)
	{
		loginInfoService.sendInternetBankingId(accountNumber);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/lockaccount
	@PostMapping(path = "/lockaccount")
	public void lockAccount(@RequestBody String internetBankingId)
	{
		loginInfoService.lockAccount(internetBankingId);
	}
	
	//http://localhost:9091/Digiseva/customerlogin/addnumberoflogin
	@PostMapping(path = "/addnumberoflogin")
	public void addNumberOfLogin(@RequestBody String internetBankingId)
	{
		loginInfoService.addNumberOfAttemptedLogin(internetBankingId);
	}
	
	
	
	
}
