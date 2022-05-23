package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.FoodReviewVO;
import edu.spring.hotel.persistence.FoodDAO;
import edu.spring.hotel.persistence.FoodReviewDAO;

@Service
public class FoodReviewServiceImple implements FoodReviewService{
	private static final Logger logger = LoggerFactory.getLogger(FoodReviewServiceImple.class);

	@Autowired
	private FoodReviewDAO foodReviewDAO;
	
	@Autowired
	private FoodDAO foodDAO;

	
	@Transactional
	@Override
	public int create(FoodReviewVO vo) throws Exception {
	logger.info("create 호출 : vo = " + vo.toString());
	foodReviewDAO.insert(vo);
	logger.info("댓글 입력 성공");
	foodDAO.updateReplyCount(1, vo.getFoodNo());
	logger.info("게시판 댓글 개수 업데이트 성공");
	
	// 리뷰 등록시 평점 playRvLike열의 1~5까지 가져온값 play게시판의 컬럼에 더해줌
	logger.info("평점 = " + vo.getFoodRvLike());
	foodDAO.updateLikeCount(vo.getFoodRvLike(), vo.getFoodNo());
	logger.info("Play게시판 평점 개수 업데이트 성공");
	return 1;
}

	@Override
	public List<FoodReviewVO> read(int foodNo) {
		logger.info("read() 호출 : foodNo = " + foodNo);
		return foodReviewDAO.select(foodNo);
	}
	@Override
	public int update(FoodReviewVO vo) {
		logger.info("read() 호출 : foodNo = " + vo.toString());
		return foodReviewDAO.update(vo);
	}

	@Transactional
	@Override
	public int delete(int foodNo, int foodRvNo, int foodRvLike) {
		logger.info("delete() 호출 : foodRvNo(리뷰게시판 번호) = " + foodRvNo);
		logger.info("delete() 호출 : food(게시판번호) = " + foodNo);
		logger.info("delete() 호출 : foodRvLike(삭제할 리뷰 평점) = " + foodRvLike);
		
		logger.info("게시판 댓글 개수 업데이터 성공");
		foodDAO.updateReplyCount(-1, foodNo);
		// 리뷰 삭제시 평점 playRvLike열의 1~5까지 가져온값을 빼줌
		foodDAO.updateLikeCount(-foodRvLike, foodNo);
		logger.info("댓글 삭제 food평점 Minus ");
		foodReviewDAO.delete(foodRvNo);
		logger.info("댓글 삭제 성공");
		
		return 1;
	}
	
	
}
