package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class PlayDAOImple implements PlayDAO {
	private static final Logger logger = LoggerFactory.getLogger(PlayDAOImple.class);
	private static final String NAMESPACE = "edu.spring.hotel.PlayMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(PlayVO vo) {
		logger.info("insert() 호출");

		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<PlayVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public PlayVO select(int playNo) {
		logger.info("select() 호출 : playNo = " + playNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_play_no", playNo);
	}

	@Override
	public int update(PlayVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int playNo) {
		logger.info("delete() 호출 : playNo = " + playNo);
		return sqlSession.delete(NAMESPACE + ".delete", playNo);
	}

	@Override
	public List<PlayVO> select(PageCriteria criteria) {
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
	public int updateReplyCount(int amount, int playNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("playNo", playNo);
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}

	@Override
	public List<PlayVO> selectOrderByReply(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".order_by_reply", criteria);
	}

	@Override
	public List<PlayVO> selectOrderByPrice(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		logger.info("select() 호출 : keyword = " + criteria.getKeyword());
		
		return sqlSession.selectList(NAMESPACE + ".order_by_price", criteria);
	}

	@Override
	public int updateLikeCount(int amount, int playNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("playNo", playNo);
		return sqlSession.update(NAMESPACE + ".update_like_count", args);
	}

	@Override
	public List<PlayVO> selectOrderByLike(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".order_by_like", criteria);
	}

	@Override
	public List<PlayVO> recommendKeyword(String keyword) {
		logger.info("recoomend(keyword)호출 keyword = " + keyword);
		keyword = "%" + keyword + "%";
		
		return sqlSession.selectList(NAMESPACE + ".recommend_keyword", keyword);
	} // end recommendKeyword()

	@Override
	public List<PlayVO> searchKeyword(String keyword) {
		logger.info("searchKeyword()호출 ");
		keyword= "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".search_keyword", keyword);
	}

}
