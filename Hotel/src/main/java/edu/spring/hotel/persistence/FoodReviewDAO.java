package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.FoodReviewVO;

public interface FoodReviewDAO {
	int insert(FoodReviewVO vo);
	List<FoodReviewVO> select(int foodNo);
	int update(FoodReviewVO vo);
	int delete(int foodRvNo);
	int deleteByFoodNo(int foodNo);

}
