package com.lti.dto;

import java.util.Date;

public class GetTransactionDTO {
	
	private String accountNumber;
	private Date fromDate;
	private Date toDate;
	
	
	public GetTransactionDTO(String accountNumber, Date fromDate, Date toDate) {
		super();
		this.accountNumber = accountNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}


	public GetTransactionDTO() {
		super();
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	@Override
	public String toString() {
		return "GetTransactionDTO [accountNumber=" + accountNumber + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}
	
	

}
