package edu.spring.hotel.service;

import java.util.List;


import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;


public interface PlayService {
	int create(PlayVO vo);
	List<PlayVO> read();
	PlayVO read(int playNo);
	int update(PlayVO vo);
	int delete(int playNo);
	List<PlayVO> read(PageCriteria criteria); // 기본 리스트 불러오기
	List<PlayVO> readOrderByReply(PageCriteria criteria); // 댓글 많은순
	List<PlayVO> readOrderByPrice(PageCriteria criteria); // 가격 높,낮은순 
	List<PlayVO> readOrderByLike(PageCriteria criteria); // 평점 높은순
	
	
	List<PlayVO> readByWriter(PageCriteria criteria); // 작성자로 검색
	List<PlayVO> readByTitleOrContent(PageCriteria criteria); // 내용과 제목으로 검색
	int searchByWriterCounts(String keyword);
	int searchByTitleOrCounts(String keyword);
	int getTotalCounts();
	
	// 가격별 정렬

}
