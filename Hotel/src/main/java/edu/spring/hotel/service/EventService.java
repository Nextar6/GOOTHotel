package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface EventService {
	int create(EventVO vo);
	List<EventVO> read(PageCriteria criteria);
	EventVO read(int eventNo);
	int update(EventVO vo);
	int delete(int eventNo);
	int getTotalCounts();
}
