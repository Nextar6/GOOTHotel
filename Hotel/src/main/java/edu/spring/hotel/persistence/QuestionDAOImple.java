package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.QuestionVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class QuestionDAOImple implements QuestionDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(ProjectDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.QuestionMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(QuestionVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<QuestionVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public QuestionVO select(int questionNo) {
		logger.info("select() 호출 : eventNo = " + questionNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_question_no", questionNo);
	}

	@Override
	public int update(QuestionVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int questionNo) {
		logger.info("delete() 호출 : QuestionNo = " + questionNo);
		return sqlSession.delete(NAMESPACE + ".delete", questionNo);
	}

	@Override
	public List<QuestionVO> select(PageCriteria criteria) {
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
