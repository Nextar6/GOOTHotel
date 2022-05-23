package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class EventDAOImple implements EventDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(EventDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.EventMapper";
	
	@Autowired
	private SqlSession sqlSession;
			

	@Override
	public int insert(EventVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<EventVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public EventVO select(int eventNo) {
		logger.info("select() 호출 : eventNo = " + eventNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_event_no", eventNo);
	}

	@Override
	public int update(EventVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int eventNo) {
		logger.info("delete() 호출 : EventNo = " + eventNo);
		return sqlSession.delete(NAMESPACE + ".delete", eventNo);
	}

	@Override
	public List<EventVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

}
