package com.lti.dao;

import java.util.List;

import com.lti.model.SavedPaymentsInfo;

public interface SavedPaymentsInfoDao
{
	public void createSavedPayment(SavedPaymentsInfo savedPayment);
	public List<SavedPaymentsInfo> readAllSavedPaymentsByAccountNumber(String accountNumber);
	public int deleteSavedPayment(int serialNumber);
}
