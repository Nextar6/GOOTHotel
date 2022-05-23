package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.EventDAO;


@Service
public class EventServiceImple implements EventService{
	
	private static final Logger logger =
			LoggerFactory.getLogger(EventServiceImple.class);
	
	@Autowired
	private EventDAO dao;
	

	@Override
	public int create(EventVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
		
	}

	@Override
	public List<EventVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public EventVO read(int eventNo) {
		logger.info("read() 호출 : eventNo = " + eventNo);
		return dao.select(eventNo);
	}

	@Override
	public int update(EventVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int eventNo) {
		logger.info("delete() 호출 : eventNo = " + eventNo);
		return dao.delete(eventNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}

	
}
