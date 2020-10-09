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
@SequenceGenerator(name="seq",sequenceName = "savedpayment_seq",initialValue = 1,allocationSize = 1)
@Table(name = "SAVED_PAYMENTS")
public class SavedPaymentsInfo {
	
	
	@Column(name = "TO_ACCOUNT_NUMBER",length = 20,nullable = false)
	private String toAccountNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private AccountInfo fromAccountNumber;
	
	@Id
	@GeneratedValue( generator = "seq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "SERIAL_NUMBER",length = 10,nullable = false)
	private int serialNumber;
	
	@Column(name = "MODE_OF_PAYMENT",length = 20,nullable = false)
	private String modeOfPayment;
	
	@Column(name = "TRANSACTION_DATE",nullable = false)
	private Date transactionDate;
	
	@Column(name = "TRANSACTION_AMOUNT",length = 10,nullable = false)
	private double transactionAmount;
	
	@Column(name = "REMARKS",length = 50,nullable = true)
	private String remarks;

	public SavedPaymentsInfo() {
		super();
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public AccountInfo getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(AccountInfo fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "SavedPayments [toAccountNumber=" + toAccountNumber + ", serialNumber=" + serialNumber
				+ ", modeOfPayment=" + modeOfPayment + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", remarks=" + remarks + "]";
	}
	
	
	
	
	

}
