package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminInfoDao;
import com.lti.dto.LoginDTO;
import com.lti.model.AdminInfo;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

	@Autowired
	private AdminInfoDao adminInfoDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginDTO readAdminInfo(String adminId) 
	{
		AdminInfo adminInfo=adminInfoDao.readAdminByAdminId(adminId);
		LoginDTO loginDTO=new LoginDTO();
		if(adminInfo==null)
		{
			loginDTO.setInternetBankingId("NULL");
			loginDTO.setLoginPassword("NULL");
		}
		else {
			loginDTO.setInternetBankingId(adminInfo.getAdminId());
			loginDTO.setLoginPassword(adminInfo.getAdminPassword());
		}
		
		
		return loginDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createAdminInfo(AdminInfo adminInfo)
	{
		adminInfoDao.createAdmin(adminInfo);
		
	}

}
