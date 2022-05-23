package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReservatVO;

public interface ReservatService {
	int create(ReservatVO vo) throws Exception;
	int update(ReservatVO vo) throws Exception;
	int delete(int reservatNo);
	List<ReservatVO> read_by_hotelNo(int hotelNo);
	List<ReservatVO> read_by_reservatUserid(String reservatUserid);
	ReservatVO read_by_reservatNo(int reservatNo);
	List<ReservatVO> read_by_reservatUserid_hotelNo(int hotelNo, String reservatUserid);
}
