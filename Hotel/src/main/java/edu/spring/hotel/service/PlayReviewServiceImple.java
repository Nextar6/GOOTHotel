package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.PlayReviewVO;
import edu.spring.hotel.persistence.PlayDAO;
import edu.spring.hotel.persistence.PlayReviewDAO;

@Service
public class PlayReviewServiceImple implements PlayReviewService{
	private static final Logger logger = LoggerFactory.getLogger(PlayReviewServiceImple.class);

	@Autowired
	private PlayReviewDAO playReviewDAO;

	@Autowired
	private PlayDAO playDAO;
	
	@Transactional
	@Override
	public int create(PlayReviewVO vo) throws Exception {
		logger.info("create 호출 : vo = " + vo.toString());
		playReviewDAO.insert(vo);
		logger.info("댓글 입력 성공");
		playDAO.updateReplyCount(1, vo.getPlayNo());
		logger.info("게시판 댓글 개수 업데이트 성공");
		
		// 리뷰 등록시 평점 playRvLike열의 1~5까지 가져온값 play게시판의 컬럼에 더해줌
		logger.info("평점 = " + vo.getPlayRvLike());
		playDAO.updateLikeCount(vo.getPlayRvLike(), vo.getPlayNo());
		logger.info("Play게시판 평점 개수 업데이트 성공");
		return 1;
	}

	@Override
	public List<PlayReviewVO> read(int playNo) {
		logger.info("read() 호출 : palyNo = " + playNo);
		return playReviewDAO.select(playNo);
	}

	@Override
	public int update(PlayReviewVO vo) {
		logger.info("read() 호출 : playNo = " + vo.toString());
		return playReviewDAO.update(vo);
	}

	@Transactional
	@Override
	public int delete(int playRvNo, int playNo, int playRvLike) {
		logger.info("delete() 호출 : playRvNo(리뷰게시판 번호) = " + playRvNo);
		logger.info("delete() 호출 : play(게시판번호) = " + playNo);
		logger.info("delete() 호출 : playRvLike(삭제할 리뷰 평점) = " + playRvLike);
		
		logger.info("게시판 댓글 개수 업데이터 성공");
		playDAO.updateReplyCount(-1, playNo);
		// 리뷰 삭제시 평점 playRvLike열의 1~5까지 가져온값을 빼줌
		playDAO.updateLikeCount(-playRvLike, playNo);
		logger.info("댓글 삭제 play평점 Minus ");
		playReviewDAO.delete(playRvNo);
		logger.info("댓글 삭제 성공");
		
		return 1;
	}
	

}
