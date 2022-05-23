package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface PolicyDAO {
	int insert(PolicyVO vo);
	List<PolicyVO> select();
	PolicyVO select(int policyNo);
	int update(PolicyVO vo);
	int delete(int policyNo);
	List<PolicyVO> select(PageCriteria criteria);
	int getTotalCounts();

}
