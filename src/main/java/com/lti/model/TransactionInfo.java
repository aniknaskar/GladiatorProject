package com.lti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "TRANSACTION_INFO")
public class TransactionInfo {
	
	@Id
	@Column(name = "TRANSACTION_ID",length = 20,nullable = false)
	private int transactionId;
	
	
	@Column(name = "TRANSACTION_DATE",nullable = false)
	private Date transactionDate;
	
	@Column(name = "MODE_OF_TRANSACTION",length = 30,nullable = false)
	private String modeOfTransaction;
	
	@Column(name = "DEBIT",length = 10,nullable = true)
	private double debit;
	
	@Column(name = "CREDIT",length = 10,nullable = true)
	private double credit;
	
	@Column(name = "PARTICULAR",length = 100,nullable = false)
	private String particular;
	
	@Column(name = "BALANCE",length = 10,nullable = false)
	private double balance;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private AccountInfo accountInfo;

	public TransactionInfo() {
		super();
	}

	@Override
	public String toString() {
		return "TransactionInfo [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", modeOfTransaction=" + modeOfTransaction + ", debit="
				+ debit + ", credit=" + credit + ", particular=" + particular + ", balance=" + balance + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	

}
