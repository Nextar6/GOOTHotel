package edu.spring.hotel.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.ReservatVO;
import edu.spring.hotel.domain.ReviewVO;
import edu.spring.hotel.service.HotelService;
import edu.spring.hotel.service.ReservatService;
import edu.spring.hotel.service.ReviewService;
import edu.spring.hotel.util.MediaUtil;

@Controller
@RequestMapping(value="/hotel")
public class HotelController {
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReservatService reservatService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@GetMapping("/register")
	public void registerGET() {
	}
	
	@PostMapping("/register")
	public String registerPOST(HotelVO vo, RedirectAttributes reAttr) throws Exception {
		int result = hotelService.create(vo);
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/main/main";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/hotel/register";
		}
	}
	
	@GetMapping("/detail")
	public void detail(Model model, Integer hotelNo, Integer page, HttpSession session) {
		logger.info("detail 확인");
		String userid = (String) session.getAttribute("userid");
		List<ReservatVO> rlist = reservatService.read_by_reservatUserid_hotelNo(hotelNo, userid);
		HotelVO vo = hotelService.read_by_no(hotelNo);
		List<ReviewVO> list = reviewService.read_by_hotel_no(hotelNo);
		model.addAttribute("rlist", rlist);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		model.addAttribute("userid", userid);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer hotelNo) {
		HotelVO vo = hotelService.read_by_no(hotelNo);
		model.addAttribute("vo", vo);
	}

	@PostMapping("/update")
	public String updatePOST(HotelVO vo, Integer hotelNo, RedirectAttributes reAttr) throws Exception {
		int result = hotelService.update(vo);
		if(result == 1) {
			reAttr.addFlashAttribute("update_hotel", "success");
			return "redirect:/hotel/detail?hotelNo=" + hotelNo;
		} else {
			reAttr.addFlashAttribute("update_hotel", "fail");
			return "redirect:/hotel/update?hotelNo=" + hotelNo;
		}
	}

	@GetMapping("/delete")
	public String delete(Integer hotelNo, RedirectAttributes reAttr) {
		int result = hotelService.delete(hotelNo);
		if(result == 1) {
			reAttr.addFlashAttribute("delete_hotel", "success");
			return "redirect:/main/main";
		} else {
			reAttr.addFlashAttribute("delete_hotel", "fail");
			return "redirect:/hotel/detail?hotelNo=" + hotelNo;
		}
	}
	
	@GetMapping("/displayimages")
	public ResponseEntity<byte[]> display(String fileName) throws Exception{
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);

		String extension = 
				filePath.substring(filePath.lastIndexOf(".") + 1);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),
					httpHeaders,
					HttpStatus.OK
		);
		return entity;
	}
}