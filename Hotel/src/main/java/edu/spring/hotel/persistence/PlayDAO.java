package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface PlayDAO {
	int insert(PlayVO vo);
	List<PlayVO> select();
	PlayVO select(int playNo);
	int update(PlayVO vo);
	int delete(int playNo);

	// 기본 페이지
	List<PlayVO> select(PageCriteria criteria);
	// 댓글 많은순 List정렬
	List<PlayVO> selectOrderByReply(PageCriteria criteria);
	// 가격 높은순 and 낮은순
	List<PlayVO> selectOrderByPrice(PageCriteria criteria);
	// 인기순 List 불러오기
	List<PlayVO> selectOrderByLike(PageCriteria criteria);
	
	int getTotalCounts();
	
	int updateReplyCount(int amount, int playNo);
	int updateLikeCount(int amount, int playNo);
//	TODO 게시판 검색기능구현 

}
