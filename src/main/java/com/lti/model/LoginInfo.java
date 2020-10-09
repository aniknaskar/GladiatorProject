package com.lti.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "LOGIN_INFO")
public class LoginInfo implements Serializable
{
	
	@Id
	@Column(name = "INTERNET_BANKING_ID",length = 20,nullable = false)
	private String internetBankingId;
	
	@Column(name = "LOGIN_PASSWORD",length = 30,nullable = false)
	private String loginPassword;
	
	@Column(name = "EMAIL_ID",length = 50,nullable = false)
	private String emailId;
	
	@Column(name = "MOBILE_NUMBER",length = 20,nullable = false)
	private String mobileNumber;
	
	@Column(name = "LAST_LOGIN",nullable = false)
	private Date lastLogin;
	
	@Column(name = "LOCKED",nullable = false)
	private boolean locked;
	
	@Column(name = "NUMBER_OF_ATTEMPTED_LOGIN")
	private int numberOfAttemptedLogin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private AccountInfo accountInfo;
	
	@OneToOne(mappedBy = "loginPassword")
	private RecoveryInfo recoveryLoginPassword;
	
	@OneToOne(mappedBy = "internetBankingId")
	private RecoveryInfo recoveryInternetBankingId;
	
	
	public LoginInfo() {
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getNumberOfAttemptedLogin() {
		return numberOfAttemptedLogin;
	}

	public void setNumberOfAttemptedLogin(int numberOfAttemptedLogin) {
		this.numberOfAttemptedLogin = numberOfAttemptedLogin;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "LoginInfo [internetBankingId=" + internetBankingId + ", loginPassword=" + loginPassword + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", lastLogin=" + lastLogin + ", locked=" + locked
				+ ", numberOfAttemptedLogin=" + numberOfAttemptedLogin + "]";
	}

	public RecoveryInfo getRecoveryInternetBankingId() {
		return recoveryInternetBankingId;
	}

	public void setRecoveryInternetBankingId(RecoveryInfo recoveryInternetBankingId) {
		this.recoveryInternetBankingId = recoveryInternetBankingId;
	}

	public RecoveryInfo getRecoveryLoginPassword() {
		return recoveryLoginPassword;
	}

	public void setRecoveryLoginPassword(RecoveryInfo recoveryLoginPassword) {
		this.recoveryLoginPassword = recoveryLoginPassword;
	}

	
	
}
