package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "RECOVERY")
public class RecoveryInfo implements Serializable {

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="LOGIN_PASSWORD")
	private LoginInfo loginPassword;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="INTERNET_BANKING_ID")
	private LoginInfo internetBankingId;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private AccountInfo accountNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_BALANCE")
	private AccountInfo accountBalance;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TRANSACTION_PASSWORD")
	private AccountInfo transactionPassword;

	public RecoveryInfo() {
		super();
	}

	public LoginInfo getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(LoginInfo loginPassword) {
		this.loginPassword = loginPassword;
	}

	public LoginInfo getInternetBankingId() {
		return internetBankingId;
	}

	public void setInternetBankingId(LoginInfo internetBankingId) {
		this.internetBankingId = internetBankingId;
	}

	public AccountInfo getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(AccountInfo accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountInfo getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(AccountInfo accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountInfo getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(AccountInfo transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	@Override
	public String toString() {
		return "Recovery [loginPassword=" + loginPassword + ", internetBankingId=" + internetBankingId
				+ ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", transactionPassword="
				+ transactionPassword + "]";
	}
	
	
	
	
}
