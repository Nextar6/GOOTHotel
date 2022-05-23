package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.domain.QuestionVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface QuestionDAO {
	int insert(QuestionVO vo);
	List<QuestionVO> select();
	QuestionVO select(int questionNo);
	int update(QuestionVO vo);
	int delete(int questionNo);
	List<QuestionVO> select(PageCriteria criteria);
	int getTotalCounts();

}
