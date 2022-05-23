package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.ReviewVO;
import edu.spring.hotel.persistence.ReviewDAO;

@Service
public class ReviewServiceImple implements ReviewService{
	private static final Logger logger =
			LoggerFactory.getLogger(ReviewServiceImple.class);
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Transactional
	@Override
	public int create(ReviewVO vo) throws Exception {
		logger.info("create() 호출 : vo = " + vo.toString());
		return reviewDAO.insert(vo);
	}

	@Override
	public int update(ReviewVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return reviewDAO.update(vo);
	}

	@Override
	public int delete(int reviewNo) {
		logger.info("delete() 호출 : reviewNo = " + reviewNo);
		return reviewDAO.delete(reviewNo);
	}

	@Override
	public List<ReviewVO> read_all() {
		logger.info("read_all() 호출");
		return reviewDAO.select_all();
	}

	@Override
	public List<ReviewVO> read_by_hotel_no(int hotelNo) {
		logger.info("read_by_hotel_no() 호출 : hotelNo = " + hotelNo);
		return reviewDAO.select_by_hotel_no(hotelNo);
	}

	@Override
	public List<ReviewVO> read_by_writer(String reviewWriter) {
		logger.info("read_by_writer() 호출 : reviewWriter = " + reviewWriter);
		return reviewDAO.select_by_writer(reviewWriter);
	}

	@Override
	public ReviewVO read_by_review_no(int reviewNo) {
		logger.info("read_by_review_no() 호출 : reviewNo = " + reviewNo);
		return reviewDAO.select_by_review_no(reviewNo);
	}
	
}
