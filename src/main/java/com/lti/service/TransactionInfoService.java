package com.lti.service;

import java.util.List;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.GetTransactionDTO;
import com.lti.dto.OTP;
import com.lti.dto.TransactionDTO;
import com.lti.dto.TransactionResponseDTO;

public interface TransactionInfoService {
	
	public OTP addBeneficiary(BeneficiaryDTO beneficiaryDTO);
	public int addTransaction(TransactionDTO transactionDTO);
	public TransactionResponseDTO checkTransaction(TransactionDTO transactionDTO);
	public void addSavedPayment(TransactionDTO transactionDTO);
	public List<TransactionDTO> getAllSavedPayments(String accountNumber);
	public void deleteSavedPayment(TransactionDTO transactionDTO);
	public List<TransactionDTO> getTransactions(String accountNumber);
	public List<TransactionDTO> getAllTransactionsByDate(GetTransactionDTO getTransactionDTO);
	public List<BeneficiaryDTO> getAllBeneficiaries(String accountNumber);
	

}
