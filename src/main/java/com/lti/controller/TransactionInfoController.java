package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.GetTransactionDTO;
import com.lti.dto.OTP;
import com.lti.dto.TransactionDTO;
import com.lti.dto.TransactionResponseDTO;
import com.lti.service.TransactionInfoService;

@RestController
@RequestMapping(path = "transaction")
@CrossOrigin
public class TransactionInfoController {
	
	@Autowired
	private TransactionInfoService transactionInfoService;
	
	
	//http://localhost:9091/Digiseva/transaction/addbeneficiary
	@PostMapping(path = "/addbeneficiary")
	public OTP addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO)
	{
		return transactionInfoService.addBeneficiary(beneficiaryDTO);
	}
	
	//http://localhost:9091/Digiseva/transaction/addtransaction
	@PostMapping(path = "/addtransaction")
	public int addTransaction(@RequestBody TransactionDTO transactionDTO)
	{
		return transactionInfoService.addTransaction(transactionDTO);
	}
	
	//http://localhost:9091/Digiseva/transaction/checktransaction
	@PostMapping(path = "/checktransaction")
	public TransactionResponseDTO checkTransaction(@RequestBody TransactionDTO transactionDTO)
	{
		return transactionInfoService.checkTransaction(transactionDTO);
	}
	
	//http://localhost:9091/Digiseva/transaction/addsavedpayment
	@PostMapping(path = "/addsavedpayment")
	public void addSavedPayment(@RequestBody TransactionDTO transactionDTO)
	{
		transactionInfoService.addSavedPayment(transactionDTO);
	}
	
	
	//http://localhost:9091/Digiseva/transaction/getallsavedpayments
	@PostMapping(path = "/getallsavedpayments")
	public List<TransactionDTO> getAllSavedPayments(@RequestBody String accountNumber)
	{
		return transactionInfoService.getAllSavedPayments(accountNumber);// To be fixed
	}
	
	//http://localhost:9091/Digiseva/transaction/getalltransactions
	@PostMapping(path = "/getalltransactions")
	public List<TransactionDTO> getAllTransaction(@RequestBody String accountNumber)
	{
		return transactionInfoService.getTransactions(accountNumber);
	}
	
	//http://localhost:9091/Digiseva/transaction/getalltransactionswithdate
	@PostMapping(path = "/getalltransactionswithdate")
	public List<TransactionDTO> getAllTransactionsWithDate(@RequestBody GetTransactionDTO getTransactionDTO)
	{
		return transactionInfoService.getAllTransactionsByDate(getTransactionDTO);
	}
	
	//http://localhost:9091/Digiseva/transaction/getallbeneficiaries
	@PostMapping(path = "/getallbeneficiaries")
	public List<BeneficiaryDTO> getAllBeneficiaries(@RequestBody String accountNumber)
	{
		return transactionInfoService.getAllBeneficiaries(accountNumber);
	}
	
	//http://localhost:9091/Digiseva/transaction/deletesavedpayment
	@PostMapping(path = "/deletesavedpayment")
	public void deleteSavedPayment(@RequestBody TransactionDTO transactionDTO)
	{
		transactionInfoService.deleteSavedPayment(transactionDTO);
	}

}
