package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.PlayReviewVO;

public interface PlayReviewDAO {
	int insert(PlayReviewVO vo);
	List<PlayReviewVO> select(int playNo);
	int update(PlayReviewVO vo);
	int delete(int playRvNo);
	int deleteByPlayNo(int playNo);
	

}
