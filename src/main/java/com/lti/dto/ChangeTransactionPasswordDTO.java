package com.lti.dto;

public class ChangeTransactionPasswordDTO {

	private String accountNumber;
	
	private String transactionPassword;

	public ChangeTransactionPasswordDTO() {
		super();
	}

	public ChangeTransactionPasswordDTO(String accountNumber, String transactionPassword) {
		super();
		this.accountNumber = accountNumber;
		this.transactionPassword = transactionPassword;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	@Override
	public String toString() {
		return "ChangeTransactionPasswordDTO [accountNumber=" + accountNumber + ", transactionPassword="
				+ transactionPassword + "]";
	}
	
	
	
	
	
}
