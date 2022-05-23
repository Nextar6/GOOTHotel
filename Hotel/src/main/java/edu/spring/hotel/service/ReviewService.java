package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReviewVO;

public interface ReviewService {
	int create(ReviewVO vo) throws Exception;
	int update(ReviewVO vo) throws Exception;
	int delete(int reviewNo);
	List<ReviewVO> read_all();
	List<ReviewVO> read_by_hotel_no(int hotelNo);
	List<ReviewVO> read_by_writer(String reviewWriter);
	ReviewVO read_by_review_no(int reviewNo);
}
