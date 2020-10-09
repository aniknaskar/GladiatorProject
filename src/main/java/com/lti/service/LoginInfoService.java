package com.lti.service;

import com.lti.dto.ChangeLoginPasswordDTO;
import com.lti.dto.InternetBankingRegistrationDTO;
import com.lti.dto.LoginDTO;
import com.lti.dto.OTP;
import com.lti.dto.OTPVerficationDTO;

public interface LoginInfoService {

	public LoginDTO getLoginInfo(String internetBankingId);
	public OTP addLoginInfo(InternetBankingRegistrationDTO internetBankingRegistrationDTO);
	public void unlockLoginInfo(String internetBankingId);
	public void updateLoginPassword(ChangeLoginPasswordDTO changeLoginPasswordDTO);
	public String forgotLoginPassword(String internetBankingId);
	public String forgotInternetBankingId(String accountNumber);
	public void sendInternetBankingId(String accountNumber);
	public void lockAccount(String accountNumber);
	public void addNumberOfAttemptedLogin(String accountNumber);
	
}
