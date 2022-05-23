package edu.spring.hotel.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.domain.ReviewVO;
import edu.spring.hotel.service.HotelService;
import edu.spring.hotel.service.MemberService;
import edu.spring.hotel.service.ReviewService;
import edu.spring.hotel.util.FileUploadUtil;
import edu.spring.hotel.util.MediaUtil;

@Controller
@RequestMapping(value="/review")
public class ReviewController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HotelService hotelService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	
	@GetMapping("/register")
	public void registerGET(Model model, String reviewWriter, Integer hotelNo) {
		logger.info("registerGET() 호출");
		MemberVO mvo = memberService.read_profile(reviewWriter);
		HotelVO hvo = hotelService.read_by_no(hotelNo);
		model.addAttribute("mvo", mvo);
		model.addAttribute("hvo", hvo);
	}
	
	@PostMapping("/register")
	public String registerPOST(ReviewVO vo, RedirectAttributes reAttr) throws Exception {
		logger.info("registerPOST() 호출");
		int result = reviewService.create(vo);
		if(result == 1) {
			reAttr.addFlashAttribute("register_result", "success");
			return "redirect:/hotel/detail?hotelNo=" + vo.getHotelNo();
		} else {
			reAttr.addFlashAttribute("register_result", "fail");
			return "redirect:/review/register";
		}
	}
	
	@GetMapping("/detail")
	public void review(Model model, String reviewWriter) {
		logger.info("review() 호출 : reviewWriter = " + reviewWriter);
		MemberVO vo = memberService.read_profile(reviewWriter);
		model.addAttribute("vo", vo);
		List<ReviewVO>list = reviewService.read_by_writer(reviewWriter);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/delete")
	public String delete(Integer reviewNo, String reviewWriter, RedirectAttributes reAttr){
		logger.info("delete() 호출");
		int result = reviewService.delete(reviewNo); 
		if(result == 1) {
			logger.info("delete 성공");
			reAttr.addFlashAttribute("delete_result", "success");
			return "redirect:/review/detail?reviewWriter=" + reviewWriter;
		} else {
			logger.info("delete 실패");
			reAttr.addFlashAttribute("delete_result", "fail");
			return "redirect:/review/detail?reviewWriter=" + reviewWriter;
		}
	}
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer reviewNo) {
		logger.info("updateGET() 호출");
		ReviewVO vo = reviewService.read_by_review_no(reviewNo);
		model.addAttribute("vo", vo);
	}
	
	@PostMapping("/update")
	public String updatePOST(ReviewVO vo, String reviewWriter, Integer reviewNo ,RedirectAttributes reAttr) throws Exception {
		logger.info("updatePOST() 호출 : vo = " + vo.toString());
		int result = reviewService.update(vo);
		if(result == 1) {
			logger.info("update 성공");
			reAttr.addFlashAttribute("update_result", "success");
			return "redirect:/review/detail?reviewWriter=" + reviewWriter;
		} else {
			logger.info("update 실패");
			reAttr.addFlashAttribute("update_result", "fail");
			return "redirect:/review/update?reviewNo=" + reviewNo;
		}
	}
	
	@GetMapping("/fileUpload")
	public void uploadGET() {
		logger.info("uploadGET() 호출");
	}
	
	@ResponseBody
	@PostMapping("/fileUpload")
	public ResponseEntity<String[]> fileUploadPOST(MultipartFile[] filelist) throws Exception{
		logger.info("fileUploadPOST() 호출");
		
		String result = "";
		String[] images = new String[filelist.length];
		for(int i = 0; i < filelist.length; i++) {
			result = FileUploadUtil.saveUploadedFile(uploadPath, 
					filelist[i].getOriginalFilename(), 
					filelist[i].getBytes());
			images[i] = result;
			logger.info("images = " + images[i]);
		}
		return new ResponseEntity<String[]>(images, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/displayReview")
	public ResponseEntity<byte[]> display(String fileName) throws Exception{
		logger.info("displayReview() 호출");
		
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
