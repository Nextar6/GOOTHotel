package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.HotelDAO;

@Service
public class HotelServiceImple implements HotelService{
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelServiceImple.class);
	
	@Autowired
	private HotelDAO hotelDAO;
	
	@Transactional
	@Override
	public int create(HotelVO vo) throws Exception {
		logger.info("create() 호출 : vo = " + vo.toString());
		return hotelDAO.insert(vo);
	}

	@Override
	public List<HotelVO> read_all(PageCriteria criteria) {
		logger.info("read_all() 호출");
		return hotelDAO.select_all(criteria);
	}

	@Override
	public List<HotelVO> read_by_title(String hotelTitle) {
		logger.info("read_by_title() 호출 : hotelTitle = " + hotelTitle);
		return hotelDAO.select_by_title(hotelTitle);
	}

	@Override
	public int update(HotelVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return hotelDAO.update(vo);
	}

	@Override
	public int delete(int hotelNo) {
		logger.info("delete() 호출 : hotelNo = " + hotelNo);
		return hotelDAO.delete(hotelNo);
	}

	@Override
	public HotelVO read_by_no(int hotelNo) {
		logger.info("read_by_no() 호출 : hotelNo = " + hotelNo);
		return hotelDAO.select_by_no(hotelNo);
	}

	@Override
	public int getTotalCount() {
		logger.info("getTotalCount() 호출");
		return hotelDAO.getTotalCount();
	}
	

}
