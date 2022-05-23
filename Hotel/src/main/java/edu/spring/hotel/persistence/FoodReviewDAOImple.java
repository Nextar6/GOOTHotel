package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.FoodReviewVO;

@Repository
public class FoodReviewDAOImple implements FoodReviewDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(PlayReviewDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.FoodReviewMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(FoodReviewVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<FoodReviewVO> select(int foodNo) {
		logger.info("select() 호출 : foodNo = " + foodNo);
		return sqlSession.selectList(NAMESPACE + ".select_by_food_no", foodNo);
	}

	@Override
	public int update(FoodReviewVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int foodRvNo) {
		logger.info("FoodReviewDelete() 호출 : foodRvNo = " + foodRvNo);
		return sqlSession.delete(NAMESPACE + ".delete", foodRvNo);
	}

	@Override
	public int deleteByFoodNo(int foodNo) {
		logger.info("FoodReviewDeleteByFoodNo 호출 (게시글삭제 : 전체리뷰삭제) playNo = " + foodNo);
		return sqlSession.delete(NAMESPACE + ".delete_by_food_no", foodNo);
	}
}
