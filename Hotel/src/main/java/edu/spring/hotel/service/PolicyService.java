package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface PolicyService {
	int create(PolicyVO vo);
	List<PolicyVO> read(PageCriteria criteria);
	PolicyVO read(int policyNo);
	int update(PolicyVO vo);
	int delete(int policyNo);
	int getTotalCounts();

}
