package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface HotelService {
	int create(HotelVO vo) throws Exception ;
	int update(HotelVO vo) throws Exception ;
	int delete(int hotelNo);
	int getTotalCount();
	HotelVO read_by_no(int hotelNo);
	List<HotelVO> read_all(PageCriteria criteria);
	List<HotelVO> read_by_title(String hotelTitle);
}
