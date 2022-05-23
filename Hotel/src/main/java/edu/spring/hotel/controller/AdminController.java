package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class AdminController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginoutController.class);


	@GetMapping("/admin-page")
	public void adminPageGET() {
		logger.info("adminPage GET 호출");
	}
	
	@GetMapping("/inquery-admin")
	public String inqueryAdminGET() {
		logger.info("inquery-admin GET 호출");
		
		return "redirect:../board/inquery-admin";

	}



}
