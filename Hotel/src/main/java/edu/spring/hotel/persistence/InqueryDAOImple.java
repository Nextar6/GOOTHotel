package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class InqueryDAOImple implements InqueryDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(InqueryDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.InqueryMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(InqueryVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<InqueryVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public InqueryVO select(int inqueryNo) {
		logger.info("select() 호출 : inqueryNo = " + inqueryNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_inquery_no", inqueryNo);
	}

	@Override
	public int update(InqueryVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int inqueryNo) {
		logger.info("delete() 호출 : inqueryNo = " + inqueryNo);
		return sqlSession.delete(NAMESPACE + ".delete", inqueryNo);
	}

	// memberUserid 찾아서 이동 ???
	@Override
	public List<InqueryVO> select(String memberUserid) {
		logger.info("select() 호출 : memberUserid = " + memberUserid);
		memberUserid = "%" + memberUserid + "%";
		return sqlSession.selectOne(NAMESPACE + ".select_by_memberUserid", memberUserid);
	}

	@Override
	public List<InqueryVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<InqueryVO> selectByTitleOrContent(String keyword) {
		logger.info("select() 호출 : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}

	@Override
	public int updateReplyCount(int amount, int inqueryNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("inqueryNo", inqueryNo);
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}
	

}
