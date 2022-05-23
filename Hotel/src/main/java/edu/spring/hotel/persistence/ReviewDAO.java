package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReviewVO;

public interface ReviewDAO {
	int insert(ReviewVO vo) throws Exception;
	int update(ReviewVO vo) throws Exception;
	int delete(int reviewNo);
	List<ReviewVO> select_all();
	List<ReviewVO> select_by_hotel_no(int hotelNo);
	List<ReviewVO> select_by_writer(String reviewWriter);
	ReviewVO select_by_review_no(int reviewNo);
}
