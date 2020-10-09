package com.lti.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class LoginDTO {

	private String internetBankingId;
	private String loginPassword;
	private String accountNumber;
	private String customerName;
	private String accountBalance;
	private String transactionPassword;
	private int numberOfAttemptedLogin;
	private int isLocked;
	
	
	
	
	public LoginDTO(String internetBankingId, String loginPassword, String accountNumber, String customerName,
			String accountBalance, String transactionPassword, int numberOfAttemptedLogin, int isLocked) {
		super();
		this.internetBankingId = internetBankingId;
		this.loginPassword = loginPassword;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
		this.transactionPassword = transactionPassword;
		this.numberOfAttemptedLogin = numberOfAttemptedLogin;
		this.isLocked = isLocked;
	}
	public LoginDTO() {
		super();
	}
	public String getInternetBankingId() {
		return internetBankingId;
	}
	public void setInternetBankingId(String internetBankingId) {
		this.internetBankingId = internetBankingId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public int getNumberOfAttemptedLogin() {
		return numberOfAttemptedLogin;
	}
	public void setNumberOfAttemptedLogin(int numberOfAttemptedLogin) {
		this.numberOfAttemptedLogin = numberOfAttemptedLogin;
	}
	public int getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}
	@Override
	public String toString() {
		return "LoginDTO [internetBankingId=" + internetBankingId + ", loginPassword=" + loginPassword
				+ ", accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountBalance="
				+ accountBalance + ", transactionPassword=" + transactionPassword + ", numberOfAttemptedLogin="
				+ numberOfAttemptedLogin + ", isLocked=" + isLocked + "]";
	}
	
	
}
