package edu.spring.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.service.FoodService;

@RestController
@RequestMapping(value="play")
public class FoodRESTController {
	private static final Logger logger = LoggerFactory.getLogger(FoodRESTController.class);
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping("food/readNext/{page}") // 다음 페이지 번호 선택
	public ResponseEntity<List<FoodVO>> readFood(
			@PathVariable("page") int page) {
		// @PathVariable("foodNo") : /all/{foodNo} 값을 설정된 변수에 저장
		logger.info("확인");
		PageCriteria criteria = new PageCriteria();
		criteria.setPage(page);
		
		List<FoodVO> list = foodService.read(criteria);
		for(FoodVO vo : list) {
			int searchIndex = vo.getFoodPic().indexOf(',');
			if(searchIndex == -1) { // DB에 저장된 이미지 파일이 1장일때 , 썸네일 속도 효율 확인
//				vo.setFoodPic(vo.getFoodPic().replace("s_", ""));
			} else { // DB에 여러장 파일이 들어가 있을때
				System.out.println(searchIndex);
				vo.setFoodPic(vo.getFoodPic().substring(0, searchIndex));
//				vo.setFoodPic(vo.getFoodPic().replace("s_", ""));	
			}
			logger.info(vo.toString());
		}
		logger.info("test");
		
		
		return new ResponseEntity<List<FoodVO>>(list, HttpStatus.OK);
				
	} // end getFoodAll
	
	@GetMapping("recommend-search/{keyword}") // GET : 댓글 선택(all)
	public ResponseEntity<List<FoodVO>> readRecommend(
			@PathVariable("keyword") String keyword) {
		// @PathVariable("foodNo") : /all/{foodNo} 값을 설정된 변수에 저장
		List<FoodVO> list = foodService.readRecommendKeyword(keyword);
		logger.info("Recommend test");
		return new ResponseEntity<List<FoodVO>>(list, HttpStatus.OK);	
	}
	
	

}
