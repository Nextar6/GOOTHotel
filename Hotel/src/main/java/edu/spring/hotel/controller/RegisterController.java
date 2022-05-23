package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class RegisterController {
	private static final Logger logger =
			LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET() 호출");
	}
	
	@PostMapping("/register")
	public String registerPOST(MemberVO vo, RedirectAttributes reAttr) throws Exception {
		logger.info("registerPOST() 호출 ");
		int result = memberService.create(vo);
		logger.info(result + "행 삽입");
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/member/login";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/member/register";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheck(String memberUserid) {
		logger.info("idCheck() 호출 : memberUserid = " + memberUserid);
		String userid = memberService.read_register_id_check(memberUserid);
		logger.info("userid = " + userid);
		String result = null;
		if(userid == null) {
			logger.info("사용가능");
			result = "yes";
		} else {
			logger.info("이미사용중");
			result = "no";
		}
		return result;
	}
	
}