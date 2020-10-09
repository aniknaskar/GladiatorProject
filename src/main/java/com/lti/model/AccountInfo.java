package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "ACCOUNT_INFO_TBL")
public class AccountInfo implements Serializable {
	
	
	@Column(name = "CUSTOMER_NAME",length = 50,nullable = false)
	private String customerName;
	
	@Column(name = "ACCOUNT_TYPE",length = 10,nullable = false)
	private String accountType;
	
	@Column(name = "ACCOUNT_BALANCE",length = 15,nullable = false)
	private double accountBalance;
	
	@Id
	@Column(name = "ACCOUNT_NUMBER",length = 20,nullable = false)
	private String accountNumber;
	
	
	@Column(name = "TRANSACTION_PASSWORD",length = 25,nullable = true)
	private String transactionPassword;
	
	//Foreign key-Owner
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private CustomerInfo customerDetails;
	
	//Inverse
	@OneToOne(mappedBy = "accountInfo")
	private LoginInfo loginInfo;
	
	@OneToOne(mappedBy = "accountNumber")
	private RecoveryInfo recoveryAccountNumber;
	
	@OneToOne(mappedBy = "accountBalance")
	private RecoveryInfo recoveryAccountBalance;
	
	@OneToOne(mappedBy = "transactionPassword")
	private RecoveryInfo recoveryTransactionPassword;
	
	
	@OneToMany(mappedBy = "accountInfo",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<TransactionInfo> transactionInfos;
	
	
	@OneToMany(mappedBy = "accountNumber",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<BeneficiaryInfo> beneficiaries;
	
	
	@OneToMany(mappedBy = "fromAccountNumber",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<SavedPaymentsInfo> savedPayments;
	
	public AccountInfo() {
		super();
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public double getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	



	public String getTransactionPassword() {
		return transactionPassword;
	}



	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}



	public CustomerInfo getCustomerDetails() {
		return customerDetails;
	}



	public void setCustomerDetails(CustomerInfo customerDetails) {
		this.customerDetails = customerDetails;
	}




	@Override
	public String toString() {
		return "AccountInfo [customerName=" + customerName + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", accountNumber=" + getAccountNumber() + ", transactionPassword=" + transactionPassword
				+ ", customerDetails=" + customerDetails + ", loginInfo=" + loginInfo + ", transactionInfos="
				+ transactionInfos + "]";
	}



	public LoginInfo getLoginInfo() {
		return loginInfo;
	}



	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}



	public Set<TransactionInfo> getTransactionInfos() {
		return transactionInfos;
	}



	public void setTransactionInfos(Set<TransactionInfo> transactionInfos) {
		this.transactionInfos = transactionInfos;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public RecoveryInfo getRecoveryTransactionPassword() {
		return recoveryTransactionPassword;
	}



	public void setRecoveryTransactionPassword(RecoveryInfo recoveryTransactionPassword) {
		this.recoveryTransactionPassword = recoveryTransactionPassword;
	}



	public RecoveryInfo getRecoveryAccountBalance() {
		return recoveryAccountBalance;
	}



	public void setRecoveryAccountBalance(RecoveryInfo recoveryAccountBalance) {
		this.recoveryAccountBalance = recoveryAccountBalance;
	}



	public RecoveryInfo getRecoveryAccountNumber() {
		return recoveryAccountNumber;
	}



	public void setRecoveryAccountNumber(RecoveryInfo recoveryAccountNumber) {
		this.recoveryAccountNumber = recoveryAccountNumber;
	}
	
	
	
	

}
