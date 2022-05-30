package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class ThemaparkDAOImple implements ThemaParkDAO{
	private static final Logger logger = LoggerFactory.getLogger(ThemaparkDAOImple.class);
	private static final String NAMESPACE = "edu.spring.hotel.ThemaparkMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ThemaparkVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ThemaparkVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public ThemaparkVO select(int themaparkNo) {
		logger.info("select() 호출 : themaparkNo = " + themaparkNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_themapark_no", themaparkNo);
	
	}

	@Override
	public int update(ThemaparkVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int themaparkNo) {
		logger.info("delete() 호출 : themaparkNo = " + themaparkNo);
		return sqlSession.delete(NAMESPACE + ".delete", themaparkNo);
	}

	@Override
	public List<ThemaparkVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출 ");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public int updateReplyCount(int amount, int themaparkNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("themaparkNo", themaparkNo);
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}

	@Override
	public int updateLikeCount(int amount, int themaparkNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("themaparkNo", themaparkNo);
		return sqlSession.update(NAMESPACE + ".update_like_count", args);
	}

	@Override
	public List<ThemaparkVO> recommendKeyword(String keyword) {
		logger.info("recommend(keyword) 호출");
		keyword = "%" + keyword + "%";
				
		return sqlSession.selectList(NAMESPACE + ".recommend_keyword", keyword);
	}

	@Override
	public List<ThemaparkVO> searchKeyword(String keyword) {
		logger.info("search 호출");
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".search_keyword", keyword);
	}
}

