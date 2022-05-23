package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.PlayReviewVO;

@Repository
public class PlayReviewDAOImple implements PlayReviewDAO{

	private static final Logger logger =
			LoggerFactory.getLogger(PlayReviewDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.PlayReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(PlayReviewVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<PlayReviewVO> select(int playNo) {
		logger.info("select() 호출 : playNo = " + playNo);
		return sqlSession.selectList(NAMESPACE + ".select_by_play_no", playNo);
	}

	@Override
	public int update(PlayReviewVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int playRvNo) {
		logger.info("playReviewDelete() 호출 : playRvNo = " + playRvNo);
		return sqlSession.delete(NAMESPACE + ".delete", playRvNo);
	}
// 게시글 삭제시 달려있는 리뷰 싹다 삭제
	@Override
	public int deleteByPlayNo(int playNo) {
		logger.info("playReviewDeleteByPlayNo 호출 (게시글삭제 : 전체리뷰삭제) playNo = " + playNo);
		return sqlSession.delete(NAMESPACE + ".delete_by_play_no", playNo);
	}
	

}
