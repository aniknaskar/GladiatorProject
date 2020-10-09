package com.lti.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class InternetBankingRegistrationDTO {

	private String accountNumber;
	private String loginPassword;
	private String confirmLoginPassword;
	private String transactionPassword;
	private String confirmTransactionPassword;
	
	
	public InternetBankingRegistrationDTO() {
		super();
	}


	public InternetBankingRegistrationDTO(String accountNumber, String loginPassword, String confirmLoginPassword,
			String transactionPassword, String confirmTransactionPassword) {
		super();
		this.accountNumber = accountNumber;
		this.loginPassword = loginPassword;
		this.confirmLoginPassword = confirmLoginPassword;
		this.transactionPassword = transactionPassword;
		this.confirmTransactionPassword = confirmTransactionPassword;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getConfirmLoginPassword() {
		return confirmLoginPassword;
	}


	public void setConfirmLoginPassword(String confirmLoginPassword) {
		this.confirmLoginPassword = confirmLoginPassword;
	}


	public String getTransactionPassword() {
		return transactionPassword;
	}


	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}


	public String getConfirmTransactionPassword() {
		return confirmTransactionPassword;
	}


	public void setConfirmTransactionPassword(String confirmTransactionPassword) {
		this.confirmTransactionPassword = confirmTransactionPassword;
	}


	@Override
	public String toString() {
		return "InternetBankingRegistrationDTO [accountNumber=" + accountNumber + ", loginPassword=" + loginPassword
				+ ", confirmLoginPassword=" + confirmLoginPassword + ", transactionPassword=" + transactionPassword
				+ ", confirmTransactionPassword=" + confirmTransactionPassword + "]";
	}
	
	
	
	
}
