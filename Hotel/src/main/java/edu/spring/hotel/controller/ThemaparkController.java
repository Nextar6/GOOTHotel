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

import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.service.ThemaparkService;

@Controller
@RequestMapping("play")
public class ThemaparkController {
	private static final Logger logger = LoggerFactory.getLogger(ThemaparkController.class);

	@Autowired
	private ThemaparkService themaparkService;
	
	
	@GetMapping("themapark")
	public void themapark(Model model, Integer page) {
		logger.info("themapark 호출");
		List<ThemaparkVO> themaparkList = themaparkService.read();
		model.addAttribute("themaparkList", themaparkList);
		
		
	} // end themaparkGET();
	
	@GetMapping("themapark-insert")
	public void themaparkInsertGET() {
		logger.info("themapark-insert GET 호출");
	} // end themapark-insert
	
	
	@PostMapping("themapark-insert")
	public String themaparkInsertPOST(ThemaparkVO vo, Model model, RedirectAttributes reAttr) {
		logger.info("themaparkInsertPOST() 호출 : ");

		logger.info("files Name : " + vo.getThemaparkPic());
		logger.info(vo.getThemaparkPic());

		logger.info(vo.toString());
		int result = themaparkService.create(vo);
		logger.info(result + "행삽입");

		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/play/themapark";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/play/themapark-insert";
		}

	} // post register()
}
