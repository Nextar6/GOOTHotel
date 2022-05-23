package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface AnounceDAO {
	int insert(AnounceVO vo);
	List<AnounceVO> select();
	AnounceVO select(int anounceNo);
	int update(AnounceVO vo);
	int delete(int anounceNo);
	List<AnounceVO> select(PageCriteria criteria);
	int getTotalCounts();
	int searchByWriterCount(String keyword);
	List<AnounceVO> searchByWriter(PageCriteria criteria);
	List<AnounceVO> searchByTitleOrContent(PageCriteria criteria);
	int searchByTitleOrContentCount(String keyword);
	
	

}
