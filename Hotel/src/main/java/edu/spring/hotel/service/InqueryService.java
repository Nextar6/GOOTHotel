package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface InqueryService {
	int create(InqueryVO vo);
	InqueryVO read(int inqueryNo);
	int update(InqueryVO vo);
	int delete(int inqueryNo);
	List<InqueryVO> read(String memberUserid);
	List<InqueryVO> read(PageCriteria criteria);
	int getTotalCounts();


}
