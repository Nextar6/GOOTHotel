package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class FindController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FindController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/find")
	public void find() {
		logger.info("find() 호출");
	}
	
	@PostMapping("/findUserid")
	public String findUseridPOST(String memberEmail, String memberPhone, RedirectAttributes reAttr) {
		logger.info("findUseridPOST() 호출");
		String userid = memberService.read_find_userid(memberEmail, memberPhone);
		logger.info("userid = " + userid);
		if(userid != null) {
			logger.info("아이디찾기 성공");
			reAttr.addFlashAttribute("find_userid_result", userid);
			return "redirect:/member/login";
		} else {
			logger.info("아이디찾기 실패");
			reAttr.addFlashAttribute("find_userid_result", 1);
			return "redirect:/member/find";
		}
	}
	
	@PostMapping("/findPassword")
	public String findPasswordPOST(String memberUserid, String memberPhone, RedirectAttributes reAttr) {
		logger.info("findPasswordPOST() 호출");
		String password = memberService.read_find_password(memberUserid, memberPhone);
		logger.info(password);
		if(password != null) {
			logger.info("비밀번호 찾기 성공");
			reAttr.addFlashAttribute("find_password_result", password);
			return "redirect:/member/login";
		} else {
			logger.info("비밀번호 찾기 실패");
			reAttr.addFlashAttribute("find_password_result", 1);
			return "redirect:/member/find";
		}
	}
}
