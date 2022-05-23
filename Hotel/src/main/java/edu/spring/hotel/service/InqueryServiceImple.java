package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.InqueryReplyVO;
import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.InqueryDAO;

@Service
public class InqueryServiceImple implements InqueryService{
	private static final Logger logger =
	LoggerFactory.getLogger(InqueryServiceImple.class);
	
	@Autowired
	private InqueryDAO dao;

	@Override
	public int create(InqueryVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public InqueryVO read(int inqueryNo) {
		logger.info("read() 호출 : inqueryNo = " + inqueryNo);
		return dao.select(inqueryNo);
	}


	@Override
	public int update(InqueryVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int inqueryNo) {
		logger.info("delete() 호출 : inqueryNo = " + inqueryNo);
		return dao.delete(inqueryNo);
	}

	@Override
	public List<InqueryVO> read(String memberUserid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InqueryVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}


}
	