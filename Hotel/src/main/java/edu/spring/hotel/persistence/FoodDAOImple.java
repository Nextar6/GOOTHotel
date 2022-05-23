package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class FoodDAOImple implements FoodDAO{
	private static final Logger logger = LoggerFactory.getLogger(PlayDAOImple.class);
	private static final String NAMESPACE = "edu.spring.hotel.FoodMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(FoodVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<FoodVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public FoodVO select(int foodNo) {
		logger.info("select() 호출 : foodNo = " + foodNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_food_no", foodNo);
	}

	@Override
	public int update(FoodVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int foodNo) {
		logger.info("delete() 호출 : playNo = " + foodNo);
		return sqlSession.delete(NAMESPACE + ".delete", foodNo);
	}

	@Override
	public List<FoodVO> select(PageCriteria criteria) {
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
	public int updateReplyCount(int amount, int foodNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("foodNo", foodNo);
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}

	@Override
	public int updateLikeCount(int amount, int foodNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("foodNo", foodNo);
		return sqlSession.update(NAMESPACE + ".update_like_count", args);
	}
}
