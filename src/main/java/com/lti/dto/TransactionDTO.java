package com.lti.dto;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class TransactionDTO {

	private String modeOfTransaction;
	private String amount;
	private String customerAccountNumber;
	private String beneficiaryAccountNumber;
	private Date dateOfPayment;
	private String debitOrCredit;
	private int serialNumber;
	
	
	public TransactionDTO(String modeOfTransaction, String amount, String customerAccountNumber,
			String beneficiaryAccountNumber, Date dateOfPayment) {
		super();
		this.modeOfTransaction = modeOfTransaction;
		this.amount = amount;
		this.customerAccountNumber = customerAccountNumber;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.dateOfPayment = dateOfPayment;
	}


	public String getModeOfTransaction() {
		return modeOfTransaction;
	}


	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}


	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}


	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}


	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}


	public Date getDateOfPayment() {
		return dateOfPayment;
	}


	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}


	public TransactionDTO() {
		super();
	}


	@Override
	public String toString() {
		return "TransactionDTO [modeOfTransaction=" + modeOfTransaction + ", amount=" + amount
				+ ", customerAccountNumber=" + customerAccountNumber + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + ", dateOfPayment=" + dateOfPayment + "]";
	}


	public String getDebitOrCredit() {
		return debitOrCredit;
	}


	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}


	public int getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	
	
	
}
