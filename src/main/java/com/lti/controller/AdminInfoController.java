package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDTO;
import com.lti.model.AdminInfo;
import com.lti.service.AdminInfoService;

@RestController
@RequestMapping(path = "admininfo")
@CrossOrigin
public class AdminInfoController {

	@Autowired
	private AdminInfoService adminInfoService;
	
	
	//http://localhost:9091/Digiseva/admininfo/createadmin
	@PostMapping(path="/createadmin")
	public void createAdmin(@RequestBody AdminInfo adminInfo)
	{
		adminInfoService.createAdminInfo(adminInfo);
	}
	
	//http://localhost:9091/Digiseva/admininfo/adminid
	@PostMapping(path="/adminid")
	public LoginDTO getAdmin(@RequestBody String adminId)
	{
		 return adminInfoService.readAdminInfo(adminId);
		 
	}
	
}
