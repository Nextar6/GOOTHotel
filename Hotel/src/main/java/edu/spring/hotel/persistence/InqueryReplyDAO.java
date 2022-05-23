package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.InqueryReplyVO;

public interface InqueryReplyDAO {
	int insert(InqueryReplyVO vo);
	List<InqueryReplyVO> select(int inqueryNo);
	int update(InqueryReplyVO vo);
	int delete(int inqueryRpNo);
	

}
