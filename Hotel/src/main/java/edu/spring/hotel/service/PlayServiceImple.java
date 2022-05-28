package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.PlayDAO;
import edu.spring.hotel.persistence.PlayReviewDAO;

@Service
public class PlayServiceImple implements PlayService{

	private static final Logger logger =
			LoggerFactory.getLogger(PlayServiceImple.class);
	
	@Autowired
	private PlayDAO dao;
	
	@Autowired
	private PlayReviewDAO playReviewDAO;
	
	
	@Override
	public int create(PlayVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<PlayVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public PlayVO read(int playNo) {
		logger.info("read() 호출 : playNo = " + playNo);
		return dao.select(playNo);
	}

	@Override
	public int update(PlayVO vo) {
		logger.info("update() 호출 : vo");
		
		
		return dao.update(vo);
	}

	@Transactional
	@Override
	public int delete(int playNo) {
		logger.info("delete() 호출 : playNo = " + playNo);
		// TODO 글삭제시 리뷰 playRvNo의 번호를 찾아서 다삭제하는 쿼리
		playReviewDAO.deleteByPlayNo(playNo);
		return dao.delete(playNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}

	
//	---------검색---------
	@Override
	public List<PlayVO> readByWriter(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchByWriterCounts(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlayVO> readByTitleOrContent(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchByTitleOrCounts(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlayVO> read() {
		logger.info("read 호출");
		return dao.select();
	}

	@Override
	public List<PlayVO> readOrderByReply(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.selectOrderByReply(criteria);
	}

	@Override
	public List<PlayVO> readOrderByPrice(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		logger.info("read() 호출 : keyword = " + criteria.getKeyword());
		
		return dao.selectOrderByPrice(criteria);
	}

	@Override
	public List<PlayVO> readOrderByLike(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		
		return dao.selectOrderByLike(criteria);
	}

	@Override
	public List<PlayVO> readRecommendKeyword(String keyword) {
		logger.info("readRecommendKeyword 호출");
		return dao.recommendKeyword(keyword);
	} // end readRecommendKeyword
	
	@Override
	public List<PlayVO> readSearchKeyword(String keyword){
		logger.info("readSearchKeyword 호출");
		return dao.searchKeyword(keyword);
	} // end readSearchKeyword
}
