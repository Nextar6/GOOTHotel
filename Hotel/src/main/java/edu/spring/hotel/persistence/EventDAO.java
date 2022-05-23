package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface EventDAO {
	int insert(EventVO vo);
	List<EventVO> select();
	EventVO select(int eventNo);
	int update(EventVO vo);
	int delete(int eventNo);
	List<EventVO> select(PageCriteria criteria);
	int getTotalCounts();

}
