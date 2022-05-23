package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface HotelDAO {
	int insert(HotelVO vo) throws Exception;
	HotelVO select_by_no(int hotelNo);
	List<HotelVO> select();
	List<HotelVO> select_all(PageCriteria criteria);
	List<HotelVO> select_by_title(String hotelTitle);
	int update(HotelVO vo) throws Exception;
	int delete(int hotelNo);
	int getTotalCount();
}
