package edu.spring.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class ProfileController {
	private static final Logger logger =
			LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/profile")
	public void profile(Model model, String memberUserid) {
		logger.info("profile() 호출 : memberUserid = " + memberUserid);
		MemberVO vo = memberService.read_profile(memberUserid);
		model.addAttribute("vo", vo);
	}
	
	@GetMapping("/update")
	public void updateGET(Model model, String memberUserid) {
		logger.info("updateGET() 호출 : memberUserid = " + memberUserid);
		MemberVO vo = memberService.read_profile(memberUserid);
		model.addAttribute("vo", vo);
	}
	
	@PostMapping("/update")
	public String updatePOST(MemberVO vo, String memberUserid, RedirectAttributes reAttr) throws Exception {
		logger.info("updatePOST() 호출 : vo = " + vo.toString());
		int result = memberService.update(vo);
		if(result == 1) {
			logger.info("update 성공");
			reAttr.addFlashAttribute("update_result", "success");
			return "redirect:/member/profile?memberUserid=" + memberUserid;
		} else {
			logger.info("update 실패");
			reAttr.addFlashAttribute("update_result", "fail");
			return "redirect:/member/update?memberUserid=" + memberUserid;
		}
	}
	
	@GetMapping("/delete")
	public String delete(String memberUserid, RedirectAttributes reAttr, HttpServletRequest request) {
		logger.info("delete() 호출 : memberUserid = " + memberUserid);
		int result = memberService.delete(memberUserid);
		if(result == 1) {
			logger.info("delete 성공");
			HttpSession session = request.getSession();
			session.removeAttribute("userid");
			reAttr.addFlashAttribute("delete_result", "success");
			return "redirect:/main/main";
		}else {
			logger.info("delete 실패");
			reAttr.addFlashAttribute("delete_result", "fail");
			return "redirect:/member/profile?memberUserid=" + memberUserid;
		}
	}
	
}
