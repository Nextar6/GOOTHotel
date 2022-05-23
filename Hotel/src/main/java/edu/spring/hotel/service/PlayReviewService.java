package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.PlayReviewVO;

public interface PlayReviewService {
	int create(PlayReviewVO vo) throws Exception;
	List<PlayReviewVO> read(int playNo);
	int update(PlayReviewVO vo );
	int delete(int playNo, int playRvNo, int playRvLike);

}
