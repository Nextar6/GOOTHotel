package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.FoodReviewVO;

public interface FoodReviewService {
	int create(FoodReviewVO vo) throws Exception;
	List<FoodReviewVO> read(int foodNo);
	int update(FoodReviewVO vo);
	int delete(int foodNo, int foodRvNo, int foodRvLike);
	

}
