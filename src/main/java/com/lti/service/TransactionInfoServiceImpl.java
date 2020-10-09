package com.lti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AccountInfoDao;
import com.lti.dao.BeneficiaryInfoDao;
import com.lti.dao.SavedPaymentsInfoDao;
import com.lti.dao.TransactionInfoDao;
import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.GetTransactionDTO;
import com.lti.dto.OTP;
import com.lti.dto.TransactionDTO;
import com.lti.dto.TransactionResponseDTO;
import com.lti.mail.AfterTransactionMail;
import com.lti.model.AccountInfo;
import com.lti.model.BeneficiaryInfo;
import com.lti.model.SavedPaymentsInfo;
import com.lti.model.TransactionInfo;

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {

	
	
	@Autowired
	private BeneficiaryInfoDao beneficiaryInfoDao;
	
	@Autowired
	private AccountInfo accountInfo;
	
	@Autowired
	private AccountInfoDao accountInfoDao;
	
	@Autowired
	private TransactionInfoDao transactionInfoDao;
	
	@Autowired
	private SavedPaymentsInfoDao savedPaymentsInfoDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public OTP addBeneficiary(BeneficiaryDTO beneficiaryDTO)
	{
		OTP otp=new OTP();
		accountInfo=accountInfoDao.readAccountInfo(beneficiaryDTO.getCustomerAccountNumber());
		AccountInfo accountInfo1=new AccountInfo();
		accountInfo1=accountInfoDao.readAccountInfo(beneficiaryDTO.getBeneficiaryAccountNumber());
		if(accountInfo1!=null)
		{
		
		BeneficiaryInfo beneficiaryInfo=new BeneficiaryInfo();
		
		beneficiaryInfo.setAccountNumber(accountInfo);
		beneficiaryInfo.setBeneficiaryAccountName(beneficiaryDTO.getBeneficiaryName());
		beneficiaryInfo.setBeneficiaryAccountNumber(beneficiaryDTO.getBeneficiaryAccountNumber());
		beneficiaryInfo.setBeneficiaryNickName(beneficiaryDTO.getBeneficiaryNickName());
		
		beneficiaryInfoDao.createBeneficiary(beneficiaryInfo);
		otp.setOtp("OK");
		}
		else {
			otp.setOtp("NULL");
		}
		return otp;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addTransaction(TransactionDTO transactionDTO)
	{
		
		
		TransactionInfo transactionInfo1=new TransactionInfo();
		TransactionInfo transactionInfo2=new TransactionInfo();
		
		AccountInfo accountInfo1=accountInfoDao.readAccountInfo(transactionDTO.getCustomerAccountNumber());
		AccountInfo accountInfo2=accountInfoDao.readAccountInfo(transactionDTO.getBeneficiaryAccountNumber());
		
		int result=0;
		if(accountInfo1!=null&&accountInfo2!=null)
		{
		
			
				double balance1=accountInfo1.getAccountBalance()-Double.parseDouble(transactionDTO.getAmount());
				double balance2=accountInfo2.getAccountBalance()+Double.parseDouble(transactionDTO.getAmount());
				
				int transactionId1=(int)(Math.random()*100000000);
				int transactionId2=(int)(Math.random()*100000000);
				
				result=transactionId1;
				
				transactionInfo1.setTransactionId(transactionId1);
				transactionInfo2.setTransactionId(transactionId2);
				
				transactionInfo1.setAccountInfo(accountInfo1);
				transactionInfo2.setAccountInfo(accountInfo2);
				
				transactionInfo1.setDebit(Double.parseDouble(transactionDTO.getAmount()));
				transactionInfo2.setCredit(Double.parseDouble(transactionDTO.getAmount()));
				
				transactionInfo1.setBalance(balance1);
				transactionInfo2.setBalance(balance2);
				
				transactionInfo1.setModeOfTransaction(transactionDTO.getModeOfTransaction());
				transactionInfo2.setModeOfTransaction(transactionDTO.getModeOfTransaction());
				
				transactionInfo1.setParticular("Paid To "+accountInfo2.getCustomerName());
				transactionInfo2.setParticular("Received From "+accountInfo1.getCustomerName());
				
				transactionInfo1.setTransactionDate(new Date());
				transactionInfo2.setTransactionDate(new Date());
				
				transactionInfoDao.createTransaction(transactionInfo1);
				transactionInfoDao.createTransaction(transactionInfo2);
				
				accountInfo1.setAccountBalance(balance1);
				accountInfo2.setAccountBalance(balance2);
				
				accountInfoDao.updateAccountInfo(accountInfo1);
				accountInfoDao.updateAccountInfo(accountInfo2);
				
				String message1="Dear "+accountInfo1.getCustomerName()+",\nA sum of Rs. "+transactionDTO.getAmount()+
						" has been debited from your bank account for making a payment to "+accountInfo2.getCustomerName()
						+".\nPlease Contact us at gladiatorproject.onlinebanking@gmail.com if the payment was not done by you\n"
						+ "\n\n Thank you for choosing DigiSeva.\n Have a nice Day!";
				
				String message2="Dear "+accountInfo2.getCustomerName()+",\nA sum of Rs. "+transactionDTO.getAmount()+
						" has been credited into your bank account by "+accountInfo1.getCustomerName()
						+".\n\nFor any queries please Contact us at gladiatorproject.onlinebanking@gmail.com \n\nHave a nice Day!";
						
				
				try {
					AfterTransactionMail.sendEmail(accountInfo1.getCustomerDetails().getEmailId(), message1);
					AfterTransactionMail.sendEmail(accountInfo2.getCustomerDetails().getEmailId(), message2);
				} 
				
				catch (MessagingException e) 
				{
					
					e.printStackTrace();
				}
				
				
			}
		return result;
		}
			
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSavedPayment(TransactionDTO transactionDTO)
	{
		AccountInfo accountInfo=accountInfoDao.readAccountInfo(transactionDTO.getCustomerAccountNumber());
		SavedPaymentsInfo savedPaymentsInfo=new SavedPaymentsInfo();
		
		savedPaymentsInfo.setFromAccountNumber(accountInfo);
		savedPaymentsInfo.setModeOfPayment(transactionDTO.getModeOfTransaction());
		savedPaymentsInfo.setToAccountNumber(transactionDTO.getBeneficiaryAccountNumber());
		savedPaymentsInfo.setTransactionAmount(Double.parseDouble(transactionDTO.getAmount()));
		savedPaymentsInfo.setTransactionDate(transactionDTO.getDateOfPayment());
		
		savedPaymentsInfoDao.createSavedPayment(savedPaymentsInfo);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TransactionDTO> getAllSavedPayments(String accountNumber) {
		
		List<SavedPaymentsInfo> savedPaymentsInfo=savedPaymentsInfoDao.readAllSavedPaymentsByAccountNumber(accountNumber);
		
		List<TransactionDTO> transactionDTOs=new ArrayList<>();
		for(SavedPaymentsInfo save:savedPaymentsInfo )
		{
			TransactionDTO transactionDTO=new TransactionDTO();
			transactionDTO.setAmount(""+save.getTransactionAmount());
			transactionDTO.setBeneficiaryAccountNumber(save.getToAccountNumber());
			transactionDTO.setDateOfPayment(save.getTransactionDate());
			transactionDTO.setModeOfTransaction(save.getModeOfPayment());
			transactionDTO.setCustomerAccountNumber(accountNumber);
			transactionDTO.setSerialNumber(save.getSerialNumber());
			
			transactionDTOs.add(transactionDTO);
		
		}		
		return transactionDTOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TransactionResponseDTO checkTransaction(TransactionDTO transactionDTO) {
		
		
		List<BeneficiaryInfo> beneficiaryInfos=new ArrayList<>();
		AccountInfo accountInfo1=accountInfoDao.readAccountInfo(transactionDTO.getCustomerAccountNumber());
		TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
		
		beneficiaryInfos=beneficiaryInfoDao.readAllBeneficiaries(transactionDTO.getCustomerAccountNumber());
		int flag=0;
		for(BeneficiaryInfo b:beneficiaryInfos)
		{
			if(b.getBeneficiaryAccountNumber().equals(transactionDTO.getBeneficiaryAccountNumber()))
			{
				flag=1;
				break;
			}
		}
		double actualBalance=accountInfo1.getAccountBalance();
		
		double transactionAmount=Double.parseDouble(transactionDTO.getAmount());
		
		if(flag==0)
		{
			transactionResponseDTO.setResponse("BENEFICIARY DOESNOT EXIST");
		}
		else if(actualBalance<transactionAmount)
		{
			transactionResponseDTO.setResponse("INSUFFICIENT ACCOUNT BALANCE");
		}
			
		else
		{
			transactionResponseDTO.setResponse("OK");
		}
		
		return transactionResponseDTO;
	
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TransactionDTO> getAllTransactionsByDate(GetTransactionDTO getTransactionDTO) {
		
		List<TransactionDTO> transactionDTOs=new ArrayList<>();
		
		List<TransactionInfo> transactionInfos=transactionInfoDao.readTransactionsBetweenDate(getTransactionDTO.getAccountNumber(), getTransactionDTO.getFromDate(), getTransactionDTO.getToDate());
		for(TransactionInfo transactionInfo:transactionInfos)
		{
			TransactionDTO transactionDTO=new TransactionDTO();
			if(transactionInfo.getCredit()==0)
			{
				transactionDTO.setDebitOrCredit("DEBIT");
				transactionDTO.setAmount(transactionInfo.getDebit()+"");
			}
			else
			{
				transactionDTO.setDebitOrCredit("CREDIT");
				transactionDTO.setAmount(transactionInfo.getCredit()+"");
			}
			
			transactionDTO.setBeneficiaryAccountNumber(transactionInfo.getParticular());
			transactionDTO.setDateOfPayment(transactionInfo.getTransactionDate());
			transactionDTO.setModeOfTransaction(transactionInfo.getModeOfTransaction());
			
			transactionDTOs.add(transactionDTO);
			
		}
		
		return transactionDTOs;
	
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<BeneficiaryDTO> getAllBeneficiaries(String accountNumber) 
	{
		List<BeneficiaryDTO> beneficiaryDTOs=new ArrayList<>();
		List<BeneficiaryInfo> beneficiaryInfos=beneficiaryInfoDao.readAllBeneficiaries(accountNumber);
		for(BeneficiaryInfo beneficiaryInfo:beneficiaryInfos)
		{
			BeneficiaryDTO beneficiaryDTO=new BeneficiaryDTO();
			beneficiaryDTO.setBeneficiaryAccountNumber(beneficiaryInfo.getBeneficiaryAccountNumber());
			beneficiaryDTO.setBeneficiaryName(beneficiaryInfo.getBeneficiaryAccountName());
			beneficiaryDTO.setBeneficiaryNickName(beneficiaryInfo.getBeneficiaryNickName());
			
			beneficiaryDTOs.add(beneficiaryDTO);
			
		}
		return beneficiaryDTOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TransactionDTO> getTransactions(String accountNumber) {
		List<TransactionInfo> transactionInfos=transactionInfoDao.readAllTransactionsByAccountNumber(accountNumber);
		
		List<TransactionDTO> transactionDTOs=new ArrayList<>();
		for(TransactionInfo transactionInfo:transactionInfos)
		{
			TransactionDTO transactionDTO=new TransactionDTO();
			if(transactionInfo.getCredit()==0)
			{
				transactionDTO.setDebitOrCredit("DEBIT");
				transactionDTO.setAmount(transactionInfo.getDebit()+"");
			}
			else
			{
				transactionDTO.setDebitOrCredit("CREDIT");
				transactionDTO.setAmount(transactionInfo.getCredit()+"");
			}
			
			transactionDTO.setBeneficiaryAccountNumber(transactionInfo.getParticular());
			transactionDTO.setDateOfPayment(transactionInfo.getTransactionDate());
			transactionDTO.setModeOfTransaction(transactionInfo.getModeOfTransaction());
			
			transactionDTOs.add(transactionDTO);
			
		}
		
		return transactionDTOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteSavedPayment(TransactionDTO transactionDTO)
	{
		savedPaymentsInfoDao.deleteSavedPayment(transactionDTO.getSerialNumber());
		
	}

	
	
	
}


