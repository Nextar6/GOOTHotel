package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class PolicyDAOImple implements PolicyDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(PolicyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.PolicyMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(PolicyVO vo) {
		logger.info("insert 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<PolicyVO> select() {
		logger.info("select 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public PolicyVO select(int policyNo) {
		logger.info("select() 호출 : policyNo = " + policyNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_policy_no", policyNo);
	}

	@Override
	public int update(PolicyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int policyNo) {
		logger.info("delete() 호출 : PolicyNo = " + policyNo);
		return sqlSession.delete(NAMESPACE + ".delete", policyNo);
	}

	@Override
	public List<PolicyVO> select(PageCriteria criteria) {
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
