package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface ThemaParkDAO {
	// CRUD
	int insert(ThemaparkVO vo);
	List<ThemaparkVO> select();
	ThemaparkVO select(int themaparkNo);
	int update(ThemaparkVO vo);
	int delete(int ThemaparkNo);
	
	// 페이징
	List<ThemaparkVO> select(PageCriteria criteria);
	int getTotalCounts();
	
	// 검색
	List<ThemaparkVO> searchKeyword(String keyword);
	// 검색어 추천
	List<ThemaparkVO> recommendKeyword(String keyword);
	
	// 리뷰 수 ,평점 카운트
	int updateReplyCount(int amount, int themaparkNo);
	int updateLikeCount(int amount, int themaparkNo);
	
	
	
	
		


}
