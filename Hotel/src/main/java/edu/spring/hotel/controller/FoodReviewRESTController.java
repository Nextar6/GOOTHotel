package edu.spring.hotel.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.FoodReviewVO;
import edu.spring.hotel.domain.InqueryReplyVO;
import edu.spring.hotel.domain.PlayReviewVO;
import edu.spring.hotel.service.FoodReviewService;
import edu.spring.hotel.service.InqueryReplyServiceImple;
import edu.spring.hotel.service.PlayReviewService;
import edu.spring.hotel.service.PlayReviewServiceImple;


// * RESTful url과 의미
// /replies (POST) : 댓글 추가(insert)
// /replies/all/숫자 (GET) : 해당 글 번호(boardNo)의 모든 댓글 검색(select)
// /replies/숫자 (PUT) : 해당 댓글 번호(replyNo)의 내용을 수정(update)
// /replies/숫자 (DELETE) : 해당 댓글 번호(replyNo)의 댓글을 삭제(delete)

@RestController
@RequestMapping(value="/play")
public class FoodReviewRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(FoodReviewRESTController.class);
	
	@Autowired
	private FoodReviewService foodReviewService;
	
	@PostMapping ("foodReplies")// POST : 댓글 입력
	public ResponseEntity<Integer> createReply(@RequestBody FoodReviewVO vo) {
		// @RequestBody
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		logger.info("createReply() 호출 : vo = " + vo.toString());
		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		// - 데이터와 HttpStatus를 전송
		// - <T> : 보내고자 하는 데이터 타입
		int result = 0;
		try {
			result = foodReviewService.create(vo);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // PlayInsertPOST
	
	@GetMapping("foodReplies/all/{foodNo}") // GET : 댓글 선택(all)
	public ResponseEntity<List<FoodReviewVO>> readReplies(
			@PathVariable("foodNo") int foodNo) {
		List<FoodReviewVO> list = foodReviewService.read(foodNo);
		logger.info("test");
		return new ResponseEntity<List<FoodReviewVO>>(list, HttpStatus.OK);	
	}
	
	@PutMapping("foodReplies/{foodRvNo}") // PUT : 댓글 수정
	public ResponseEntity<String> updateReply(
			@PathVariable("foodRvNo") int foodRvNo,
			@RequestBody FoodReviewVO vo
			) {
		logger.info("foodRvNo : " + foodRvNo);
		logger.info("foodRvContent : " + vo.getFoodRvContent());

		vo.setFoodRvNo(foodRvNo);
		int result = foodReviewService.update(vo);
		if(result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("foodReplies/{foodRvNo}") // DELETE : 댓글 삭제
	public ResponseEntity<String> deleteReply(
			@PathVariable("foodRvNo") int foodRvNo,
			@RequestBody FoodReviewVO vo
			) {
		logger.info("Delete foodRvNo = " + foodRvNo);
		logger.info("foodNo" + vo.getFoodNo());
		logger.info("foodRvLike" + vo.getFoodRvLike());
		
		
		try {
			foodReviewService.delete(foodRvNo, vo.getFoodNo(),vo.getFoodRvLike());
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
	}
	
}
