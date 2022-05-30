package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface ThemaparkService {
//	CRUD
	int create(ThemaparkVO vo);
	List<ThemaparkVO> read();
	// 페이징
	List<ThemaparkVO> read(PageCriteria criteria);
	ThemaparkVO read(int themaparkNo);
	int update(ThemaparkVO vo);
	int delete(int themaparkNo);
	
	int getTotalCounts();
	
	// 검색
	List<ThemaparkVO> readReadcommendKeyword(String keyword);
	// 검색어 추천
	List<ThemaparkVO> readSearchKeyword(String keyword);
	

}
