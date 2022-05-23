package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ReviewVO;

@Repository
public class ReviewDAOImple implements ReviewDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(ReviewDAOImple.class);

	private static final String NAMESPACE =
			"edu.spring.hotel.ReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReviewVO vo) throws Exception {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(ReviewVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int reviewNo) {
		logger.info("delete() 호출 : reviewNo = " + reviewNo);
		return sqlSession.delete(NAMESPACE + ".delete", reviewNo);
	}

	@Override
	public List<ReviewVO> select_all() {
		logger.info("select_all() 호출 ");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public List<ReviewVO> select_by_hotel_no(int hotelNo) {
		logger.info("select_by_hotel_no() 호출 : hotelNo = " + hotelNo);
		return sqlSession.selectList(NAMESPACE + ".select_by_hotel_no", hotelNo);
	}

	@Override
	public List<ReviewVO> select_by_writer(String reviewWriter) {
		logger.info("select_by_writer() 호출 : reviewWriter = " + reviewWriter);
		return sqlSession.selectList(NAMESPACE + ".select_by_writer", reviewWriter);
	}

	@Override
	public ReviewVO select_by_review_no(int reviewNo) {
		logger.info("select_by_review_no() 호출 : reviewNo = " + reviewNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_review_no", reviewNo);
	}

}
