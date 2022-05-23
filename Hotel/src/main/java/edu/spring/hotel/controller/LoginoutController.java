package edu.spring.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class LoginoutController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginoutController.class);

	@Autowired
	private MemberService memberService;

	
	
	@GetMapping("/login")
	public void loginGET() {
		logger.info("loginGET() 호출");
		
	}
	
	
	
	@PostMapping("/login")
	public String loginPOST(String memberUserid, String memberPassword, HttpServletRequest request, RedirectAttributes reAttr) {
		logger.info("loginPOST() 호출");
		String userid = memberService.read_login(memberUserid, memberPassword);
		logger.info("userid = " + userid);
		if(memberUserid.equals("manager") && memberPassword.equals("12341234")) {
			logger.info("관리자용 로그인");
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			reAttr.addFlashAttribute("admin_login_result", "success");
			return "redirect:/main/admin-page";
		}
		
		if (userid != null){
			logger.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			reAttr.addFlashAttribute("login_result", "success");
			
			// 회원로그인 성공시 타겟URL로 이동
			String targetURL = (String) session.getAttribute("targetURL");
			
			logger.info("targetURL : " + targetURL);
			if(targetURL == null) {
				return "redirect:../main/main";
			} else {
				
				return "redirect:" + targetURL;
			}
		} else {
			logger.info("로그인 실패");
			reAttr.addFlashAttribute("login_result", "fail");
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes reAttr) {
		logger.info("logout() 호출");
		
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("admin");
		session.removeAttribute("targetURL");
		reAttr.addFlashAttribute("logout_result", "success");
		return "redirect:/main/main";
	}
	
	
}	