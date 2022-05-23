package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.domain.QuestionVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface QuestionService {
	int create(QuestionVO vo);
	List<QuestionVO> read(PageCriteria criteria);
	QuestionVO read(int questionNo);
	int update(QuestionVO vo);
	int delete(int questionNo);
	int getTotalCounts();
}
