package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface AnounceService {
	int create(AnounceVO vo);
	List<AnounceVO> read(PageCriteria criteria);
	AnounceVO read(int anounceNo);
	int update(AnounceVO vo);
	int delete(int anounceNo);
	int getTotalCounts();
	List<AnounceVO> readByWriter(PageCriteria criteria);
	int searchByWriterCounts(String keyword);

	List<AnounceVO> readByTitleOrContent(PageCriteria criteria);
	int searchByTitleOrCounts(String keyword);

}
