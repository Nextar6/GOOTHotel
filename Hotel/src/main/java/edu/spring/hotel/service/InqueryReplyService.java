package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.InqueryReplyVO;

public interface InqueryReplyService {
	int create(InqueryReplyVO vo) throws Exception;
	List<InqueryReplyVO> read(int inqueryNo);
	int update(InqueryReplyVO vo);
	int delete(int inqueryRpNo, int inqueryNo) throws Exception;
	

}
