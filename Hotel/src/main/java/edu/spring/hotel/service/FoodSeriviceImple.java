package edu.spring.hotel.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.FoodDAO;
@Service
public class FoodSeriviceImple implements FoodService {

	private static final Logger logger = LoggerFactory.getLogger(PlayServiceImple.class);

	@Autowired
	private FoodDAO dao;

	@Override
	public int create(FoodVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<FoodVO> read() {
		logger.info("read All 호출 ");
		return dao.select();
	}
	@Override
	public FoodVO read(int foodNo) {
		logger.info("read() 호출 : foodNo = " + foodNo);
		return dao.select(foodNo);
	} // end read

	@Override
	public int update(FoodVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	} // end update
 
	@Override
	public int delete(int foodNo) {
		logger.info("delete() 호출 : playNo = " + foodNo);
		return dao.delete(foodNo);
	} // end delete

	@Override
	public List<FoodVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	} // end getTotalCounts()

}
