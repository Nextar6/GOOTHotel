package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.QuestionVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.QuestionDAO;

@Service
public class QuestionServiceImple implements QuestionService{

	private static final Logger logger =
			LoggerFactory.getLogger(QuestionServiceImple.class);
	
	@Autowired
	private QuestionDAO dao;

	@Override
	public int create(QuestionVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<QuestionVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public QuestionVO read(int questionNo) {
		logger.info("read() 호출 : questionNo = " + questionNo);
		return dao.select(questionNo);
	}

	@Override
	public int update(QuestionVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int questionNo) {
		logger.info("delete() 호출 : questionNo = " + questionNo);
		return dao.delete(questionNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}
	
}