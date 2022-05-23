package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.InqueryReplyVO;

@Repository
public class InqueryReplyDAOImple implements InqueryReplyDAO{

	private static final Logger logger =
			LoggerFactory.getLogger(InqueryReplyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.InqueryReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(InqueryReplyVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<InqueryReplyVO> select(int inqueryNo) {
		logger.info("select() 호출 : inqueryNo = " + inqueryNo);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_inquery_no", inqueryNo);
	}

	@Override
	public int update(InqueryReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int inqueryRpNo) {
		logger.info("delete() 호출 : inqueryRpNo = " + inqueryRpNo);
		return sqlSession.delete(NAMESPACE + ".delete", inqueryRpNo);
	}
	

}
