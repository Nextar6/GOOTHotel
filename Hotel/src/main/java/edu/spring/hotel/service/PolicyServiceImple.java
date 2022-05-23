package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.PolicyDAO;

@Service
public class PolicyServiceImple implements PolicyService{

	private static final Logger logger =
			LoggerFactory.getLogger(PolicyServiceImple.class);
	
	@Autowired
	private PolicyDAO dao;
	
	@Override
	public int create(PolicyVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<PolicyVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public PolicyVO read(int policyNo) {
		logger.info("read() 호출 : policyNo = " + policyNo);
		return dao.select(policyNo);
	}

	@Override
	public int update(PolicyVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int policyNo) {
		logger.info("delete() 호출 : policyNo = " + policyNo);
		return dao.delete(policyNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}
	

}
