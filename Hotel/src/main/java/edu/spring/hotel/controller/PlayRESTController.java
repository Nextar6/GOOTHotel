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
import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.FoodService;
import edu.spring.hotel.service.PlayService;

@RestController
@RequestMapping(value="/play")
public class PlayRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(PlayRESTController.class);
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private PlayService playService;
	

	
	@GetMapping("play/readNext/{page}") // 다음 페이지 번호 선택
	public ResponseEntity<List<PlayVO>> readPlay(
			@PathVariable("page") int page) {
		logger.info("확인");
		PageCriteria criteria = new PageCriteria();
		criteria.setPage(page);
		
		List<PlayVO> list = playService.read(criteria);
		for(PlayVO vo : list) {
			int searchIndex = vo.getPlayPic().indexOf(',');
			if(searchIndex == -1) { // DB에 저장된 이미지 파일이 1장일때
				vo.setPlayPic(vo.getPlayPic().replace("s_", ""));
			} else { // DB에 여러장 파일이 들어가 있을때
				System.out.println(searchIndex);
				vo.setPlayPic(vo.getPlayPic().substring(0, searchIndex));
				vo.setPlayPic(vo.getPlayPic().replace("s_", ""));	
			}
			logger.info(vo.toString());
		}
		logger.info("test");
		return new ResponseEntity<List<PlayVO>>(list, HttpStatus.OK);
				
	}
	
	@GetMapping("recommend-search-play/{keyword}") // GET : 댓글 선택(all)
	public ResponseEntity<List<PlayVO>> readRecommendPlay(
			@PathVariable("keyword") String keyword) {
		// @PathVariable("playNo") : /all/{playNo} 값을 설정된 변수에 저장
		List<PlayVO> list = playService.readRecommendKeyword(keyword);
		logger.info("Recommend test");
		return new ResponseEntity<List<PlayVO>>(list, HttpStatus.OK);	
	}
}
