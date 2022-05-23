package edu.spring.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.domain.ReservatVO;
import edu.spring.hotel.service.HotelService;
import edu.spring.hotel.service.MemberService;
import edu.spring.hotel.service.ReservatService;

@Controller
@RequestMapping(value="/reservat")
public class ReservatController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReservatController.class);
	
	@Autowired
	private ReservatService reservatService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/register")
	public void reservatGET(Model model, String reservatUserid, Integer hotelNo) {
		logger.info("reservatGET() 호출");
		MemberVO mvo = memberService.read_profile(reservatUserid);
		HotelVO hvo = hotelService.read_by_no(hotelNo);
		model.addAttribute("mvo", mvo);
		model.addAttribute("hvo", hvo);
	}
	
	@PostMapping("/register")
	public String reservatPOST(ReservatVO rvo, RedirectAttributes reAttr) throws Exception {
		logger.info("reservatPOST() 호출");
		int result = reservatService.create(rvo);
		if(result == 1) {
			return "redirect:/hotel/detail?hotelNo=" + rvo.getHotelNo();
		} else {
			return "redirect:/register?hotelNo=?" + rvo.getHotelNo() + "&reservatUserid=" + rvo.getReservatUserid();
		}
	}
	
	@GetMapping("/detail")
	public void detail(Model model, String reservatUserid) {
		logger.info("detail() 호출 : reservatUserid = " + reservatUserid);
		MemberVO vo = memberService.read_profile(reservatUserid);
		model.addAttribute("vo", vo);
		List<ReservatVO> list = reservatService.read_by_reservatUserid(reservatUserid);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer reservatNo) {
		logger.info("updateGET() 호출 : reservatNo = " + reservatNo);
		ReservatVO vo = reservatService.read_by_reservatNo(reservatNo);
		model.addAttribute("vo", vo);
		HotelVO hvo = hotelService.read_by_no(vo.getHotelNo());
		model.addAttribute("hvo", hvo);
	}
	
	@PostMapping("/update")
	public String updatePOST(ReservatVO vo, String reservatUserid, Integer reservatNo) throws Exception {
		logger.info("updatePOST() 호출 : vo = " + vo.toString());
		int result = reservatService.update(vo);
		if(result == 1) {
			logger.info("update 성공");
			return "redirect:/reservat/detail?reservatUserid=" + reservatUserid;
		} else {
			logger.info("update 실패");
			return "redirect:/reservat/update?reservatNo=" + reservatNo;
		}
	}
	
	@GetMapping("/delete")
	public String delete(Integer reservatNo) {
		logger.info("delete() 호출");
		ReservatVO vo = reservatService.read_by_reservatNo(reservatNo);
		int result = reservatService.delete(reservatNo);
		if(result == 1) {
			logger.info("delete 성공");
			return "redirect:/reservat/detail?reservatUserid=" + vo.getReservatUserid();
		} else {
			logger.info("delete 실패");
			return "redirect:/reservat/detail?reservatUserid=" + vo.getReservatUserid();
		}
	}
	
}
