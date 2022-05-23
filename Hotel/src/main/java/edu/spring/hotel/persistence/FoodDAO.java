package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface FoodDAO {
	int insert(FoodVO vo);
	List<FoodVO> select();
	FoodVO select(int foodNo);
	int update(FoodVO vo);
	int delete(int foodNo);
	
	// 페이징 관련
	List<FoodVO> select(PageCriteria criteria);
	int getTotalCounts();
	// 정렬 관련
	
	// 댓글 관련
	int updateReplyCount(int amount, int foodNo);
	int updateLikeCount(int amount, int foodNo);

}
