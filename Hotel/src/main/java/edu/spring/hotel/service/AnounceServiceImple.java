package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.AnounceDAO;

@Service
public class AnounceServiceImple implements AnounceService{

	private static final Logger logger =
			LoggerFactory.getLogger(AnounceServiceImple.class);
	
	@Autowired
	private AnounceDAO dao;
	
	@Override
	public int create(AnounceVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<AnounceVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public AnounceVO read(int anounceNo) {
		logger.info("read() 호출 : anounceNo = " + anounceNo);
		return dao.select(anounceNo);
	}

	@Override
	public int update(AnounceVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int anounceNo) {
		logger.info("delete() 호출 : anounceNo = " + anounceNo);
		return dao.delete(anounceNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}

	@Override
	public List<AnounceVO> readByTitleOrContent(PageCriteria criteria) {
		logger.info("readByTitleOrContent keyword : " + criteria.getKeyword());
		return dao.searchByTitleOrContent(criteria);
	}

	@Override
	public List<AnounceVO> readByWriter(PageCriteria criteria) {
		logger.info("readWriter 호출");
		logger.info("crieria.getKeyword" + criteria.getKeyword());
		
		return dao.searchByWriter(criteria);
	}

	@Override
	public int searchByWriterCounts(String keyword) {
		logger.info("searchByWriterCount 호출 keyword : "+ keyword);
		return dao.searchByWriterCount(keyword);
	}

	@Override
	public int searchByTitleOrCounts(String keyword) {
		logger.info("searchByTitleOrContentCount 호출 keyword : "+ keyword);
		keyword = "%" + keyword + "%";
		return dao.searchByTitleOrContentCount(keyword);
	}
}
