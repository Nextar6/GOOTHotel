package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface FoodService {
	int create(FoodVO vo);
	List<FoodVO> read();
	List<FoodVO> read(PageCriteria criteria);
	FoodVO read(int foodNo);
	int update(FoodVO vo);
	int delete(int foodNo);
	
	int getTotalCounts();

}
