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
	
	// 검색관련
	List<FoodVO> searchKeyword(String keyword);
	
	
	// 댓글 관련
	int updateReplyCount(int amount, int foodNo);
	int updateLikeCount(int amount, int foodNo);
	
	// 검색어 추천
	List<FoodVO> recommendKeyword(String keyword);

}
