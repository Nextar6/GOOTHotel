package edu.spring.hotel.persistence;

import java.util.List;


import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface InqueryDAO {
	int insert(InqueryVO vo);
	List<InqueryVO> select();
	InqueryVO select(int inqueryNo);
	int update(InqueryVO vo);
	int delete(int inqueryNo);
	List<InqueryVO> select(String memberUserid);
	List<InqueryVO> select(PageCriteria criteria);
	int getTotalCounts();
	List<InqueryVO> selectByTitleOrContent(String keyword);
	int updateReplyCount(int amount, int inqueryNo);


}
