package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.ReservatVO;
import edu.spring.hotel.persistence.ReservatDAO;

@Service
public class ReservatServiceImple implements ReservatService{
	private static final Logger logger = 
			LoggerFactory.getLogger(ReservatServiceImple.class);
	
	@Autowired
	private ReservatDAO reservatDAO;

	@Transactional
	@Override
	public int create(ReservatVO vo) throws Exception {
		logger.info("create() 호출 : vo = " + vo.toString());
		return reservatDAO.insert(vo);
	}

	@Override
	public int update(ReservatVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return reservatDAO.update(vo);
	}

	@Override
	public int delete(int reservatNo) {
		logger.info("delete() 호출 : reservatNo = " + reservatNo);
		return reservatDAO.delete(reservatNo);
	}

	@Override
	public List<ReservatVO> read_by_hotelNo(int hotelNo) {
		logger.info("read_by_hotelNo() 호출 : hotelNo = " + hotelNo);
		return reservatDAO.select_by_hotelNo(hotelNo);
	}

	@Override
	public List<ReservatVO> read_by_reservatUserid(String reservatUserid) {
		logger.info("read_by_reservatUserid() 호출 : reservatUserid = " + reservatUserid);
		return reservatDAO.select_by_reservatUserid(reservatUserid);
	}

	@Override
	public ReservatVO read_by_reservatNo(int reservatNo) {
		logger.info("read_by_reservatNo() 호출 : reservatNo = " + reservatNo);
		return reservatDAO.select_by_reservatNo(reservatNo);
	}

	@Override
	public List<ReservatVO> read_by_reservatUserid_hotelNo(int hotelNo, String reservatUserid) {
		logger.info("read_by_reservatUserid_hotelNo() 호출");
		logger.info("hotelNo = " + hotelNo + ", reservatUserid = " + reservatUserid);
		return reservatDAO.select_by_reservatUserid_hotelNo(hotelNo, reservatUserid);
	}
}