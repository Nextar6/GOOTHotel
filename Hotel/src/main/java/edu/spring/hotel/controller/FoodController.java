package edu.spring.hotel.controller;

import java.io.IOException;
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

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.service.FoodService;


@Controller
@RequestMapping("play")
public class FoodController {
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
@Autowired
private FoodService foodService;
	
	@GetMapping("food")
	public void foodGET(Model model, Integer page) {
		logger.info("food 호출");
	
		
		List<FoodVO> foodList = foodService.read();
		
		model.addAttribute("foodList", foodList);
		
	} // end foodGET()
	
	
	@GetMapping("food-insert")
	public void foodInsertGET() {
		logger.info("food-insert GET 호출");
	} // end food-insert
	
	@PostMapping("food-insert")
	public String foodInsertPOST(FoodVO vo, Model model, RedirectAttributes reAttr) throws IOException {
		logger.info("playInsertPOST() 호출 : ");

		logger.info("files Name : " + vo.getFoodPic());
		logger.info(vo.getFoodPic());

		logger.info(vo.toString());
		int result = foodService.create(vo);
		logger.info(result + "행삽입");

		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/play/food";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/play/food-insert";
		}

	} // post register()
	
	@GetMapping("food-detail")
	public void foodDetailGET(Model model, Integer foodNo, Integer page) {
		logger.info("food-detail 호출 foodNo : " + foodNo);
		FoodVO vo = foodService.read(foodNo);
		logger.info("이미지 경로 : " + vo.getFoodPic());
		
		String[] picArray = vo.getFoodPic().split(",");
		for (int i = 0; i < picArray.length; i++) {
			logger.info("그림 배열 저장 확인 : " + picArray[i]);
		}
		model.addAttribute("picArray", picArray);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
	} // end food-detail
	@GetMapping("food-delete")
	public String delete(Integer foodNo, RedirectAttributes reAttr) {
		logger.info("food delete 호출  foodNo : " + foodNo);
		int result = foodService.delete(foodNo);
		if (result == 1) {
			reAttr.addFlashAttribute("delete_result", "success");
			return "redirect:/play/food";
		} else {
			reAttr.addFlashAttribute("delete_fail", "fail");
			return "redirect:/play/food-detail";
		}
	} // end food delet
	
	@GetMapping("food-update")
	public void updateGET(Model model, Integer foodNo, Integer page) {
		logger.info("updateGET 호출 : foodNo = " + foodNo);
		FoodVO vo = foodService.read(foodNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()
	
	@PostMapping("food-update")
	public String updatePOST(FoodVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("updatePOST 호출 : vo " + vo.toString());

		int result = foodService.update(vo);

		if (result == 1) {
			reAttr.addFlashAttribute("update_result", "success");
			return "redirect:/play/food";
		} else
			reAttr.addFlashAttribute("update_fail", "fail");
		return "redirect:/play/food-update?foodNo=" + vo.getFoodNo();

	} // end food-updatePOST()
	
	@GetMapping("food-search")
	public void foodSearchGET(Model model, String keyword) {
		logger.info("food-search GET 호출");
		List<FoodVO> foodList = foodService.readSearchKeyword(keyword);
		model.addAttribute("foodList", foodList);
		
	} // end food-search
	
}