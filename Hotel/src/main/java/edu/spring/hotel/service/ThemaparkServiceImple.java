package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.ThemaParkDAO;

@Service
public class ThemaparkServiceImple implements ThemaparkService{
	
	private static final Logger logger = LoggerFactory.getLogger(ThemaparkServiceImple.class);
	

	@Autowired
	private ThemaParkDAO dao;
			
		
	@Override
	public int create(ThemaparkVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<ThemaparkVO> read() {
		logger.info("read All 호출");
		return dao.select();
	}

	@Override
	public List<ThemaparkVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public ThemaparkVO read(int themaparkNo) {
		logger.info("read() 호출 : themaparkNo = " + themaparkNo);
		return dao.select(themaparkNo);
	} // end read themaparkNo

	@Override
	public int update(ThemaparkVO vo) {
		logger.info("update() 호출 : vo ");
		return dao.update(vo);
	} // end update

	@Override
	public int delete(int themaparkNo) {
		logger.info("delete() 호출 : themaparkNo = " + themaparkNo);
		return dao.delete(themaparkNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}

	@Override
	public List<ThemaparkVO> readReadcommendKeyword(String keyword) {
		logger.info("readRecommendKeyword 호출");
		return dao.recommendKeyword(keyword);
	}

	@Override
	public List<ThemaparkVO> readSearchKeyword(String keyword) {
		logger.info("readSearchKeyword 호출");
		return dao.searchKeyword(keyword);
	}

}
